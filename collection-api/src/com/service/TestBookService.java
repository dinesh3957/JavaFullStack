package com.service;

import java.util.Comparator;

import com.mmcoe.projo.Book;
import com.mmcoe.projo.BookDao;
import com.mmcoe.projo.BookDaoCollectionimpl;

public class TestBookService {

	public static void main(String[] args) {
		BookDao dao=new BookDaoCollectionimpl();
		BookService service =new BookServiceImpl(dao);
		
		service.save(new Book (11,"the archei","pais",250));
		service.save(new Book (12,"athe archei","apais",250));
		for (Book b : service.list()) {
			System.out.println(b);
		}
		
		try {
			System.out.println(service.find(11));
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		for(Book b: service.findByPrice(200, 550)) {
			System.out.println(b);
		}
		try {
			service.delete(11);
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.listOrderByTitle().forEach(System.out::println);
		
	}

}
