package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.domain.Order;
import com.myshop.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	public void saveOrder(Order order) {
		orderRepository.insertOrder(order);
	}
	
	public Order getOrder(long order_id) {
		Order order = orderRepository.selectOrder(order_id);
		
		return order;
	}
	
	public List<Order> getOrders(long user_id) {
		List<Order> orders = orderRepository.selectOrders(user_id);
		
		return orders;
	}
	
	public void cancelOrder(Order order) {
		orderRepository.deleteOrder(order);
	}
}
