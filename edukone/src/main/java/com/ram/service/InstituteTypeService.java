package com.ram.service;

import java.util.List;

import com.ram.domain.Type;

public interface InstituteTypeService {
	
	List<Type> listInstitute_types();
	void deleteInstitute_types(List<Type> institute_types);
	void addInstitute_types(List<Type> institute_types);
	void updateInstitute_types(List<Type> institute_types);



}
