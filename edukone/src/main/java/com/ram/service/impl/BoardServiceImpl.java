package com.ram.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.domain.Board;
import com.ram.repository.BoardRepository;
import com.ram.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public List<Board> listBoards() {
		return (List<Board>) boardRepository.findAll();
	}

	@Override
	public void deleteBoards(List<Board> boards) {
		boardRepository.delete(boards);
	}

	@Override
	public void addBoards(List<Board> boards) {
		boardRepository.save(boards);
	}

	@Override
	public void updateBoards(List<Board> boards) {
		// TODO Auto-generated method stub
		
	}

}
