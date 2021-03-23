package com.myshop.vo;

import java.util.List;

import com.myshop.domain.Color;
import com.myshop.domain.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductSelectForm {
	private Color color;
	private List<Size> sizes;
}
