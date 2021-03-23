package com.myshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@TableGenerator(
		name = "ORDERINFO_SEQ_GENERATOR",
		table = "MY_SEQUENCES",
		pkColumnValue = "ORDERINFO_SEQ", allocationSize = 50)
public class Orderinfo {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDERINFO_SEQ_GENERATOR")
	@Column(name = "orderinfo_id")
	private long id;
	private int amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productinfo_id")
	private Productinfo productinfo;
	
	
	public Orderinfo() {}
	
	public Orderinfo(int amount, Order order, Productinfo productinfo) {
		this.amount = amount;
		this.order = order;
		this.productinfo = productinfo;
	}
	
}