package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 스프링 컨테이너 환경
public class PersonTest {
	
	@Test // 단위 테스트
	void 롬복테스트() {
		
		Person person1 = new Person(); // 디폴트생성자
		person1.setName("둘리"); // setter
		person1.setAge(12);
		System.out.println(person1.getName()); // getter
		System.out.println(person1.getAge());
		
		// 모든 멤버를 입력받는 생성자
		Person person2 = new Person("또치", 15);
		// 재정의된 toString
		System.out.println(person2.toString());
		
		// builder: 메소드 체인 패턴으로 객체를 생성하는 생성자
		// 값을 선택하여 입력할 수 있음
		// 준비.필드.필드.객체생성
		Person person3 = Person.builder().name("도우너").age(17).build();
		System.out.println(person3);
		
	}

}
