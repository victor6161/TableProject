package com.iba.kozlov.viewDto;



public class ViewTableDto {
	private int id;
	private String bookname;
	private String author;
	private int price;
	private String username; 
	
	public ViewTableDto(String bookname, String author, int price, String username) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.username = username;
	}

	public ViewTableDto() {
		// TODO Auto-generated constructor stub
	}

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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
}
