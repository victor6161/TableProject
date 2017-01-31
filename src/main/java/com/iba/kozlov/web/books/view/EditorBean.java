package com.iba.kozlov.web.books.view;

import javax.annotation.PostConstruct;

public class EditorBean {
	
	
	
	@Override
	public String toString() {
		return "EditorBean [id=" + id + ", price=" + price + ", bookname=" + bookname + ", author=" + author + "]";
	}
	private int id;
	private int price;
	private String bookname;
	private String author;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
