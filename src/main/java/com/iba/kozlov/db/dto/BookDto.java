package com.iba.kozlov.db.dto;

import java.io.Serializable;

public class BookDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5571130680992082254L;

	public BookDto(int id,String bookname, String author, int price, UserDto username) {
		super();
		this.id=id;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.username=username;
	}


	public BookDto() {
		// TODO Auto-generated constructor stub
	}


	private int id;
	private String bookname;
	private String author;
	private int price;
	private int userId;
	private UserDto username; 

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

	public UserDto getUserDto() {
		return username;
	}

	public void setUserDto(UserDto username) {
		this.username = username;
	}
	
	
}
