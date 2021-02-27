package com.myshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.myshop.domain.Product;
import com.myshop.domain.Productinfo;
import com.myshop.dto.UserSession;
import com.myshop.service.ProductService;
import com.myshop.service.ProductinfoService;
import com.myshop.vo.ProductinfoForm;

@Controller
public class ProductinfoController {
	@Autowired
	private ProductinfoService productinfoService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/productinfo")
	public String ProductInfoSave(ProductinfoForm productinfoForm, HttpServletRequest request) {
		
		long id = Long.parseLong(request.getParameter("id"));
		//Color color = Color.valueOf(request.getParameter("color"));
		//Size size = Size.valueOf(request.getParameter("size"));
		
		
		//System.out.println("~~~~~~~~~~~~~~~~~~~~~~" + productinfoForm.getColor());
		//System.out.println(productinfoForm.getColor().getClass().getName());
		
		HttpSession session = request.getSession();
		UserSession userSession = (UserSession)session.getAttribute("user");
		
		//user 가 admin 이 맞는지 검사
		
		Product product = productService.getProduct(id);
		
		Productinfo productinfo = new Productinfo(productinfoForm.getAmount(), productinfoForm.getSize(), productinfoForm.getColor(), productinfoForm.getAdd_price(), product);
		
		productinfoService.saveInfo(productinfo);
		
		return "redirect:/admin/p?id=" + id;
	}
}
