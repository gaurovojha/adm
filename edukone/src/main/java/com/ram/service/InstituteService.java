package com.ram.service;

import java.util.List;

import com.ram.domain.Institute;
import com.ram.domain.Type;
import com.ram.dto.InstituteThumbnail;
import com.ram.helper.InstituteQueryCriteria;

public interface InstituteService {

	List<Institute> listInstitutes();

	void deleteInstitute(List<Institute> institutes);

	void addInstitute(List<Institute> institutes);

	List<Institute> listInstitutesByState(String state);

	List<Institute> listInstitutesByOfferings(List<Long> offerings);

	List<Institute> listInstitutesByTypes(List<Type> types);

	List<Institute> findByTypesAndCityId(List<Type> types, long id);
	
	List<Institute> listInstitutesByCity(long id);
	
	List<Institute> getInstitutes(InstituteQueryCriteria queryCriteria);
	
	List<InstituteThumbnail> getInstituteThumbnails(InstituteQueryCriteria queryCriteria);
}