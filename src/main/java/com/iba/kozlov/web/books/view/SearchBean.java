package com.iba.kozlov.web.books.view;

import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.view.searchBean.BookBean;
import com.iba.kozlov.web.books.view.searchBean.ReaderBean;
import com.iba.kozlov.web.books.view.searchBean.WriterBean;

import lombok.Getter;
import lombok.Setter;

public class SearchBean {

	@Override
	public String toString() {
		return "SearchBean [authorSearch=" + authorSearch + ", readerSearch=" + readerSearch + ", bookSearch="
				+ bookSearch + "]";
	}
	SearchBean(){
		authorSearch=new WriterBean();
	}

	@Setter
	@Getter
	private WriterBean authorSearch;

	@Setter
	@Getter
	private ReaderBean readerSearch;

	@Setter
	@Getter
	private BookBean bookSearch;
}
