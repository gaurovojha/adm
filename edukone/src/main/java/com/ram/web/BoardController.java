package com.ram.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.domain.Board;
import com.ram.service.BoardService;

@RestController
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired(required = true)
	private BoardService boardService;

	@RequestMapping(value = "/boards", method = RequestMethod.GET)
	public List<Board> listBoards() {
		return boardService.listBoards();
	}
	
	@RequestMapping(value = "/boards", method = RequestMethod.PUT)
	public void addBoards(@RequestBody List<Board> boards) {
		 boardService.addBoards(boards);
	}
	
	@RequestMapping(value = "/boards", method = RequestMethod.DELETE)
	public void deleteBoards(@RequestBody List<Board> boards) {
		 boardService.deleteBoards(boards);
	}
	
	
}