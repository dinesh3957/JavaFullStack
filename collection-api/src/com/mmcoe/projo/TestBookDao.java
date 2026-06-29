package com.mmcoe.projo;

public class TestBookDao {

	public static void main(String[] args) {
		Book b1=new Book(101,"build dont talk","dines",100);
		Book b2=new Book(102,"buialk","Rathod",200);
		
		BookDaoCollectionimpl bookdao=new BookDaoCollectionimpl();
		bookdao.save(b1);
		bookdao.save(b2);
		
		System.out.println(bookdao.find(101));
	}

}
