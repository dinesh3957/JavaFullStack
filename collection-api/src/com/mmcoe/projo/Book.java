package com.mmcoe.projo;

public class Book {

	
		private int isbn;
		private String title,auther;
		private double price;
		
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(int isbn,String title,String auther,double price) {
		
		this.isbn=isbn;
		this.title=title;
		this.auther=auther;
		this.price=price;
		
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", auther=" + auther + ", price=" + price + "]";
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
