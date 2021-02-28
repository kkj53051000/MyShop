package com.myshop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myshop.domain.Category;
import com.myshop.domain.Product;
import com.myshop.domain.Productinfo;
import com.myshop.domain.User;
import com.myshop.dto.UserSession;
import com.myshop.service.ProductService;
import com.myshop.service.ProductinfoService;
import com.myshop.service.UserService;
import com.myshop.vo.ProductForm;
import com.myshop.vo.ProductsForm;

@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*5,
		maxRequestSize=1024*1024*5*5
)

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductinfoService productinfoService;
	
	@GetMapping("/product-upload")
	public String ProductUploadPage() {
		return "product-upload";
	}
	
	
	@PostMapping("/product/upload")
	public String ProductUpload(ProductForm productForm, HttpServletRequest request, HttpSession session) throws IOException, ServletException {				
		UserSession userSession = (UserSession)session.getAttribute("user");
		
		User user = userService.findUser(userSession.getId());
		
		Part filePart = request.getPart("img");
		String fileName = filePart.getSubmittedFileName();
	
		if(fileName.equals("")) {
			// 사진을 업로드 안했을 경우
		}	
		
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println(realPath.indexOf("webapp"));
		
		String temp = "";
		
		for(int i=0; i < realPath.indexOf("webapp"); i++) {
			temp += realPath.charAt(i);
		}
		
		String publicRealPath = temp + "resources" +  File.separator + "public" + File.separator + "upload" + File.separator;
		
		String filePath = publicRealPath + fileName;
		
		String clientPath = "/public/upload/" + fileName;
		
		InputStream fis = filePart.getInputStream();
		FileOutputStream fos = new FileOutputStream(filePath);
		
		byte[] buffer = new byte[1024];
		
		int size = 0;
		while((size = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, size);
		}
		
		Product product = new Product(productForm.getName(), productForm.getCategory(), productForm.getInfo(), productForm.getPrice(), user, clientPath);
		
		productService.uploadProduct(product);
		
		return "redirect:/";
	}
	
	@GetMapping("/product/list")
	public String Products(HttpServletRequest request, Model model) {
		
		Category category = Category.valueOf(request.getParameter("category"));
		
		if(category == Category.ALL) {
			List<Product> products = productService.getAllProducts();
			
			List<ProductsForm> productsFrom = new ArrayList<ProductsForm>();
			//Product --> ProductsForm (price 1000단위 콤마)
			for(Product product : products) {
			
				String strPrice = NumberFormat.getInstance().format(product.getPrice());
				
				ProductsForm prForm = new ProductsForm(product.getId(), product.getName(), product.getCategory(), strPrice, product.getImg_src(), product.getUser());
				productsFrom.add(prForm);
			}
			
			model.addAttribute("category", category);
			model.addAttribute("products", productsFrom);
			
			return "products";
		}
		
		
		List<Product> products = productService.getProducts(category);
		
		List<ProductsForm> productsFrom = new ArrayList<ProductsForm>();
		//Product --> ProductsForm (price 1000단위 콤마)
		for(Product product : products) {
		
			String strPrice = NumberFormat.getInstance().format(product.getPrice());
			
			ProductsForm prForm = new ProductsForm(product.getId(), product.getName(), product.getCategory(), strPrice, product.getImg_src(), product.getUser());
			productsFrom.add(prForm);
		}
			
		model.addAttribute("category", category);
		model.addAttribute("products", productsFrom);
		
		return "products";
		
	}
	
	
	
	@GetMapping("/product")
	public String ProductPage(HttpServletRequest request, Model model) {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Product product = productService.getProduct(id);
		List<Productinfo> productinfo = productinfoService.getInfos(id);
		
		model.addAttribute("product", product);
		model.addAttribute("productinfo", productinfo);
		
		
		return "product-page";
	}
	
	@GetMapping("/admin/product-list")
	public String ProductDetail(HttpServletRequest request, Model model) {
		
		List<Product> products = productService.getAllProducts();
		
		model.addAttribute("products", products);
		
		return "admin-product-list";
		
	}
	
	@GetMapping("/admin/p")
	public String ProductModify(HttpServletRequest request, Model model) {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Product product = productService.getProduct(id);
		List<Productinfo> productinfos  = productinfoService.getInfos(id);
		
		model.addAttribute("product", product);
		model.addAttribute("productinfos", productinfos);
		
		return "admin-product-modify";
	}

}