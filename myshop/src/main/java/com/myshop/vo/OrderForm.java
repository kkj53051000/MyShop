package com.myshop.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class OrderForm {
	private long productinfo_id;
	private int amount;
	
	public OrderForm(long productinfo_id, int amount) {
		this.productinfo_id = productinfo_id;
		this.amount = amount;
	}
}
