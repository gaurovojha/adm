package com.ram.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ram.domain.Institute;
import com.ram.domain.Type;
import com.ram.helper.InstituteQueryCriteria;
import com.ram.service.InstituteService;

@RestController
public class InstituteController {
	private static final Logger logger = LoggerFactory.getLogger(InstituteController.class);
	@Autowired(required = true)
	private InstituteService instituteService;

	@RequestMapping(value = "/institutes", method = RequestMethod.GET)
	public List<Institute> listInstitutes(Model model) {
		List<Institute> institutes =  instituteService.listInstitutes();
		return institutes;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Institute> searchInstitutes(@RequestParam(name="state") String state) {
		return instituteService.listInstitutesByState(state);
	}
	
	@RequestMapping(value = "/searchByOffering", method = RequestMethod.GET)
	public List<Institute> searchInstitutesByOfferings(@RequestParam(name="offerings") List<Long> offerings) {
		List<Institute> list = instituteService.listInstitutesByOfferings(offerings);
		return instituteService.listInstitutesByOfferings(offerings);
	}
	
	@RequestMapping(value = "/searchByType", method = RequestMethod.GET)
	public List<Institute> searchInstitutesByTypes(@RequestParam(name="types") List<Long> typeIds) {
		List<Type> types = new ArrayList<Type>();
		for(long id : typeIds){
			Type t = new Type();
			t.setId(id);
			types.add(t);
		}
		List<Institute> institutes = instituteService.listInstitutesByTypes(types);
		return institutes;
	}
	
	@RequestMapping(value = "/searchByCity", method = RequestMethod.GET)
	public List<Institute> searchInstitutesByCity(@RequestParam(name="city") long city) {
		List<Institute> institutes = instituteService.listInstitutesByCity(city);
		return institutes;
	}
	
	@RequestMapping(value = "/searchByTypesCity", method = RequestMethod.GET)
	public List<Institute> searchInstitutesByTypesAndCity(@RequestParam(name="types") List<Long> typeIds, @RequestParam(name="city") long city) {
		List<Type> types = new ArrayList<Type>();
		for(long id : typeIds){
			Type t = new Type();
			t.setId(id);
			types.add(t);
		}
		List<Institute> institutes = instituteService.findByTypesAndCityId(types, city);
		return institutes;
	}
	
	@RequestMapping(value = "/testinstitutes", method = RequestMethod.POST)
	public List<Institute> getInstitutes(@RequestBody InstituteQueryCriteria queryCriteria ) {
		List<Institute> institutes = instituteService.getInstitutes(queryCriteria); 
		return institutes;
	}
	@RequestMapping(value = "/testinstitutesThumbnails", method = RequestMethod.POST)
	public List<Institute> getInstituteThumbnails(@RequestBody InstituteQueryCriteria queryCriteria ) {
		List<Institute> institutes = instituteService.getInstitutes(queryCriteria); 
		return institutes;
	}
	
	
}