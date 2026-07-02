package com.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pojo.Book;

public class BookDaoCollectionImpl implements BookDao{

//	private Vector<Book> books;
	private List<Book> books;
	
	public  BookDaoCollectionImpl() {
		
		Stream<String> lines = null;
		
		try {
			lines = Files.lines(Paths.get("src/books.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		books = lines.map(line -> {
			String[] record = line.split(",");
			return new Book(Integer.parseInt(record[0]), record[1], 
					record[2], Double.parseDouble(record[3]));
		}).collect(Collectors.toList());
		
//		books = new Vector<Book>();
	}
	
	@Override
	public boolean save(Book b) {
		books.add(b);
		return true;
	}

	@Override
	public Optional<Book> find(int isbn) {
//		for(Book b : books)
//			if(b.getIsbn() == isbn) {
//				return b;
//			}
//		return null;
		
		return books.stream().filter(b -> b.getIsbn() == isbn).findFirst();
	}

	@Override
	public List<Book> list() {
		return books;
	}

	@Override
	public boolean delete(int isbn) {
		
//		for(Book b : books) {
//			if(b.getIsbn() == isbn) {
//				books.remove(b);
//				return true;
//			}
//		}
//		return false;
		
		return books.removeIf(b -> b.getIsbn() == isbn);
	}

	@Override
	public List<Book> findByPrice(double min, double max) {
		
//		List<Book> result = new Vector<Book>(); 
//		for(Book b : books) {
//			if(b.getPrice() >= min && b.getPrice() <= max) {
//				result.add(b);
//			}
//		}
//		return result;
		
		return books.stream()
							.filter(b -> b.getPrice() > min && b.getPrice() < max)
							.collect(Collectors.toList());
	}
	
	
	
}
