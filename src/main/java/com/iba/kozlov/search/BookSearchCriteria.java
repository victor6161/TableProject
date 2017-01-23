package com.iba.kozlov.search;

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
	
/*	public isEmpty*/
}
