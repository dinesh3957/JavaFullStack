package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
 @Id
 @Column(name = "isbn")
 private int isbn;
 
 @Column(name = "title")
 private String title;

 @Column(name = "author")
 private String author;


 @Column(name = "price")
 private double price;
 
 public Book() {
	 
 }

 public Book(int isbn, String title, String author, double price) {
	super();
	this.isbn = isbn;
	this.title = title;
	this.author = author;
	this.price = price;
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

 public String getAuthor() {
	return author;
 }

 public void setAuthor(String author) {
	this.author = author;
 }

 public double getPrice() {
	return price;
 }

 public void setPrice(double price) {
	this.price = price;
 }

 @Override
 public String toString() {
	return "Books [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + "]";
 }
	
 
 
}
