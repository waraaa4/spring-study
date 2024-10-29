package com.example.demo.order.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.order.entity.Order;

import jakarta.transaction.Transactional;

@Transactional //SQL작업결과 commit
public interface OrderRepository extends JpaRepository<Order, Integer> {

	// 날짜를 기준으로 주문이력 조회 (순수 쿼리메소드)
	@Query(nativeQuery = true, value = "select * from tbl_order where order_date = :date")
	List<Order> findByOrderDate(@Param("date") LocalDate date);
	
	// 쿼리 어노테이션 없이 사용 (자동 생성됨)
//	List<Order> findByOrderDate(LocalDate date);
	
	// 날짜를 기준으로 주문이력 삭제 (쿼리메소드, Transactional 어노테이션 필요함)
	@Modifying //@Query 어노테이션을 통해 작성된 변경이 일어나는 쿼리(INSERT, DELETE, UPDATE )를 실행할 때 사용된다.
	void deleteByOrderDate(LocalDate date);
	
}
