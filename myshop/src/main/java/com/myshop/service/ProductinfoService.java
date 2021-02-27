package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.domain.Productinfo;
import com.myshop.repository.ProductinfoRepository;
import com.myshop.vo.ProductinfoOrderForm;

@Service
@Transactional
public class ProductinfoService {
	@Autowired
	private ProductinfoRepository productinfoRepository;
	
	
	public void saveInfo(Productinfo productinfo) {
		productinfoRepository.insertInfo(productinfo);
	}
	
	public Productinfo getInfo(long id) {
		Productinfo productinfo = productinfoRepository.selectInfo(id);
		return productinfo;
	}
	
	public List<Productinfo> getInfos(long id){
		List<Productinfo> productinfos = productinfoRepository.selectInfos(id);
		return productinfos;
	}
	
	public void orderInfo(ProductinfoOrderForm productinfoOrderForm) {
		productinfoRepository.orderAmount(productinfoOrderForm);
	}
	
	public void cancelInfo(Productinfo productinfo, int amount) {
		productinfoRepository.cancelAmount(productinfo, amount);
	}
}
