package com.service;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.mmcoe.projo.Book;
import com.mmcoe.projo.BookDao;

public class BookServiceImpl implements BookService {

	private BookDao dao;
	
	public BookServiceImpl(BookDao dao) {
		this.dao=dao;
		
	}
	@Override
	public boolean save(Book b) {
		
		return dao.save(b);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException {
		Book b= dao.find(isbn);
		if(b==null) {
			throw new BookNotFoundException("Book Not Found "+ isbn);
		}
		return b;
	}

	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public boolean delete(int isbn) throws BookNotFoundException {
		if(dao.delete(isbn)) {
			return true;
		}
		else {
			throw new BookNotFoundException("Book Not Found "+ isbn);
		}
		
	}

	@Override
	public List<Book> findByPrice(double min, double max) {
		// TODO Auto-generated method stub
		return dao.findByPrice(min, max);
	}
   public List<Book> listOrderByTitle(){
	   
	   Comparator<Book>nameTitle=(p1,p2)->p1.getTitle().compareTo(p2.getTitle());
	  
	   List<Book>list=dao.list();
	   list.sort(nameTitle);
	   return list;
	   
   }
}
