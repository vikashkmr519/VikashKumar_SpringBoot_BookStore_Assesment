package com.vikash.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikash.bookstore.dto.LoginDto;
import com.vikash.bookstore.dto.RegisterDto;
import com.vikash.bookstore.entity.Admin;
import com.vikash.bookstore.repo.AdminRepo;

@Service
public class AdminService {

	
	@Autowired
	private AdminRepo adminRepo;
	
	public boolean register(RegisterDto dto) {
		Admin admin = new Admin();
		admin.setEmail(dto.getEmail());
		admin.setPassword(dto.getPassword());
		admin.setUsername(dto.getUsername());
		try {
		 this.adminRepo.save(admin);
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	public boolean login(LoginDto dto) {
		Optional<Admin> adminOpt = this.adminRepo.findById(dto.getEmail());
		if(adminOpt.isPresent()) {
			Admin admin = adminOpt.get();
			if(admin.getPassword().equals(dto.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public Admin getAdmin(String email) {
		Optional<Admin> opt = this.adminRepo.findById(email);
		if(opt.isPresent()) {
			return opt.get();
			
		}
		return null;
		
	}
}
