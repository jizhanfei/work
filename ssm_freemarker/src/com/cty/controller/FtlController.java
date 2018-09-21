package com.cty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FtlController {
	@RequestMapping("hello")
	public String hello(Model model){
		model.addAttribute("hello", "页面静态化");
		
		return "hello";
	}
}
