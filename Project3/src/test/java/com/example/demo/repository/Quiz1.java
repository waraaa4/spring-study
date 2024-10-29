package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class Quiz1 {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 리파지토리객체확인() {
		System.out.println("bookRepository = " + bookRepository);
	}
	
	@Test
	public void 책등록() {
		Book book = Book
				.builder()
				.price(20000)
				.publisher("한빛출판사")
				.title("자바프로그래밍입문")
				.build();
		bookRepository.save(book);
	}
	
	@Test
	public void 책일괄등록() {
		List<Book> books = new ArrayList<>();
		Book book1 = Book
				.builder()
				.price(20000)
				.publisher("한빛출판사")
				.title("자바프로그래밍입문")
				.build();
		Book book2 = Book
				.builder()
				.price(20000)
				.publisher("남가람북스")
				.title("스프링부트프로젝트")
				.build();
		Book book3 = Book
				.builder()
				.price(20000)
				.publisher("한빛출판사")
				.title("실무로 끝내는 PHP")
				.build();
		Book book4 = Book
				.builder()
				.price(20000)
				.publisher("이지스퍼블리싱")
				.title("알고리즘코딩테스트")
				.build();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		bookRepository.saveAll(books);
	}
	
	@Test
	public void 책조회() {
		Optional<Book> optional =  bookRepository.findById(1);
		if(optional.isPresent()) {
			System.out.println(optional.get());
		} else {
			System.out.println("값이 없습니다");
		}
	}
	
	@Test
	public void 책전체조회() {
		List<Book> books = bookRepository.findAll();
		for(Book book : books) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 책정보수정() {
		Optional<Book> result =  bookRepository.findById(1);
		Book book = result.get();
		// 가격수정
		book.setPrice(10000);
		bookRepository.save(book);
	}
	
	@Test
	public void 책삭제() {
		bookRepository.deleteById(1);
	}
	
	@Test
	public void 책전체삭제() {
		bookRepository.deleteAll();
	}
	
	
}
