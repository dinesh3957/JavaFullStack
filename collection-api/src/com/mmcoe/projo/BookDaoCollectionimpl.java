package com.mmcoe.projo;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class BookDaoCollectionimpl implements BookDao {

    private List<Book> books;

    public BookDaoCollectionimpl() {
        books = new Vector<>();
    }

    @Override
    public boolean save(Book b) {
        return books.add(b);
    }

    @Override
    public Book find(int isbn) {

        return books.stream()
                .filter(b -> b.getIsbn() == isbn)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> list() {

        return books;
    }

    @Override
    public List<Book> findByPrice(double min, double max) {

        return books.stream()
                .filter(b -> b.getPrice() >= min && b.getPrice() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(int isbn) {

        return books.removeIf(b -> b.getIsbn() == isbn);
    }
}