package com.great.learning.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.great.learning.model.Book;

@Service
public interface BookService {
	List<Book> findAll();

	Book findById(int bookId);

	void save(Book myBook);

	void deleteById(int bookId);

	List<Book> searchBy(String author, String name);
}
