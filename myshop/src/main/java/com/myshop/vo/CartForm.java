package com.myshop.vo;

import com.myshop.domain.Product;
import com.myshop.domain.Productinfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartForm {
	private Productinfo productinfo;
	private Product product;
	private int amount;
	
	public CartForm(Productinfo productinfo, Product product, int amount) {
		this.productinfo = productinfo;
		this.product = product;
		this.amount = amount;
	}
}
