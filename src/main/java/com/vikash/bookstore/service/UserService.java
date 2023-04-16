package com.vikash.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikash.bookstore.dto.LoginDto;
import com.vikash.bookstore.dto.RegisterDto;
import com.vikash.bookstore.entity.User;
import com.vikash.bookstore.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public boolean validateUser(LoginDto dto) {
		return true;
	}

	public boolean register(RegisterDto dto) {
		
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setUsername(dto.getUsername());
		try {
			this.userRepo.save(user);
		} catch (Exception ex) {
			return false;
		}
		return true;

	}

	public User getUser(String email) {
		Optional<User> userOpt = this.userRepo.findById(email);
		if (userOpt.isPresent()) {
			return userOpt.get();
		}
		return null;
	}

}
