package com.myshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myshop.domain.Order;
import com.myshop.domain.Orderinfo;
import com.myshop.service.OrderService;
import com.myshop.service.OrderinfoService;

@Controller
public class OrderinfoController {
	@Autowired
	private OrderinfoService orderinfoService;
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orderinfo")
	public String orderinfos(HttpServletRequest request, Model model) {
		
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		
		Order order = orderService.getOrder(order_id);
		
		List<Orderinfo> orderinfos = orderinfoService.getOrderinfos(order_id);
		
		model.addAttribute("orderinfos", orderinfos);
		model.addAttribute("order", order);
		
		return "orderinfo";
	}
}
