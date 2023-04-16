package com.vikash.bookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikash.bookstore.entity.ReadLater;

public interface ReadLaterRepo extends JpaRepository<ReadLater,Integer> {

	List<ReadLater> findAllByUseremail(String email);
	ReadLater findByUseremailAndBookid(String email, int bookid);
}
