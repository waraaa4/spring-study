package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class Quiz2 {

	@Autowired
	GiftRepository giftRepository;

	@Test
	public void 리파지토리객체확인() {
		System.out.println(giftRepository);
	}

	// 유틸리티 메서드로 Gift 객체 생성
	public Gift createGift(String name, int price, String type) {
		return Gift.builder().name(name).price(price).type(type).build();
	}

	@Test
	public void 데이터등록() {
		List<Gift> list = new ArrayList<>();

		list.add(createGift("참치세트", 10000, "식품"));
		list.add(createGift("햄세트", 20000, "식품"));
		list.add(createGift("샴푸세트", 30000, "생활용품"));
		list.add(createGift("세차용품", 40000, "생활용품"));
		list.add(createGift("주방용품", 50000, "생활용품"));
		list.add(createGift("노트북", 60000, "가전제품"));
		list.add(createGift("벽걸이TV", 70000, "가전제품"));

		// 등록된 데이터를 저장
		giftRepository.saveAll(list);
	}
	
	@Test
	public void 데이터조회() {
		Optional<Gift> result = giftRepository.findById(1);
		if(result.isPresent()) {
			Gift gift = result.get();
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Gift> list = giftRepository.findAll();
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	@Test
	public void 데이터수정() {
		Optional<Gift> result = giftRepository.findById(1);
		Gift gift = result.get();
		gift.setPrice(500); // 가격수정
		giftRepository.save(gift);
	}
	
	@Test
	public void 데이터삭제() {
		giftRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		giftRepository.deleteAll();
	}

}
