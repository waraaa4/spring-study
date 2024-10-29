package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO: 데이터를 담는 클래스로 뷰단에 전달

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SampleDTO {

	int no; //글번호

    String text; //글내용
    
    LocalDate regDate; //등록일
	
}
