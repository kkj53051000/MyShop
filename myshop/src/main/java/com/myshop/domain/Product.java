package com.myshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
		name = "PRODUCT_SEQ_GENERATOR",
		table = "MYSHOP_SEQUENCES",
		pkColumnValue = "PRODUCT_SEQ", allocationSize = 50)
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "PRODUCT_SEQ_GENERATOR")
	@Column(name = "product_id")
	private long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Category category;
	private String info;
	private int price;
	private String img_src;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Product() {}
	
	public Product(String name, Category category, String info, int price, User user, String img_src) {
		this.name = name;
		this.category = category;
		this.info = info;
		this.price = price;
		this.user = user;
		this.img_src = img_src;
	}
}