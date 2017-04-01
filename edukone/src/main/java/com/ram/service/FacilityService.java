package com.ram.service;

import java.util.List;

import com.ram.domain.Facility;

public interface FacilityService {
	
	List<Facility> listFacilities();
	void deleteFacilities(List<Facility> facilities);
	void addFacilities(List<Facility> facilities);
	void updateFacilities(List<Facility> facilities);


}
