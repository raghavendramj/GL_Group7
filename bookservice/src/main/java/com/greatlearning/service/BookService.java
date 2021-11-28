package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Book;

public interface BookService {

	// CREATE
	void saveBook(Book book);

	// READ
	List<Book> getBooks();

	Book getBook(Integer bookId);

	// UPDATE
	void updateBook(Book book);

	// DELETE
	void deleteBook(Integer bookId);

	//SEARCH
	List<Book> findByAuthorOrName(String author, String name);

}
