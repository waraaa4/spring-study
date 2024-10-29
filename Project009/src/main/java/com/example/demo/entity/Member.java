package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
// BaseEntity를 상속받아 등록일, 수정일 필드 추가
public class Member extends BaseEntity {

	// Not null + Unique
	@Id
	@Column(length = 50)
	String id; // 아이디

	@Column(length = 200, nullable = false)
	String password; // 패스워드

	@Column(length = 100, nullable = false)
	String name; // 이름

}
