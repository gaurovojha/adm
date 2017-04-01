package com.ram.repository;

import org.springframework.data.repository.CrudRepository;

import com.ram.domain.Board;


public interface BoardRepository extends CrudRepository<Board, String> {

}
