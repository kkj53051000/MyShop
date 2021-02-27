package com.myshop.vo;

import com.myshop.domain.Color;
import com.myshop.domain.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductinfoForm {
	private Color color;
	private Size size;
	private int amount;
	private int add_price;
	
	public ProductinfoForm() {}
	
	public ProductinfoForm(Color color, Size size, int amount, int add_price) {
		this.color = color;
		this.size = size;
		this.amount = amount;
		this.add_price = add_price;
	}
}
