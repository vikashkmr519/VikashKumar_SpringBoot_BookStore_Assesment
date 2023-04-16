package com.vikash.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikash.bookstore.entity.Book;
import com.vikash.bookstore.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookrepo;

	public List<Book> getAllBooks() {
		return this.bookrepo.findAll();
	}

	public void insertOrUpdateBook(Book book) {
		this.bookrepo.save(book);
	}

	public void deleteBook(int bookid) {
		this.bookrepo.deleteById(bookid);
	}

	public Book getBookById(int bookId) {
		Optional<Book> opt = this.bookrepo.findById(bookId);
		if (opt.isPresent()) {
			return opt.get();
		}

		return null;
	}

	public List<Book> searchByIdOrAuthor(String searchData) {
		return this.bookrepo.findByBookidOrAuthorname(Integer.valueOf(searchData), searchData);

	}

	public List<Book> searchByAuthor(String authorname) {
		return this.bookrepo.findByAuthorname(authorname);
	}

	public List<Book> booksForBookIds(List<Integer> bookids) {
		return this.bookrepo.findAllById(bookids);

	}

	public List<Book> searchBasedOnFilter(String searchData, String selectValue) {
		List<Book> books = new ArrayList<>();
		System.out.println("Inside search method");
		switch (selectValue) {
		case "PUBLICATION":
			books.addAll(this.bookrepo.findAllByPublication(searchData));
			break;
		case "AUTHORNAME":
			books.addAll(this.bookrepo.findAllByAuthorname(searchData));
			break;
		case "PRICE":
			books.addAll(this.bookrepo.findAllByPrice(searchData));
			break;
		case "BOOKNAME":
			books.addAll(this.bookrepo.findAllByBookname(searchData));
			break;
		case "BOOKID":
			Optional<Book> opt = this.bookrepo.findById(Integer.valueOf(searchData));
			if (opt.isPresent()) {
				books.add(opt.get());
			}

			break;

		}
		return books;
	}

}
