package com.es.eoi.myBooks.services;

import java.util.List;

import com.es.eoi.myBooks.entities.Book;

public interface BookService {

	public boolean create(Book newBook);

	public boolean update(Book newBook);

	public Book read(Book filter);

	public List<Book> readAll(Book filter);

	public boolean delete(Book book);

}
