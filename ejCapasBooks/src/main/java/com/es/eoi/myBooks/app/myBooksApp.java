package com.es.eoi.myBooks.app;

import com.es.eoi.myBooks.entities.Book;
import com.es.eoi.myBooks.services.BookService;
import com.es.eoi.myBooks.services.BookServiceImpl;

public class myBooksApp {

	public static void main(String[] args) {

		BookService myService = new BookServiceImpl();

		myService.create(new Book("The Hobbit", "Tolkien"));
		myService.create(new Book("The Lord of the Rings", "Tolkien"));
		myService.create(new Book("Harry Potter", "JK Rowling"));
		myService.create(new Book("Sherlock Holmes", "Arthur Conan Doyle"));
		
		
		for(Book b : myService.readAll(new Book("Sherlock Holmes", "null"))) {
			System.out.println(b);
		}
		
		myService.delete(new Book("Sherlock Holmes", "null"));
		
		for(Book b : myService.readAll(new Book("Sherlock Holmes", "null"))) {
			System.out.println(b);
		}
		

	}

}
