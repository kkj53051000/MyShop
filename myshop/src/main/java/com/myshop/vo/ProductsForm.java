package com.myshop.vo;

import com.myshop.domain.Category;
import com.myshop.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductsForm {
	private long id;
	private String name;
	private Category category;
	private String price;
	private String img_src;
	private User user;
	
	public ProductsForm() {}
	
	public ProductsForm(long id, String name, Category category, String price, String img_src, User user) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.img_src = img_src;
		this.user = user;
	}
}
