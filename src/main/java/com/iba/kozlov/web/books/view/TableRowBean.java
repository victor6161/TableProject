package com.iba.kozlov.web.books.view;

import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.web.application.WriterBean;

import lombok.Getter;
import lombok.Setter;

public class TableRowBean {
	
	@Override
	public String toString() {
		return "TableRowBean [bookDto=" + bookDto + ", id=" + id + ", bookname=" + bookname + ", "
				+ ", price=" + price + ", username=" + username + "]";
	}
	@Setter
	@Getter
	private BookDto bookDto;
	@Setter
	@Getter
	private int id;
	@Setter
	@Getter
	private WriterBean writerBean;
	@Setter
	@Getter
	private String bookname;
	
	@Setter
	@Getter
	private int price;
	@Setter
	@Getter
	private String username; 
	
	public TableRowBean(String bookname, String author, int price, String username) {
		super();
		this.bookname = bookname;
	
		this.price = price;
		this.username = username;
	}

	public TableRowBean() {
		this.bookname="ad";
	
		this.price=100;
	}



	
}
