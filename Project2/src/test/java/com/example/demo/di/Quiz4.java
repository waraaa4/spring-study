package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quiz4 {

	@Autowired
	Manager manager;
	
	@Autowired
	Cafe cafe;
	
//	@Test
//	void 카페메니저주소테스트() {
//		System.out.println("manager: " + manager);
//		System.out.println("cafe: " + cafe);
//	}
	
	@Test
	void 매니저주소확인() {
		System.out.println(manager);
		System.out.println(cafe.manager);
	}
	
}
