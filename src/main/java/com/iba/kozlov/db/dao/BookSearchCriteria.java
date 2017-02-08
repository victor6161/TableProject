package com.iba.kozlov.db.dao;

import lombok.Getter;
import lombok.Setter;

public class BookSearchCriteria {
	public BookSearchCriteria(){
		this.author="";
		this.name="";
		this.price=0;
		this.writerId=0;
		this.readerId=0;
	}
	@Setter
	@Getter
	private Integer bookId;
	@Setter
	@Getter
	private Integer writerId;
	@Setter
	@Getter
	private String author;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private Integer price;
	@Setter
	@Getter
	private Integer readerId;

	
	public boolean isEmpty(){
		System.out.println("pCriteria");
		System.out.println(this.getAuthor().isEmpty() && this.getName().isEmpty() && this.getPrice().equals(0) && this.getWriterId().equals(0) );	
		return this.getAuthor().isEmpty() && this.getName().isEmpty() && this.getPrice().equals(0) && this.getWriterId().equals(0) && this.getReaderId().equals(0) && this.getBookId()==null;
	}
}
