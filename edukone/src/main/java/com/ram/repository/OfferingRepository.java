package com.ram.repository;

import org.springframework.data.repository.CrudRepository;

import com.ram.domain.Offering;


public interface OfferingRepository extends CrudRepository<Offering, String> {

}
