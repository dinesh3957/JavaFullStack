package com.mmcoe.projo;

import java.util.List;
import java.util.Vector;

public class BookDaoCollectionimpl implements BookDao {

    private List<Book> books;

    public BookDaoCollectionimpl() {
        books = new Vector<Book>();
    }

    @Override
    public boolean save(Book b) {
        books.add(b);
        return true;
    }

    @Override
    public Book find(int isbn) {

        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                return b;
            }
        }

        return null;
    }

    @Override
    public List<Book> list() {
        return books;
    }

    public List<Book> findByPrice(double min, double max) {

        List<Book> list = new Vector<>();

        for (Book b : books) {
            if (b.getPrice() >= min && b.getPrice() <= max) {
                list.add(b);
            }
        }

        return list;
    }

    @Override
    public boolean delete(int isbn) {

        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                books.remove(b);
                return true;
            }
        }

        return false;
    }
}