package com.iba.kozlov.web.books.view;

import com.iba.kozlov.db.dto.WriterDto;

import lombok.Getter;
import lombok.Setter;

public class SearchBean {
	

	@Override
	public String toString() {
		return "SearchBean [bookname=" + bookname + ", author=" + author + ", username=" + username + ", authorSearch="
				+ authorSearch + "]";
	}
	@Setter
	@Getter
	private String bookname;
	@Setter
	@Getter
	private String author;
	@Setter
	@Getter
	private String username;
	@Setter
	@Getter
	private WriterDto authorSearch;
}
