package com.myshop.vo;

import java.util.List;

import com.myshop.domain.Order;
import com.myshop.domain.OrderStatus;
import com.myshop.domain.Orderinfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class OrderList {
	private Order order;
	private List<Orderinfo> orderinfos;
	
	public OrderList(Order order, List<Orderinfo> orderinfos) {
		this.order = order;
		this.orderinfos = orderinfos;
	}
}

/*

public class OrderList {
	private long order_id;
	private OrderStatus orderStatus;
	private List<OrderForm> orderForm;
	
	public OrderList(long order_id, OrderStatus orderStatus, List<OrderForm> orderForm) {
		this.order_id = order_id;
		this.orderStatus = orderStatus;
		this.orderForm = orderForm;
	}
}


*/