package com.ram.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.domain.Facility;
import com.ram.service.FacilityService;

@RestController
public class FacilityController {
private static final Logger logger = LoggerFactory.getLogger(FacilityController.class);
	
	@Autowired(required = true)
	private FacilityService facilityService;

	@RequestMapping(value = "/facilities", method = RequestMethod.GET)
	public List<Facility> listFacilities() {
		return facilityService.listFacilities();
	}
	
	@RequestMapping(value = "/facilities", method = RequestMethod.PUT)
	public void addFacilities(@RequestBody List<Facility> facilities) {
		facilityService.addFacilities(facilities);
	}
	
	@RequestMapping(value = "/facilities", method = RequestMethod.DELETE)
	public void deleteFacilities(@RequestBody List<Facility> facilities) {
		facilityService.deleteFacilities(facilities);
	}
	
}