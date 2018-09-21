package com.cty.service;

import java.util.List;

import com.cty.pojo.User;

public interface UserService {
	
	public List<User> getAllUser();

	public User findUserById(long id);

	public void deleteUserById(long id);

	public void updateUser(User user);
}
