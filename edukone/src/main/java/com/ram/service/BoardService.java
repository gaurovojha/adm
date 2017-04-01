package com.ram.service;

import java.util.List;

import com.ram.domain.Board;

public interface BoardService {
	
	public List<Board> listBoards();
	void deleteBoards(List<Board> boards);
	void addBoards(List<Board> boards);
	void updateBoards(List<Board> boards);

}
