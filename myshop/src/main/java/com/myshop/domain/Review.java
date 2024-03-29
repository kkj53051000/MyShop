package com.myshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@TableGenerator(
		name = "REVIEW_SEQ_GENERATOR",
		table = "MYSHOP_SEQUENCES",
		pkColumnValue = "REVIEW_SEQ", allocationSize = 50)
public class Review {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "REVIEW_SEQ_GENERATOR")
	@Column(name = "review_id")
	private long id;
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "productinfo_id")
	private Productinfo productinfo;
	
	public Review() {}
	
	public Review(String content, User user, Productinfo productinfo) {
		this.content = content;
		this.user = user;
		this.productinfo = productinfo;
	}
}
