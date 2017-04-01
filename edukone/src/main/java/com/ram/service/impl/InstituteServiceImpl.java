package com.ram.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
//import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import com.ram.domain.Institute;
import com.ram.domain.QInstitute;
import com.ram.domain.Type;
import com.ram.dto.InstituteThumbnail;
import com.ram.helper.InstituteQueryCriteria;
import com.ram.repository.InsituteCustomRepository;
import com.ram.repository.InstituteRepository;
import com.ram.service.InstituteService;

@Service
public class InstituteServiceImpl implements InstituteService {

	@Autowired
	private InstituteRepository instituteRepository;

	@Autowired
	private InsituteCustomRepository insituteCustomRepository;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Institute> listInstitutes() {
		return (List<Institute>) instituteRepository.findAll();
	}

	@Override
	public void deleteInstitute(List<Institute> institutes) {
		instituteRepository.delete(institutes);
	}

	@Override
	public void addInstitute(List<Institute> institutes) {
		instituteRepository.save(institutes);
	}

	@Override
	public List<Institute> listInstitutesByState(String state) {
		return null;
	}

	@Override
	public List<Institute> listInstitutesByOfferings(List<Long> offerings) {
		return null;
	}

	@Override
	public List<Institute> listInstitutesByTypes(List<Type> types) {
		return instituteRepository.findByTypes(types);
	}

	@Override
	public List<Institute> findByTypesAndCityId(List<Type> types, long id) {
		Predicate crit = QInstitute.institute.types.any().in(types).and(QInstitute.institute.city().id.eq(id));
		return Lists.newArrayList(instituteRepository.findAll(crit));
		//		return instituteRepository.findByTypesAndCityId(types, id);
	}

	@Override
	public List<Institute> listInstitutesByCity(long id) {
		return instituteRepository.findByCityId(id);
	}

	@Override
	public List<Institute> getInstitutes(InstituteQueryCriteria queryCriteria) {
//		Predicate crit = QInstitute.institute.types.any().in(queryCriteria.getTypes()).and(QInstitute.institute.city().eq(queryCriteria.getCity()).and(QInstitute.institute.offerings.any().in(queryCriteria.getOfferings())));
		if(StringUtils.isEmpty(queryCriteria.getSearchText())){
			Predicate crit = queryCriteria.createPredicate();
			return Lists.newArrayList(instituteRepository.findAll(crit));	
		}
		else{
			return searchVer1(queryCriteria);	
		}
	}

	public List<Institute> search(InstituteQueryCriteria queryCriteria) {
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Institute.class).get();
		org.apache.lucene.search.Query query = queryBuilder.keyword().onFields("name", "city.city").matching(queryCriteria.getSearchText()).createQuery();
		org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Institute.class);
		return jpaQuery.getResultList();
	}

	public List<Institute> searchVer1(InstituteQueryCriteria queryCriteria) {
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Institute.class).get();
		BooleanJunction<BooleanJunction> booleanJunction = queryBuilder.bool();
		if(queryCriteria.getCity()!=null){
			booleanJunction.must(queryBuilder.keyword().onFields("city.city").matching(queryCriteria.getCity().getCity()).createQuery());
		}
		if(!CollectionUtils.isEmpty(queryCriteria.getOfferings())){
			booleanJunction.must(queryBuilder.keyword().onFields("offerings.name").matching(queryCriteria.getOfferings().get(0).getName()).createQuery());
		}
		if(!CollectionUtils.isEmpty(queryCriteria.getTypes())){
			booleanJunction.must(queryBuilder.keyword().onFields("types.name").matching(queryCriteria.getTypes().get(0).getName()).createQuery());
		}
		org.apache.lucene.search.Query combinedQuery = booleanJunction  
				.must(queryBuilder.keyword().onFields("name","city.city").matching(queryCriteria.getSearchText()).createQuery())
				.createQuery();
		org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(combinedQuery, Institute.class);
		return jpaQuery.getResultList();
	}
	
	private List<InstituteThumbnail> populateInstituteThumnail(List<Institute> institutes){
		List<InstituteThumbnail> insThumbnailList = new ArrayList<InstituteThumbnail>();
		for(Institute institute : institutes){
			InstituteThumbnail insThumbnail = new InstituteThumbnail();
			insThumbnail.setName(institute.getName());
			insThumbnail.setDescription(institute.getAboutUs());
			insThumbnail.setLikes(institute.getLikes());
			insThumbnail.setComments(institute.getComments());
			insThumbnailList.add(insThumbnail);
		}
		return insThumbnailList;
	}

	@Override
	public List<InstituteThumbnail> getInstituteThumbnails(InstituteQueryCriteria queryCriteria) {
		if(StringUtils.isEmpty(queryCriteria.getSearchText())){
			Predicate crit = queryCriteria.createPredicate();
			return populateInstituteThumnail(Lists.newArrayList(instituteRepository.findAll(crit)));	
		}
		else{
			return populateInstituteThumnail(searchVer1(queryCriteria));	
		}
	}
}