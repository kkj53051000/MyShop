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
		name = "REVIEWIMG_SEQ_GENERATOR",
		table = "MYSHOP_SEQUENCES",
		pkColumnValue = "REVIEWIMG_SEQ", allocationSize = 50)
public class Reviewimg {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "REVIEWIMG_SEQ_GENERATOR")
	@Column(name = "reviewimg_id")
	private long id;
	private String img_src;
	
	@ManyToOne
	@JoinColumn(name = "review_id")
	private Review review;
	
	public Reviewimg() {}
	
	public Reviewimg(String img_src, Review review) {
		this.img_src = img_src;
		this.review = review;
	}
}
