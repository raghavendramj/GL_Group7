package com.great.learning.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.great.learning.model.Book;
import com.great.learning.service.BookService;

@Repository
public class BookServiceImpl implements BookService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	BookServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Book> findAll() {
		List<Book> books = session.createQuery("from Book").list();
		return books;
	}

	@Transactional
	public Book findById(int bookId) {
		Book myBook = session.get(Book.class, bookId);
		return myBook;
	}

	@Transactional
	public void save(Book myBook) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(myBook);
		transaction.commit();
	}

	@Transactional
	public void deleteById(int bookId) {
		Transaction transaction = session.beginTransaction();
		Book myBook = session.get(Book.class, bookId);
		session.delete(myBook);
		transaction.commit();

	}

	@Transactional
	public List<Book> searchBy(String author, String name) {
		String query = "";

		if (name.length() != 0 && author.length() != 0) {
			query = "from Book where name like '%" + name + "%' or author like '%" + author + "%'";
		} else if (name.length() != 0) {
			query = "from Book where name like '%" + name + "%'";
		} else if (author.length() != 0) {
			query = "from Book where author like '%" + author + "%'";
		} else {
			System.out.println("Cannot search without input data!");
		}
		List<Book> books = session.createQuery(query).list();

		return books;
	}

	@Transactional
	public void print(List<Book> books) {
		for (Book book : books) {
			System.out.println(book);
		}
		// Java 8
		// books.stream().forEach(System.out::println);
	}
}
