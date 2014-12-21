package com.API01.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.API01.model.Book;
import com.API01.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping({"/index", "/"})
	public String setupForm(Map<String, Object> map){
		Book book = new Book();
		map.put("book", book);
		map.put("bookList", bookService.getAllBooks());
		return "book";
	}
	@RequestMapping(value="/book.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Book book, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Book bookResult = new Book();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			bookService.add(book);
			bookResult = book;
			break;
		case "edit":
			bookService.edit(book);
			bookResult = book;
			break;
		case "delete":
			bookService.delete(book.getBookId());
			bookResult = new Book();
			break;
		case "search":
			Book searchedBook = bookService.getBook(book.getBookId());
			bookResult = searchedBook!=null ? searchedBook : new Book();
			break;
		}
		map.put("book", bookResult);
		map.put("bookList", bookService.getAllBooks());
		return "book";
	}
}
