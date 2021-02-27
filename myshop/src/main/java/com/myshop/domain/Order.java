package com.myshop.domain;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Getter @Setter
@Table(name = "ORDERS")
@TableGenerator(
		name = "ORDERS_SEQ_GENERATOR",
		table = "MY_SEQUENCES",
		pkColumnValue = "ORDERS_SEQ", allocationSize = 50)
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDERS_SEQ_GENERATOR")
	@Column(name = "order_id")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Order() {}
	
	public Order(User user) {
		this.user = user;
	}
}