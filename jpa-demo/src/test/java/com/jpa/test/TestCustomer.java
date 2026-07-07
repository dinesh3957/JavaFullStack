package com.jpa.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jpa.dao.CustomerDao;
import com.jpa.entity.Customer;

public class TestCustomer {

    private static CustomerDao dao;

    @BeforeAll
    public static void init() {
        dao = new CustomerDao();
    }

    @Test
    public void testSave() {

        Customer c = new Customer(19, "Dinesh", "Pune");

        assertNotNull(dao.save(c));
        

    }

    @Test
    public void testFind() {

        Customer c = dao.find(1);

        assertNotNull(c);

        System.out.println(c);

    }

    @Test
    public void testList() {

        List<Customer> customers = dao.list();

        assertFalse(customers.isEmpty());

        customers.forEach(System.out::println);

    }

    @Test
    public void testDelete() {

        assertTrue(dao.delete(19));

    }

}