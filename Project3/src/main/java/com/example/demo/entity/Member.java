package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tbl_member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
	@Id
	String userId; // 회원아이디
	
	@Column(nullable = false)
	String grade; // 등급

	@Column(nullable = false)
	String password; // 패스워드

	@CreatedDate // 가입일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	LocalDate registerDate; 
}
