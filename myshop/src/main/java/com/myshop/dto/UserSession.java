package com.myshop.dto;

import com.myshop.domain.Role;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSession {
	private long id;
	private String userid;
	private String nickname;
	private String email;
	private Role role;
	
	public UserSession(long id, String userid, String nickname, String email, Role role) {
		this.id = id;
		this.userid = userid;
		this.nickname = nickname;
		this.email = email;
		this.role = role;
	}
}
