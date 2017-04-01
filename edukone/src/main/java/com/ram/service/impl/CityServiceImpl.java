package com.ram.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.domain.City;
import com.ram.repository.CityRepository;
import com.ram.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> listCities() {
		return (List<City>) cityRepository.findAll();
	}

	@Override
	public void deleteCities(List<City> cities) {
		cityRepository.delete(cities);
	}

	@Override
	public void addCities(List<City> cities) {
		cityRepository.save(cities);
	}

	@Override
	public void updateCities(List<City> cities) {
		// TODO Auto-generated method stub

	}

}