package com.cty.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cty.mapper.UserMapper;
import com.cty.pojo.User;
import com.cty.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	public List<User> getAllUser() {
		List<User> list = userMapper.findAllUser();
		return list;
	}
	public User findUserById(long id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	public void deleteUserById(long id) {
		userMapper.deleteByPrimaryKey(id);
	}
	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}

}
