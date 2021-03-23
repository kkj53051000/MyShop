package com.myshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Setter @Getter
@TableGenerator(
			name = "PRODUCTINFO_SEQ_GENERATOR",
			table = "MY_SEQUENCES",
			pkColumnValue = "PRODUCTINFO_SEQ", allocationSize = 50)
public class Productinfo {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator =  "PRODUCTINFO_SEQ_GENERATOR")
	@Column(name = "productinfo_id")
	private long id;
	private int amount;
	private int add_price;
	
	@Enumerated(EnumType.STRING)
	private Color color;
	@Enumerated(EnumType.STRING)
	private Size size;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Productinfo() {}
	
	public Productinfo(int amount, Size size, Color color, int add_price, Product product) {
		this.amount = amount;
		this.size = size;
		this.color = color;
		this.add_price = add_price;
		this.product = product;
	}
}
