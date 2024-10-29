package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;


@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 회원등록() {
		Member member = new Member("user1","1234","둘리");
		memberRepository.save(member);
		
		Member member2 = new Member("user2","1234","또치");
		memberRepository.save(member2);
	}
	
	@Test
	public void 회원목록조회() {
		List<Member> list = memberRepository.findAll();
		for(Member member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void 회원단건조회() {
		Optional<Member> result = memberRepository.findById("user1");
		if(result.isPresent()) {
			Member member = result.get();
			System.out.println(member);
		}
	}

	@Test
	public void 회원수정() {
		Optional<Member> result = memberRepository.findById("user1");
		if(result.isPresent()) {
			Member member = result.get();
			// 일부 내용 변경
			member.setName("또치");
			// 데이터 업데이트
			memberRepository.save(member);
		}
	}
	
	@Test
	public void 회원삭제() {
		memberRepository.deleteById("user1");
	}

}
