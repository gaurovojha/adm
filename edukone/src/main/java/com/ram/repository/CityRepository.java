package com.ram.repository;

import org.springframework.data.repository.CrudRepository;

import com.ram.domain.City;


public interface CityRepository extends CrudRepository<City, String> {

}
