package com.greatlearning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.Book;
import com.greatlearning.repository.BookRepository;
import com.greatlearning.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	public Book getBook(Integer bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);

		if (optionalBook.isPresent())
			return optionalBook.get();
		else
			return null;
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBook(Integer bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (optionalBook.isPresent())
			bookRepository.delete(optionalBook.get());
	}

	public List<Book> findByAuthorOrName(String author, String name) {
		return bookRepository.findByAuthorOrName(author, name);
	}

}
