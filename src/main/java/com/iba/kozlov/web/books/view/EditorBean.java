package com.iba.kozlov.web.books.view;


import java.util.List;

import com.iba.kozlov.web.application.WriterBean;


import lombok.Getter;
import lombok.Setter;

public class EditorBean {


	@Override
	public String toString() {
		return "EditorBean [id=" + id + ", price=" + price + ", bookname=" + bookname + ", author=" + author
				+ ", writer=" + writer + ", writers=" + writers + "]";
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

	@Setter
	@Getter
	private WriterBean writer;
	@Setter
	@Getter
	private List<WriterBean> writers;

	

}
