package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service // 서비스 클래스로 지정
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository repository; // 사용할 리파지토리를 멤버로 선언

	// 상속받은 메소드 구현하기
	@Override
	public int register(BoardDTO dto) {

		System.out.println(dto);

		Board entity = dtoToEntity(dto); // 파라미터로 전달받은 dto를 엔티티로 변환
		repository.save(entity); // 리파지토리로 게시물 등록
		int newNo = entity.getNo();

		System.out.println(entity);

		return newNo; // 새로운 게시물의 번호 반환
	}

	// 기존 목록 메소드 삭제
//    @Override
//    public List<BoardDTO> getList() {
//        List<Board> result = repository.findAll(); // 데이터베이스에서 게시물 목록을 가져온다
//        List<BoardDTO> list = new ArrayList<>();
//        list = result.stream() // 리스트에서 스트림 생성
//                .map(entity -> entityToDto(entity)) // 중간연산으로 엔티티를 dto로 변환
//                .collect(Collectors.toList()); // 최종연산으로 결과를 리스트로 변환
//
//        return list; // 화면에 필요한 dto 리스트 반환
//    }

	// 목록 메소드 다시 재정의
	@Override
	public Page<BoardDTO> getList(int pageNumber) {
		// 페이지 번호를 인덱스로 변경. 페이지 인덱스는 0부터 시작됨
		int pageNum = (pageNumber == 0) ? 0 : pageNumber - 1;
		// 페이지번호, 개수, 정렬방식을 입력하여 페이지 정보 생성
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("no").descending());
		// 게시물 목록 조회
		Page<Board> entityPage = repository.findAll(pageable);
		// 스트림을 사용하여 엔티티 리스트를 DTO 리스트로 변환
		Page<BoardDTO> dtoPage = entityPage.map(entity -> entityToDto(entity));

		return dtoPage;
	}

	@Override
	public BoardDTO read(int no) { // 인자로 게시물 번호 받기

		Optional<Board> result = repository.findById(no); // 특정 게시물 정보 가져오기

		if (result.isPresent()) {
			Board board = result.get();
			BoardDTO boardDTO = entityToDto(board); // 엔티티를 DTO로 변환
			return boardDTO; // DTO 반환
		} else {
			return null;
		}

	}

	@Override
	public void modify(BoardDTO dto) {
		// 업데이트 하는 항목은 '제목', '내용'

		// 전달받은 DTO에서 게시물 번호 꺼내고, 해당 게시물 조회
		Optional<Board> result = repository.findById(dto.getNo());
		if (result.isPresent()) { // 해당 게시물이 존재하는지 확인
			Board entity = result.get();

			// 기존 엔티티에서 제목과 내용만 변경
			entity.setTitle(dto.getTitle());
			entity.setContent(dto.getContent());

			// 다시 저장
			repository.save(entity);
		}

	}

	@Override
	public void remove(int no) {

		Optional<Board> result = repository.findById(no);

		// 게시물이 존재하면 삭제
		if (result.isPresent()) {
			repository.deleteById(no);
		}

	}

}
