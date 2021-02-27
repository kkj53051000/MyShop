package com.myshop.vo;

import com.myshop.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NoticeForm {
	private String title;
	private String content;
	private User user;
	
	public NoticeForm() {}
	
	public NoticeForm(String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.user = user;
	}
}
