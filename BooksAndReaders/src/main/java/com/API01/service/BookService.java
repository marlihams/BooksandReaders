package com.API01.service;

import java.util.List;

import com.API01.model.Book;

public interface BookService {
	public void add(Book book);
	public void edit(Book book);
	public void delete(int bookId);
	public Book getBook(int bookId);
	public List<Book> getAllBooks();
}
