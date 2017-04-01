package com.ram.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.domain.Offering;
import com.ram.service.InstituteOfferingService;

@RestController
public class InstituteOfferingController {
	private static final Logger logger = LoggerFactory.getLogger(InstituteOfferingController.class);

	@Autowired(required = true)
	private InstituteOfferingService instituteOfferingService;

	@RequestMapping(value = "/instituteofferings", method = RequestMethod.GET)
	public List<Offering> listOferings() {
		return instituteOfferingService.listInstitute_offerings();
	}
	
	@RequestMapping(value = "/instituteofferings", method = RequestMethod.PUT)
	public void addOferings(@RequestBody List<Offering> offerings) {
		instituteOfferingService.addInstitute_offerings(offerings);
	}
	
	@RequestMapping(value = "/instituteofferings", method = RequestMethod.DELETE)
	public void deleteOferings(@RequestBody List<Offering> offerings) {
		instituteOfferingService.deleteInstitute_offerings(offerings);
	}
}