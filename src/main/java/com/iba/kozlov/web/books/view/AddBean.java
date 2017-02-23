package com.iba.kozlov.web.books.view;

import java.util.List;

import com.iba.kozlov.web.application.WriterBean;

import lombok.Getter;
import lombok.Setter;

public class AddBean {
	@Override
	public String toString() {
		return "AddBean [bookname=" + bookname + ", username=" + username + ", price=" + price + ", writer=" + writer
				+ "]";
	}
	@Setter
	@Getter
	private String bookname;


	@Setter
	@Getter
	private String username;
	@Setter
	@Getter
	private int price;
	@Setter
	@Getter
	private WriterBean writer;
	@Setter
	@Getter
	private List<WriterBean> writers;


}
