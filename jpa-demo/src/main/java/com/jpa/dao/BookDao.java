package com.jpa.dao;

import java.jpa.entity.Book;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jpa.entity.Customer;



public class BookDao {

	 private static EntityManagerFactory emf;
	 static {
	        emf = Persistence.createEntityManagerFactory("MyJPA");
	    }
	 
	   public Book save(Book b) {

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction tx = em.getTransaction();

	        try {

	            tx.begin();

	            em.persist(b);

	            tx.commit();

	            return b;

	        } catch (Exception e) {

	            e.printStackTrace();

	            if (tx.isActive())
	                tx.rollback();

	            return null;

	        } finally {

	            em.close();

	        }
	    }
	   
	   public Book find(int id) {

	        EntityManager em = emf.createEntityManager();

	        try {

	            return em.find(Book.class, id);

	        } finally {

	            em.close();

	        }

	    }
	   
	   public List<Book> list() {

	        EntityManager em = emf.createEntityManager();

	        try {

	            TypedQuery<Book> query =
	                    em.createQuery("from Book", Book.class);

	            return query.getResultList();

	        } finally {

	            em.close();

	        }

	    }
	   
	   
	   public Book update(Book c) {

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction tx = em.getTransaction();

	        try {

	            tx.begin();

	            Book book = em.merge(c);

	            tx.commit();

	            return book;

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

	            Book b = em.find(Book.class, id);

	            if (b != null) {

	                em.remove(b);

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
