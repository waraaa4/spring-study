package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

@Entity
// 엔티티의 변화를 감지하는 리스너 설정
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tbl_board")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int boardNo;
	
	@Column(length = 30, nullable = false)
	String title;
	
	@Column(length = 200) // nullabled의 기본값은 true
	String content;
	
	// 인스턴스가 생성되는 것을 감지하여 현재시간을 저장
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime createdDate; // 최초등록일
	
	// 인스턴스가 생성 또는 수정되는 것을 감지하여 현재시간을 저장
	@LastModifiedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime modifiedDate; // 최종수정일
}
