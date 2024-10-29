package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.order.entity.Order;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.stats.entity.Stats;
import com.example.demo.stats.repository.StatsRepository;

@SpringBootTest
public class StatsRepositoryTest {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	StatsRepository statsRepository;

	@Test
	public void 오늘_총주문건수와금액_구하기() {
		
		// 오늘 날짜
//		LocalDate now = LocalDate.of(2024, 10, 11);
//		LocalDate now = LocalDate.now();

//		// 주문 목록 조회
//		List<Order> list = orderRepository.findAll();
//
//		// 오늘 날짜에 해당되는 리스트 필터링
//		List<Order> filterList = list.stream().filter(entity -> {
//			LocalDate orderDt = entity.getOrderDate();
//			return orderDt.equals(now);
//		}).collect(Collectors.toList());
//
//		for (Order order : filterList) {
//			System.out.println(order);
//		}
//
//		// 전체 건수와 총금액 구하기
//		long count = filterList.stream().count();
//		int totalPrice = filterList.stream().mapToInt(e -> e.getPrice()).sum();

		LocalDate now = LocalDate.of(2024, 10, 11);
		
		// 쿼리메소드 이용해서 오늘 날짜에 해당되는 리스트 구하기
		List<Order> list = orderRepository.findByOrderDate(now);
		
		long count = list.stream().count();
		int totalPrice = list.stream().mapToInt(e -> e.getPrice()).sum();
		
		for (Order order : list) {
			System.out.println(order);
		}
		
		Stats stats = Stats.builder()
							.orderDt(now)
							.count(count)
							.totalPrice(totalPrice)
							.build();
		
		statsRepository.save(stats);
	}

	@Test
	public void 목록조회() {
		List<Stats> list = statsRepository.findAll();
		for (Stats entity : list) {
			System.out.println(entity);
		}
	}

	@Test
	public void 단건조회() {
		LocalDate date = LocalDate.of(2024, 10, 11);
		Optional<Stats> optional = statsRepository.findById(date);
		System.out.println(optional.get());
	}

}
