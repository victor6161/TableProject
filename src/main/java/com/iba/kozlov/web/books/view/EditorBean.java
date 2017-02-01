package com.iba.kozlov.web.books.view;



import lombok.Getter;
import lombok.Setter;

public class EditorBean {
	
	
	
	@Override
	public String toString() {
		return "EditorBean [id=" + id + ", price=" + price + ", bookname=" + bookname + ", author=" + author + "]";
	}
	@Setter
	@Getter
	private int id;
	@Setter
	@Getter
	private int price;
	
	@Setter
	@Getter
	private String bookname;
	@Setter
	@Getter
	private String author;
	
	

}
