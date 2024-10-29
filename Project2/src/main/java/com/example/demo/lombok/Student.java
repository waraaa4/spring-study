package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class Student {
	int studentId; //학번
	String studentName; //이름
	int age; //나이
}
