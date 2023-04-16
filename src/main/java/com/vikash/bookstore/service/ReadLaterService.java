package com.vikash.bookstore.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikash.bookstore.entity.Book;
import com.vikash.bookstore.entity.ReadLater;
import com.vikash.bookstore.repo.ReadLaterRepo;

@Service
public class ReadLaterService {

	@Autowired
	private ReadLaterRepo repo;
	
	public void insert(ReadLater readLater) {
		if(repo.findByUseremailAndBookid(readLater.getUseremail(),readLater.getBookid())==null) {
			this.repo.save(readLater);
		}
	}
	
	public List<Integer> fetchAllListForUser(String email){
		List<ReadLater> books = this.repo.findAllByUseremail(email);
		return  books.stream().map(book -> book.getBookid()).collect(Collectors.toList());
		
	}
	
	public void deleteLb(String email, int bookid) {
		ReadLater book = this.repo.findByUseremailAndBookid(email,bookid);
		this.repo.delete(book);
	}
}
