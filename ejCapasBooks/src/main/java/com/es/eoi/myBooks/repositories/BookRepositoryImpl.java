package com.es.eoi.myBooks.repositories;

import java.util.ArrayList;
import java.util.List;

import com.es.eoi.myBooks.entities.Book;

public class BookRepositoryImpl implements BookRepository {

	private List<Book> dataBase;

	public BookRepositoryImpl() {
		this.dataBase = new ArrayList<Book>();
	}

	public boolean create(Book newBook) {

		if (newBook != null) {
			return (this.dataBase).add(newBook);
		}

		return false;
	}

	public boolean update(Book newBook) {
		// TODO Auto-generated method stub
		return false;
	}

	public Book read(Book filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> readAll(Book filter) {
		
		List<Book> selectedBooks = new ArrayList<Book>();
		
		if(filter != null) {
			
			for(Book b : dataBase) {
				
				if(filter.getTitle() != null && b.getTitle().equals(filter.getTitle())) {
					selectedBooks.add(b);
				}
				
				
			}
			
		}
		
		return null;
	}

	public boolean delete(Book filter) {
		// TODO Auto-generated method stub
		return false;
	}

}
