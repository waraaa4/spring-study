package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService service;

    // 메인화면
    @GetMapping("/main")
    public String main() {
    	return "board/main";
    }

    // 목록화면
    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDTO> list = service.getList(); // 서비스로 게시물 목록 가져오기
        model.addAttribute("list", list); // 화면에 게시물 리스트 전달
    	return "board/list";
    }

    // 등록화면
    @GetMapping("/register")
    public String register() {
    	return "board/register";
    }

    // 등록처리
    @PostMapping("/register")
    // RedirectAttributes은 모델처럼 화면에 데이터를 전달하는 객체
    // 화면에서 전달한 데이터를 파라미터로 수집
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {

        // 게시물 등록하고 새로운 게시물 번호 반환
        int no = service.register(dto);
        
        // 목록화면에 새로운 게시물 번호 전달
        redirectAttributes.addFlashAttribute("msg", no);
        
        // 목록화면으로 이동. HTML경로아님. url주소를 작성할것
        return "redirect:/board/list";
    }

    // 상세화면
    @GetMapping("/read")
    public String read(@RequestParam(name = "no") int no, Model model) {
        BoardDTO dto = service.read(no);
        model.addAttribute("dto", dto);
    	return "board/read";
    }

    // 수정화면
    @GetMapping("/modify")
    public String modify(@RequestParam(name = "no") int no, Model model) {
        BoardDTO dto = service.read(no); // 게시물 번호로 조회
        model.addAttribute("dto", dto); // 화면에 게시물 정보 전달
    	return "board/modify";
    }

    // 수정처리
    @PostMapping("/modify")
    public String modifyPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
        // 게시물 수정
        service.modify(dto);
        // 리다이렉트 주소에 파라미터 추가 (?no=1)
        redirectAttributes.addAttribute("no", dto.getNo());
        // 상세화면으로 이동
        return "redirect:/board/read";
    }

    // 삭제처리
    @PostMapping("/remove")
    public String removePost(int no) {
        service.remove(no);
        return "redirect:/board/list";
    }

}
