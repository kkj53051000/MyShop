package com.myshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myshop.domain.Product;
import com.myshop.domain.Productinfo;
import com.myshop.service.ProductService;
import com.myshop.service.ProductinfoService;
import com.myshop.vo.CartForm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Controller
public class CartController {
	
	@Autowired
	ProductinfoService productinfoService;
	@Autowired
	ProductService productService;
	
	@PostMapping("/cart")
	public String Cart(@RequestBody List<CartRequest> cartRequest ,HttpServletRequest request, HttpSession session) {
		
		List<CartForm> cartForms = new ArrayList<>();
		
		List<CartForm> cartList = (List<CartForm>)session.getAttribute("cartForms");
		
		if(cartList != null) {
			//cartForms = (List<CartForm>)session.getAttribute("cartForms");
			for(int i=0; i<cartList.size(); i++) {
				cartForms.add(cartList.get(i));
			}
		}
		
		for(int i=0; i<cartRequest.size(); i++) {
			
			Productinfo productinfo = new Productinfo();
			productinfo = productinfoService.getInfo(cartRequest.get(i).getProductId());
			
			Product product = productService.getProduct(productinfo.getProduct().getId());
			
			System.out.println("르퍼덕트 ===> " + product);
			
			CartForm cartForm = new CartForm(productinfo, product, cartRequest.get(i).getAmount());
			cartForms.add(cartForm);
		}
		
		for(CartForm c: cartForms) {
			System.out.println(c.getProduct());
		}
		
		
		session.setAttribute("cartForms", cartForms);
		
		
		return "redirect:/cart-page";
	}
	@Getter
	@Setter
	@NoArgsConstructor
	public static class CartRequest{
		long productId;
		int amount;
	}
	
	@GetMapping("/cart-page")
	public String CartPage(HttpServletRequest request, HttpSession session, Model model) {
		
		List<CartForm> cartList = new ArrayList<CartForm>();
		
		System.out.println("==============" + session.getAttribute("cartForms"));
		
		if(session.getAttribute("cartForms") == null) {
			model.addAttribute("cartForms", null);
			
			return "cart-page";
		}
		
		cartList = (List<CartForm>)session.getAttribute("cartForms");
		
		model.addAttribute("cartForms", cartList);
		
		return "cart-page";
	}
	
	
}
