package com.vikash.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikash.bookstore.entity.User;

public interface UserRepo  extends JpaRepository<User,String>{

}
