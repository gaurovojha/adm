package com.ram.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.domain.Offering;
import com.ram.repository.OfferingRepository;
import com.ram.service.InstituteOfferingService;

@Service
public class InstituteOfferingServiceImpl implements InstituteOfferingService {
	
	@Autowired
	private OfferingRepository instituteOfferingRepository;
	
	@Override
	public List<Offering> listInstitute_offerings() {
		return (List<Offering>) instituteOfferingRepository.findAll();
	}

	@Override
	public void deleteInstitute_offerings(List<Offering> institute_offerings) {
		instituteOfferingRepository.delete(institute_offerings);
	}

	@Override
	public void addInstitute_offerings(List<Offering> institute_offerings) {
		instituteOfferingRepository.save(institute_offerings);
	}

	@Override
	public void updateInstitute_offerings(List<Offering> institute_offerings) {
		// TODO Auto-generated method stub
		
	}

}
