package com.vikash.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vikash.bookstore.dto.RegisterDto;
import com.vikash.bookstore.entity.User;
import com.vikash.bookstore.service.AdminService;
import com.vikash.bookstore.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/register")
	public String register(Map<String,List<String>> roles) {
		roles.put("roles",List.of("ADMIN","USER"));
		return "register";
	}
	
	@PostMapping("/register")
	public String register(RegisterDto dto) {
		System.out.println("role"+dto.getRoleValue() );
		if(dto.getRoleValue().equals("ADMIN")) {
			if(this.adminService.register(dto)) {
				return "redirect:/login";
			}
		}else if(dto.getRoleValue().equals("USER")) {
			if(this.userService.register(dto)) {
				return "redirect:/login";
			}
		}
		
		
		return "redirect:/login?error=invalid";
	}
}
