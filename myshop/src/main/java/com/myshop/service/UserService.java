package com.myshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.domain.User;
import com.myshop.repository.UserRepository;
import com.myshop.vo.UserForm;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void joinUser(User user) {
		userRepository.insertUser(user);
	}
	
	public User loginUser(UserForm userForm) {
		return userRepository.findUserid(userForm);
	}
	
	public User findUser(long id) {
		return userRepository.findUser(id);
	}
}
