package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.entity.Book;
import com.greatlearning.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookservice;

	@GetMapping("/books")
	List<Book> getBooks() {
		return bookservice.getBooks();
	}

	@GetMapping("/books/{id}")
	Book getBook(@PathVariable("id") Integer bookId) {
		return bookservice.getBook(bookId);
	}

	@PostMapping("/books")
	void addBook(@RequestBody Book newBook) {
		bookservice.saveBook(newBook);
	}

	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable("id") Integer bookId) {
		bookservice.deleteBook(bookId);
	}

	@GetMapping("/searchBooks")
	List<Book> searchByNameAndAuthor(@RequestParam("name") String name, @RequestParam("author") String author) {
		return bookservice.findByAuthorOrName(author, name);
	}
}
