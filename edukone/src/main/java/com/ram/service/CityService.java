package com.ram.service;

import java.util.List;

import com.ram.domain.City;

public interface CityService {
	
	public List<City> listCities();
	void deleteCities(List<City> cities);
	void addCities(List<City> cities);
	void updateCities(List<City> cities);

}
