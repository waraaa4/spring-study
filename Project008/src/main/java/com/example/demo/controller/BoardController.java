package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

	@Autowired // 컨테이너에 등록된 빈 주입받기
	BoardService service;
	
	// 메인화면을 반환하는 메소드
	@GetMapping("/main")
	public void main() {
		
	}
	
//	// 목록화면을 반환하는 메소드
//	@GetMapping("/list") // /board/list
//	public void list(Model model) {
//		
//		// 서비스를 통해 게시물 목록을 가져와서 화면에 전달
//		List<BoardDTO> list = service.getList();
//		
//		// 모델 객체에 데이터 담기
//		model.addAttribute("list", list);
//		
//	}
	
	// 목록 메소드 다시 만들기	
	@GetMapping("/list")
	// 페이지 번호 파라미터 추가 (기본값은 1페이지)
	public void list(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {
		// 게시물 목록 조회
		Page<BoardDTO> list = service.getList(page); 
		// 화면에 게시물 목록과 페이지정보 전달
		model.addAttribute("list", list);	
		System.out.println("전체 페이지 수: " + list.getTotalPages());
		System.out.println("전체 게시물 수: " + list.getTotalElements());
		System.out.println("현재 페이지 번호: " + (list.getNumber() + 1));
		System.out.println("페이지에 표시할 게시물 수: " + list.getNumberOfElements());
	}
		
	// 등록화면을 반환하는 메소드
	@GetMapping("/register")
	public void register() {
		
	}

	// 새로운 게시물을 등록하는 메소드
	@PostMapping("/register") // POST + /board/register
	// 폼데이터를 수집할 때는 어노테이션 없음
	
	// RedirectAttributes: 리다이렉트할 때 데이터를 전달하는 객체 (모델)
	public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		
		//화면에서 전달한 폼데이터를 받아서 데이터베이스에 저장
		//그리고 새로운 게시물번호를 반환받음
		int no = service.register(dto);		
		System.out.println("no:" + no);
		
		// 이동할 화면에 새로운 게시물 번호를 전달
		redirectAttributes.addFlashAttribute("no", no);
		
		// 목록화면으로 리다이렉트
		// 리다이렉트: 새로운 URL을 다시 호출하는 것
		return "redirect:/board/list";
	}
	
	// 상세화면을 반환하는 메소드
	@GetMapping("/read") // /board/read?no=1
	public void read(@RequestParam(name = "no") int no, @RequestParam(defaultValue = "0", name = "page") int page, Model model) {
		
		// 게시물 번호를 파라미터로 전달받아 게시물 정보 조회
		BoardDTO dto = service.read(no);
		
		// 조회한 데이터를 화면에 전달
		model.addAttribute("dto", dto);
		
		// 페이지 번호를 화면에 전달 (가지고 있기)
		model.addAttribute("page", page);
	}
	
	// 수정화면을 반환하는 메소드
	@GetMapping("/modify") // /board/modify?no=1
	public void modify(@RequestParam(name = "no") int no, Model model) {
		
		// 전달받은 게시물 번호로 게시물 정보 조회
		BoardDTO dto = service.read(no);
		
		// 조회한 데이터를 화면에 전달
		model.addAttribute("dto", dto);		
	}
	
	// 수정 처리 메소드
    @PostMapping("/modify")
    public String modifyPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
        
    	// 전달받은 폼데이터로 기존 게시물 수정
        service.modify(dto);
        
        // 상세화면으로 이동할때 파라미터 전달
        redirectAttributes.addAttribute("no", dto.getNo());

        // 상세화면으로 이동
        return "redirect:/board/read";
    }
    //redirectAttributes의 기능
    //addFlashAttribute(): 리다이렉트할 화면에 데이터를 보내는 함수
    //addAttribute(): 리다이렉트 주소에 파라미터를 추가하는 함수
    
    // 삭제 처리 메소드
    @PostMapping("/remove")
    // 폼 데이터 중 단일 항목을 처리할 때는 자동으로 매핑이 안됨
    // @RequestParam을 사용하여 처리
    public String removePost(@RequestParam("no") int no) {
    	
    	// 전달받은 파라미터로 게시물 삭제
    	service.remove(no);
    	
    	// 삭제 후 목록화면으로 이동
        return "redirect:/board/list";
    }
    
    
    
}
