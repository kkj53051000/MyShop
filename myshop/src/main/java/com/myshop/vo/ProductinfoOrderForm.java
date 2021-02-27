package com.myshop.vo;

import com.myshop.domain.Productinfo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductinfoOrderForm {
	private Productinfo productinfo;
	private int amount;
	
	public ProductinfoOrderForm() {}
	
	public ProductinfoOrderForm(Productinfo productinfo, int amount){
		this.productinfo = productinfo;
		this.amount = amount;
	}
}
