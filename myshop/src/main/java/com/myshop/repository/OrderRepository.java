package com.myshop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.myshop.domain.Order;

@Repository
public class OrderRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertOrder(Order order) {
		em.persist(order);
	}
	
	public Order selectOrder(long order_id) {
		List<Order> orderList = em.createQuery("select o From Order o where o.id = : id", Order.class)
				.setParameter("id", order_id)
				.getResultList();
		
		Order order = orderList.get(0);
		
		return order;
	}
	
	public List<Order> selectOrders(long user_id){
		List<Order> orders = em.createQuery("select o From Order o where o.user.id = : id", Order.class)
				.setParameter("id", user_id)
				.getResultList();
		
		return orders;
	}
	
	public void deleteOrder(Order order) {
		em.remove(order);
	}
}
