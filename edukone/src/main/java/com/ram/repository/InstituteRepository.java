package com.ram.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.ram.domain.Institute;
import com.ram.domain.Type;;

@Transactional
public interface InstituteRepository extends CrudRepository<Institute, String>, QueryDslPredicateExecutor<Institute> {
	List<Institute> findByCityId(long id);

	List<Institute> findByTypes(List<Type> type);

	List<Institute> findByTypesAndCityId(List<Type> type, long id);
}