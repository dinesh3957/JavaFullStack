package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jpa.entity.Customer;

public class CustomerDao {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("MyJPA");
    }

    public Customer save(Customer c) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            em.persist(c);

            tx.commit();

            return c;

        } catch (Exception e) {

            e.printStackTrace();

            if (tx.isActive())
                tx.rollback();

            return null;

        } finally {

            em.close();

        }
    }

    public Customer find(int id) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Customer.class, id);

        } finally {

            em.close();

        }

    }

    public List<Customer> list() {

        EntityManager em = emf.createEntityManager();

        try {

            TypedQuery<Customer> query =
                    em.createQuery("from Customer", Customer.class);

            return query.getResultList();

        } finally {

            em.close();

        }

    }

    public Customer update(Customer c) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Customer customer = em.merge(c);

            tx.commit();

            return customer;

        } catch (Exception e) {

            e.printStackTrace();

            if (tx.isActive())
                tx.rollback();

            return null;

        } finally {

            em.close();

        }

    }

    public boolean delete(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Customer c = em.find(Customer.class, id);

            if (c != null) {

                em.remove(c);

            }

            tx.commit();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            if (tx.isActive())
                tx.rollback();

            return false;

        } finally {

            em.close();

        }

    }

}