package com.ram.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.BooleanTemplate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import com.ram.domain.Institute;
import com.ram.domain.QInstitute;
import com.ram.repository.InsituteCustomRepository;

@Repository
public class InsituteCustomRepositoryImpl extends QueryDslRepositorySupport implements InsituteCustomRepository {

	public InsituteCustomRepositoryImpl() {
		super(Institute.class);
	}

	public void test() {

		JPQLQuery query = from(QInstitute.institute).where(Expressions.booleanTemplate("matches({0},{1})", "name", "+testing +search"));
		List<Institute> institutes = query.fetch();

		String wait = "abc";
		//		List<Institute> companies = getQuerydsl(). 
	}
}