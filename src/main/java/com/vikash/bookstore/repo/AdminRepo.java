package com.vikash.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikash.bookstore.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,String> {

}
