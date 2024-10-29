package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quiz2 {

	@Test
	void Car테스트() {
		
		Car car1 = new Car();
		car1.setModel("소나타");
		car1.setCompany("현대");
		car1.setColor("블랙");
		System.out.println(car1.getModel());
		System.out.println(car1.getCompany());
		System.out.println(car1.getColor());
		
		Car car2 = new Car("베뉴","현대","그레이");
		System.out.println(car2);
				
		Car car3 = Car.builder().model("쏘렌토").company("기아").color("레드").build();
		System.out.println(car3);
		
	}
	
}
