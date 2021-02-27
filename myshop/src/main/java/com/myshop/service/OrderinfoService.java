package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.domain.Orderinfo;
import com.myshop.repository.OrderinfoRepository;

@Service
@Transactional
public class OrderinfoService {
	@Autowired
	private OrderinfoRepository orderinfoRepository;
	
	public void saveorderinfo(Orderinfo orderinfo) {
		orderinfoRepository.insertOrderinfo(orderinfo);
	}
	
	public List<Orderinfo> getOrderinfos(long order_id){
		List<Orderinfo> orderinfos = orderinfoRepository.selectOrderinfos(order_id);
		
		return orderinfos;
	}
}
