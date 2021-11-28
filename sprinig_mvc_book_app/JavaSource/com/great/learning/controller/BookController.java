package com.great.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.great.learning.model.Book;
import com.great.learning.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {

		System.out.println("Inside the BookController -> ");

		// get the books from db;
		List<Book> theBooks = bookService.findAll();

		// add to the spring model
		theModel.addAttribute("Books", theBooks);

		return "list-books";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data.
		Book theBook = new Book();
		theModel.addAttribute("Book", theBook);

		return "Book-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {

		// get the Book from the service
		Book theBook = bookService.findById(theId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Book", theBook);

		// send over to our form
		return "Book-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("category") String category, @RequestParam("author") String author) {

		System.out.println("Trying to save with Id :" + id);

		Book theBook;
		if (id != 0) {
			// Update Operation
			theBook = bookService.findById(id);

			// put updated values to the book object found from database.
			theBook.setName(name);
			theBook.setAuthor(author);
			theBook.setCategory(category);

		} else {
			// Create Operation
			theBook = new Book(name, category, author);
		}

		bookService.save(theBook);
		return "redirect:/books/list";
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam("bookId") int theId) {
		// delete the book
		bookService.deleteById(theId);
		return "redirect:/books/list";
	}

	@GetMapping("/search")
	public String search(@RequestParam("name") String name, @RequestParam("author") String author, Model theModel) {

		if (name.trim().isEmpty() && author.trim().isEmpty())
			return "redirect:/books/list";
		else {
			List<Book> theBooks = bookService.searchBy(author, name);
			theModel.addAttribute("Books", theBooks);
			return "list-books";
		}
	}
}
