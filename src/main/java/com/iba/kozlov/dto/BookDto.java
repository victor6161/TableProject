package com.iba.kozlov.dto;

import java.io.Serializable;

public class BookDto implements Serializable {

	public BookDto(String bookname, String author, int price, String username) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.username=username;
	}


	private int id;
	private String bookname;
	private String author;
	private int price;
	private int userId;
	private String username; 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUsernameId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
