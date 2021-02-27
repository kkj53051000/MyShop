package com.myshop.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserForm {
	private String userid;
	private String userpw;
	private String nickname;
	private String email;
	
	public UserForm() {}
	
	public UserForm(String userid, String userpw) {
		this.userid = userid;
		this.userpw = userpw;
	}
	
	public UserForm(String userid, String userpw, String nickname, String email) {
		this.userid = userid;
		this.userpw = userpw;
		this.nickname = nickname;
		this.email = email;
	}
}
