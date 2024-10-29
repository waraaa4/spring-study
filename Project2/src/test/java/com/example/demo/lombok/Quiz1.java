package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quiz1 {

	@Test
	void Book테스트() {
		
		Book book1 = new Book();
		book1.setTitle("북1");
		book1.setPrice(1000);
		book1.setCompany("출판사1");
		book1.setPage(100);
		System.out.println(book1.getTitle());
		System.out.println(book1.getPrice());
		System.out.println(book1.getCompany());
		System.out.println(book1.getPage());
		
		Book book2 = new Book("북2", 2000, "출판사2", 200);
		System.out.println(book2.toString());
		
		Book book3 = Book.builder()
				.title("북3")
				.price(3000)
				.company("출판사3")
				.page(300)
				.build();
		System.out.println(book3);
		
	}
	
}
