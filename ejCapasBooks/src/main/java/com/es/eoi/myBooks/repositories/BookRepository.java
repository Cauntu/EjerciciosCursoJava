package com.es.eoi.myBooks.repositories;

import java.util.List;

import com.es.eoi.myBooks.entities.Book;

public interface BookRepository {

	public boolean create(Book newBook);

	public boolean update(Book newBook);

	public Book read(Book filter);

	public List<Book> readAll(Book filter);

	public boolean delete(Book book);

}
