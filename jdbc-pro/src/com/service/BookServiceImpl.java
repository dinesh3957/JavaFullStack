package com.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.dao.BookDao;
import com.pojo.Book;

public class BookServiceImpl implements BookService {

	private BookDao dao;
	
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}
	
	@Override
	public boolean save(Book b) {
		return dao.save(b);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException {
		
//		Book b = dao.find(isbn);
//		if(b == null) {
//			throw new BookNotFoundException("Book not found with ISBN : " + isbn);
//		}
//		return b;
		
		return dao.find(isbn).orElseThrow(() ->
				new BookNotFoundException("Book not found with ISBN : " + isbn));
	}

	@Override
	public List<Book> list() {
		
		return dao.list();
	}

	@Override
	public boolean delete(int isbn) throws BookNotFoundException {
		
		if(!dao.delete(isbn)) throw new BookNotFoundException("Book not found with ISBN : " + isbn);
		return true;
	}

	@Override
	public List<Book> findByPrice(double min, double max) {
		
		return dao.findByPrice(min, max);
	}

	@Override
	public List<Book> listOrderByTitle() {
		
//		Comparator<Book> titleComp = 
//				(b1, b2) -> b1.getTitle().compareTo(b2.getTitle());
//		
//		List<Book> list = dao.list();
//		list.sort(titleComp);
//		return list;
		
		return dao.list().stream().sorted(
				(b1, b2) -> b1.getTitle().compareTo(b2.getTitle()))
				.collect(Collectors.toList());
	}

}
