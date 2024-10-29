package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class Quiz3 {

	@Autowired
	OrderRepository orderRepository;
	
	public Order addOrder(String customerName, LocalDate orderDate, String shipAddress) {
	    return Order.builder()
	                .customerName(customerName)
	                .orderDate(orderDate)
	                .shipAddress(shipAddress)
	                .build();
	}
	
	@Test
	public void 데이터등록() {
		List<Order> orders = new ArrayList<>();
		LocalDate localDate1 = LocalDate.of(2023,7,1);
		LocalDate localDate2 = LocalDate.of(2023,7,2);
		LocalDate localDate3 = LocalDate.of(2023,7,3);
		orders.add(addOrder("둘리", localDate1, "인천 구월동"));
		orders.add(addOrder("또치", localDate2, "인천 연수동"));
		orders.add(addOrder("도우너", localDate3, "부산 동래동"));
		orders.add(addOrder("마이콜", localDate1, null));
		orders.add(addOrder("고길동", localDate2, null));
		orderRepository.saveAll(orders);
	}
	
	@Test
	public void 데이터조회() {
		Optional<Order> result = orderRepository.findById(1);
		if(result.isPresent()) {
			Order order = result.get();
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Order> list = orderRepository.findAll();
		for(Order order : list) {
			System.out.println(order);
		}
	}

	@Test
	public void 데이터수정() {
		Optional<Order> result = orderRepository.findById(1);
		Order order = result.get();
		order.setShipAddress("서울 신림동"); // 주소수정
		orderRepository.save(order);
	}

	@Test
	public void 데이터삭제() {
		orderRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		orderRepository.deleteAll();
	}
	
}
