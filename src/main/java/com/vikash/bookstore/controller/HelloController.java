package com.vikash.bookstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.vikash.bookstore.entity.Book;
import com.vikash.bookstore.service.BookService;

@Controller
public class HelloController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String getHello(Map<String, List<Book>> map) {
		
		map.put("books", this.bookService.getAllBooks());
		return "index";
	}
}
