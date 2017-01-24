package com.iba.kozlov.db.dao;

public class BookSearchCriteria {
	public BookSearchCriteria(){
		this.author="";
		this.name="";
		this.price=0;
	}
	private String author;
	private String name;
	private Integer price;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public boolean isEmpty(){
		System.out.println("pCriteria");
		System.out.println(this.getAuthor().isEmpty() && this.getName().isEmpty() && this.getPrice().equals(0));	
		return this.getAuthor().isEmpty() && this.getName().isEmpty() && this.getPrice().equals(0);
	}
/*	public isEmpty*/
}
