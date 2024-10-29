package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	// 필요한 객체를 주입받는 방식
	@Autowired
	Chef chef;
	
	public Chef getChef() {
		return chef;
	}

}
