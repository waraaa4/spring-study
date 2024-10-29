package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest3 {

	@Autowired
	MemoRepository2 memoRepository2;
	
	@Test
	public void 번호가3보다작은_메모검색() {
		List<Memo> list =  memoRepository2.get1(3);
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 내용이없는_메모검색() {
		List<Memo> list = memoRepository2.get2();
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가10와20사이인메모검색() {
		List<Memo> list = memoRepository2.get3(10, 20);
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호를기준으로역정렬한_메모검색() {
		List<Memo> list = memoRepository2.get4();
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터삭제() {
		memoRepository2.delete1(15);
	}
	
	@Test
	public void 데이터수정() {
		//조회
		Optional<Memo> result = memoRepository2.findById(20);
		Memo memo = result.get();
		
		// 일부 변경
		memo.setText("변경했습니다~");
		
		// 수정
		memoRepository2.update1(memo);
	}
	
}
