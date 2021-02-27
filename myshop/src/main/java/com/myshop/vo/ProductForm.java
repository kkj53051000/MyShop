package com.myshop.vo;

import com.myshop.domain.Category;
import com.myshop.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductForm {
	private String name;
	private Category category;
	private String info;
	private int price;
	private User user;
	
	public ProductForm(String name, Category category, String info, int price, User user) {
		this.name = name;
		this.category = category;
		this.info = info;
		this.price = price;
		this.user = user;
	}
}
