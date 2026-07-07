package com.jpa.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jpa.dao.BookDao;
import com.jpa.entity.Book;



public class TestBook {

    private static BookDao dao;

    @BeforeAll
    public static void init() {
        dao = new BookDao();
    }

    @Test
    public void testSave() {

        Book b = new Book(19, "Dinesh", "Pune",123);

        assertNotNull(dao.save(b));
        

    }

    @Test
    public void testFind() {

        Book b = dao.find(1);

        assertNotNull(b);

        System.out.println(b);

    }

    @Test
    public void testList() {

        List<Book> books = dao.list();

        assertFalse(books.isEmpty());

        books.forEach(System.out::println);

    }

    @Test
    public void testDelete() {

        assertTrue(dao.delete(19));

    }

}