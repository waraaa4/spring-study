package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quiz6 {

	@Autowired
	Teacher teacher;
	
	@Test
	void 선생님테스트() {
		teacher.teach();
	}
	
}
