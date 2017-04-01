package com.ram.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.domain.Type;
import com.ram.repository.TypeRepository;
import com.ram.service.InstituteTypeService;

@Service
public class InstituteTypeSerivceImpl implements InstituteTypeService {
	
	@Autowired
	private TypeRepository instituteTypeRepository;
	
	@Override
	public List<Type> listInstitute_types() {
		return (List<Type>) instituteTypeRepository.findAll();
	}

	@Override
	public void deleteInstitute_types(List<Type> institute_types) {
		instituteTypeRepository.delete(institute_types);
	}

	@Override
	public void addInstitute_types(List<Type> institute_types) {
		instituteTypeRepository.save(institute_types);
	}

	@Override
	public void updateInstitute_types(List<Type> institute_types) {
		// TODO Auto-generated method stub
		
	}

}
