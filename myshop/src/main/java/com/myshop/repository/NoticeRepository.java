package com.myshop.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.myshop.domain.Notice;

@Repository
public class NoticeRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertNotice(Notice notice) {
		em.persist(notice);
	}
	
	public List<Notice> selectAllNotices(){
		List<Notice> notices = em.createQuery("select n From Notice n", Notice.class)
				.getResultList();
		
		return notices;
	}
}
