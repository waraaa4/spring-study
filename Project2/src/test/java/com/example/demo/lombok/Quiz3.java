package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quiz3 {

	@Test
	void Student테스트() {
		
		Student student1 = new Student();
		student1.setStudentId(1001);
		student1.setStudentName("둘리");
		student1.setAge(15);
		System.out.println(student1.getStudentId());
		System.out.println(student1.getStudentName());
		System.out.println(student1.getAge());

		Student student2 = new Student(1002, "또치", 16);
		System.out.println(student2.toString());

		// builder는 순서를 자유롭게 입력할 수 있음
		Student student3 = Student.builder().studentName("도우너").studentId(1003).age(17).build();
		System.out.println(student3.toString());
		
	}
	
}
