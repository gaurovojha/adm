package com.ram.helper;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.util.CollectionUtils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.ram.domain.City;
import com.ram.domain.Offering;
import com.ram.domain.QInstitute;
import com.ram.domain.Type;
import com.ram.domain.QInstitute;
public class InstituteQueryCriteria {
	private List<Offering> offerings;
	private List<Type> types;
	private City city;
	private String zipCode;
	private Date establishedOn;
	private String searchText;
	
	public List<Offering> getOfferings() {
		return offerings;
	}

	public void setOfferings(List<Offering> offerings) {
		this.offerings = offerings;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Date getEstablishedOn() {
		return establishedOn;
	}

	public void setEstablishedOn(Date establishedOn) {
		this.establishedOn = establishedOn;
	}

	public Predicate createPredicate(){
		BooleanBuilder builder = new BooleanBuilder();
		if(!CollectionUtils.isEmpty(this.getTypes())){
			builder.and(QInstitute.institute.types.any().in(this.getTypes()));
		}
		if(this.getCity()!=null){
			builder.and(QInstitute.institute.city().eq(this.getCity()));
		}
		if(!CollectionUtils.isEmpty(this.getOfferings())){
			builder.and(QInstitute.institute.offerings.any().in(this.getOfferings()));
		}
		return builder;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
}