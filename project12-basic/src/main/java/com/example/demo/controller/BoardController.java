package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

// @Controller + @ResponseBody
// @Controller: 해당 클래스를 컨트롤러로 지정
// @ResponseBody: 하위 메소드의 응답형식을 json으로 설정
// 응답형식: HTML파일, JSSON데이터, TEXT데이터 ..
@RestController
public class BoardController {

	@Autowired
	BoardService boardService;
	
	// 새로운 게시물을 등록하는 메소드
	// ResponseEntity: 응답 메세지의 헤더와 바디를 직접설정하는 클래스
	public ResponseEntity<Integer> register(BoardDTO dto) {
		// 게시물 등록후 새로운 번호 반환
		int no = boardService.register(dto);
		// 인자: 데이터, 응답코드
		// 응답코드는 201, 데이터는 새로운 게시물 번호
		return new ResponseEntity<>(no, HttpStatus.CREATED);
	}
	
}
