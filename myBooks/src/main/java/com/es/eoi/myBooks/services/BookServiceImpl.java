package com.es.eoi.myBooks.services;

import java.util.List;

import com.es.eoi.myBooks.entities.Book;
import com.es.eoi.myBooks.repositories.BookRepository;
import com.es.eoi.myBooks.repositories.BookRepositoryImpl;

public class BookServiceImpl implements BookService {

	private BookRepository myRepository;

	public BookServiceImpl() {
		this.myRepository = new BookRepositoryImpl();
	}

	public boolean create(Book newBook) {
		return this.myRepository.create(newBook);
	}

	public boolean update(Book newBook) {
		return this.myRepository.update(newBook);
	}

	public Book read(Book filter) {
		return this.myRepository.read(filter);
	}

	public List<Book> readAll(Book filter) {
		return this.myRepository.readAll(filter);
	}

	public boolean delete(Book filter) {
		return this.myRepository.delete(filter);
	}

}
