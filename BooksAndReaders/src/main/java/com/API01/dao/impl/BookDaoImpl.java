package com.API01.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.API01.dao.BookDao;
import com.API01.model.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Book book) {
		session.getCurrentSession().save(book);
	}

	@Override
	public void edit(Book book) {
		session.getCurrentSession().update(book);
	}

	@Override
	public void delete(int bookId) {		
		session.getCurrentSession().delete(getBook(bookId));
	}

	@Override
	public Book getBook(int bookId) {
		return (Book)session.getCurrentSession().get(Book.class, bookId);
	}

	@Override
	public List getAllBooks() {
		return session.getCurrentSession().createQuery("from Book").list();
	}

}
