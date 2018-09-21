package com.cty.service;

import com.cty.domain.User;


public interface IUserService {
	public User login(User model);
	public void editPassword(String password,String id);
}
