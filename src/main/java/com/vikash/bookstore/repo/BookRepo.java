package com.vikash.bookstore.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikash.bookstore.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
	
	List<Book> findByBookidOrAuthorname(int id , String authorname);
	List<Book> findByAuthorname(String authorname);
	
	List<Book> findAllByPublication(String searchData);
	List<Book> findAllByAuthorname(String searchData);
	List<Book> findAllByPrice(String searchData);
	List<Book> findAllByBookname(String searchData);

}
