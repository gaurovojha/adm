package com.ram.service;

import java.util.List;

import com.ram.domain.Offering;

public interface InstituteOfferingService {
	
	List<Offering> listInstitute_offerings();
	void deleteInstitute_offerings(List<Offering> institute_offerings);
	void addInstitute_offerings(List<Offering> institute_offerings);
	void updateInstitute_offerings(List<Offering> institute_offerings);


}
