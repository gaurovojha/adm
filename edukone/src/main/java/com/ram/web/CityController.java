package com.ram.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.domain.City;
import com.ram.service.CityService;

@RestController
public class CityController {
	
	private static final Logger logger = LoggerFactory.getLogger(CityController.class);
	
	@Autowired(required = true)
	private CityService cityService;

	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	public List<City> listCities() {
		return cityService.listCities();
	}
	
	@RequestMapping(value = "/cities", method = RequestMethod.PUT)
	public void addCities(@RequestBody List<City> cities) {
		cityService.addCities(cities);
	}
	
	@RequestMapping(value = "/cities", method = RequestMethod.DELETE)
	public void deleteCities(@RequestBody List<City> cities) {
		cityService.deleteCities(cities);
	}
	
}