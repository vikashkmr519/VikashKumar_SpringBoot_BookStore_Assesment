package com.vikash.bookstore.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vikash.bookstore.entity.Book;
import com.vikash.bookstore.entity.LikedBooks;
import com.vikash.bookstore.entity.ReadLater;
import com.vikash.bookstore.service.BookService;
import com.vikash.bookstore.service.LikedBooksService;
import com.vikash.bookstore.service.ReadLaterService;

@Controller
public class DashboardController {

	@Autowired
	private BookService bookService;

	@Autowired
	private ReadLaterService rlService;

	@Autowired
	private LikedBooksService lbService;
	
	@GetMapping("/dashboard/search")
	public String searchBasedOnFilter(@RequestParam("searchData")String searchData, @RequestParam("selectValue")String selectValue,Map<String, List<Book>> map) {
		List<Book> books  = this.bookService.searchBasedOnFilter(searchData,selectValue);
		map.put("books", books);
		return "dashboard";
	}

	@GetMapping("/dashboard")
	public String dashboard(Map<String, List<Book>> map) {
		map.put("books", this.bookService.getAllBooks());
		return "dashboard";
	}

	@GetMapping("/likedbook/delete")
	public String deleteFromLikedBook(@RequestParam("bookid") Integer bookid, HttpSession session) {

		lbService.deleteLb(session.getAttribute("email").toString(), bookid);
		return "redirect:/likedbook/page";

	}

	@GetMapping("/readlater/delete")
	public String deleteFromReadLater(@RequestParam("bookid") Integer bookid, HttpSession session) {

		rlService.deleteLb(session.getAttribute("email").toString(), bookid);
		return "redirect:/readlater/page";

	}

	@GetMapping("/likedbook/page")
	public String openLikedBooks(Map<String, List<Book>> map, HttpSession session) {
		if (session != null) {
			if (session.getAttribute("email") != null) {
				List<Integer> listOfBookId = this.lbService
						.fetchAllListForUser(session.getAttribute("email").toString());
				map.put("books", bookService.booksForBookIds(listOfBookId));
			}
		}
		return "likedbooks";

	}

	@GetMapping("/readlater/page")
	public String openReadLater(Map<String, List<Book>> map, HttpSession session) {
		if (session != null) {
			if (session.getAttribute("email") != null) {
				List<Integer> listOfBookId = this.rlService
						.fetchAllListForUser(session.getAttribute("email").toString());

				map.put("books", bookService.booksForBookIds(listOfBookId));
			}
		}
		return "readlater";
	}

	@GetMapping("/readlater")
	public String insertInReadLater(@RequestParam("bookid") Integer bookid, HttpSession session) {

		ReadLater rl = new ReadLater();
		rl.setBookid(bookid);
		rl.setUseremail(session.getAttribute("email").toString());
		rlService.insert(rl);
		return "redirect:/dashboard";

	}
	
	@GetMapping("/likedbook")
	public String insertIntoLikedBook(@RequestParam("bookid")Integer bookid, HttpSession session) {
		LikedBooks books = new LikedBooks();
		books.setBookid(bookid);
		books.setUseremail(session.getAttribute("email").toString());
		lbService.insert(books);
		return "redirect:/dashboard";
		
	}

}
