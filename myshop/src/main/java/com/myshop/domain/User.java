package com.myshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@TableGenerator(
		name = "USER_SEQ_GENERATOR",
		table = "MYSHOP_SEQUENCES",
		pkColumnValue = "USER_SEQ", allocationSize = 50)
public class User {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_SEQ_GENERATOR")
	@Column(name = "user_id")
	private long id;
	private String userid;
	private String userpw;
	private String nickname;
	private String email;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User() {}
	
	public User(String userid, String userpw, String nickname, String email) {
		this.userid = userid;
		this.userpw = userpw;
		this.nickname = nickname;
		this.email = email;
		this.role = Role.USER;
	}
}
