package com.es.eoi.myBooks.entities;

import java.util.Date;

public class Book {

	private String title;

	private Date publishDate;

	private String author;

	private int numPages;

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
		
		this.publishDate = new Date();
		this.author = author;
		this.numPages = 0;
	
	}

	public Book(String title, Date publishDate, String author, int numPages) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.numPages = numPages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

	
	
}
