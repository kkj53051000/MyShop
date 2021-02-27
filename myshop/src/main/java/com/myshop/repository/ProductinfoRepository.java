package com.myshop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.myshop.domain.Productinfo;
import com.myshop.vo.ProductinfoOrderForm;

@Repository
public class ProductinfoRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertInfo(Productinfo productinfo) {
		em.persist(productinfo);
	}
	
	public Productinfo selectInfo(long id) {
		Productinfo productinfo = em.find(Productinfo.class, id);
		
		return productinfo;
	}
	
	public List<Productinfo> selectInfos(long id) {
		List<Productinfo> productinfos = em.createQuery("select p From Productinfo p where p.product.id = :id", Productinfo.class)
				.setParameter("id", id)
				.getResultList();
		
		return productinfos;
	}
	
	public void orderAmount(ProductinfoOrderForm productinfoOrderForm) {
		Productinfo productinfo = productinfoOrderForm.getProductinfo();
		
		int thisAmount  = productinfo.getAmount();
		
		int modifyAmount = thisAmount - productinfoOrderForm.getAmount();
		
		productinfo.setAmount(modifyAmount);
	}
	
	public void cancelAmount(Productinfo productinfo, int amount) {
		int thisAmount  = productinfo.getAmount();
		
		int modifyAmount = thisAmount + amount;
		
		productinfo.setAmount(modifyAmount);
	}
}
