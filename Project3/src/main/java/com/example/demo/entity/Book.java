package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // 엔티티 클래스임을 명시
@Table(name = "tbl_book") // 테이블 이름
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int book_no;
	
	@Column(nullable = false)
	Integer price;
	
	@Column(length = 100, nullable = false)
	String publisher;
	
	@Column(length = 30, nullable = false)
	String title;
}
