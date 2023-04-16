package com.vikash.bookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikash.bookstore.entity.LikedBooks;

public interface LikedBooksRepo extends JpaRepository<LikedBooks, Integer> {

	List<LikedBooks> findAllByUseremail(String useremail);
	
	LikedBooks findByUseremailAndBookid(String useremail, int bookid);

}
