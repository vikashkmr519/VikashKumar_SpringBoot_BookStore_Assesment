package com.vikash.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikash.bookstore.entity.LikedBooks;
import com.vikash.bookstore.repo.LikedBooksRepo;

@Service
public class LikedBooksService {

	@Autowired
	private LikedBooksRepo repo;

	public void insert(LikedBooks books) {

		if (repo.findByUseremailAndBookid(books.getUseremail(),books.getBookid())==null) {
			this.repo.save(books);
		}
	}

	public List<Integer> fetchAllListForUser(String email){
		List<LikedBooks> books = this.repo.findAllByUseremail(email);
		return  books.stream().map(book -> book.getBookid()).collect(Collectors.toList());
		
	}
	public void deleteLb(String email, int bookid) {
		LikedBooks book = this.repo.findByUseremailAndBookid(email,bookid);
		this.repo.delete(book);
	}
}
