package com.ram.repository;

import org.springframework.data.repository.CrudRepository;

import com.ram.domain.Facility;


public interface FacilityRepository extends CrudRepository<Facility, String> {

}
