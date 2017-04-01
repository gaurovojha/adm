package com.ram.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.domain.Facility;
import com.ram.repository.FacilityRepository;
import com.ram.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService {
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Override
	public List<Facility> listFacilities() {
		return (List<Facility>) facilityRepository.findAll();
	}

	@Override
	public void deleteFacilities(List<Facility> facilities) {
		facilityRepository.delete(facilities);
	}

	@Override
	public void addFacilities(List<Facility> facilities) {
		facilityRepository.save(facilities);
	}

	@Override
	public void updateFacilities(List<Facility> facilities) {
		// TODO Auto-generated method stub
		
	}

}
