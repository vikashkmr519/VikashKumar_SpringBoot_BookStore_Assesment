package com.vikash.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vikash.bookstore.entity.Book;
import com.vikash.bookstore.service.BookService;

@Controller
public class AdminController {

	@Autowired
	private BookService bookService;

	@GetMapping("/admin/search/{searchString}")
	public String listSearchedBooksOnAdmin(@PathVariable String searchString, Map<String, List<Book>> map) {
		List<Book> book = new ArrayList<>();
		if (!searchString.isEmpty()) {
			if (searchString.charAt(0) >= 65 && searchString.charAt(0) <= 122) {
				book = this.bookService.searchByAuthor(searchString.toLowerCase());
			} else {
				Book singlebook = this.bookService.getBookById(Integer.valueOf(searchString));
				book.add(singlebook);
			}
			map.put("books", book);

		}
		return "admin";

	}

	@GetMapping("/admin")
	public String getAdminPage(Map<String, List<Book>> map) {
		map.put("books", this.bookService.getAllBooks());
		return "admin";
	}

}
