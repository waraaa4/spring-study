package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quiz5 {

	@Autowired
	Doctor doctor;
	
	@Autowired
	Hospital hospital;
	
	@Test
	void 병원의사주소확인() {
		System.out.println(doctor);
		System.out.println(hospital.doctor);
	}
	
}
