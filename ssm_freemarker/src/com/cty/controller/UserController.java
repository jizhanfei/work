package com.cty.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cty.pojo.User;
import com.cty.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;
	@RequestMapping("getAllUser")
	public String getAllUser(Model model){
		List<User> list = userService.getAllUser();
		model.addAttribute("list", list);
		return "userList"; 
	}
	
	@RequestMapping("findUserById")
	public String findUserById(long id,Model model){
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "findById";
	}
	
	@RequestMapping("deleteUserById")
	public String deleteUserById(long id){
		userService.deleteUserById(id);
		return "redirect:/user/getAllUser.do";
	}
	@RequestMapping("updateUser")
	public String updateUser(User user){
		System.out.println(user);
		userService.updateUser(user);
		return "redirect:/user/getAllUser.do";
		
	}
	@RequestMapping("deleSelectedUser")
	public String deleSelectedUser(long[] id){
		for (long i : id) {
			
			userService.deleteUserById(i);
		}
		return "redirect:/user/getAllUser.do";
	}
}
