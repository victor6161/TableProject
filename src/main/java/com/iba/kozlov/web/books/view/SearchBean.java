package com.iba.kozlov.web.books.view;

import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;

import lombok.Getter;
import lombok.Setter;

public class SearchBean {

	@Override
	public String toString() {
		return "SearchBean [authorSearch=" + authorSearch + ", readerSearch=" + readerSearch + ", bookSearch="
				+ bookSearch + "]";
	}

	@Setter
	@Getter
	private WriterDto authorSearch;

	@Setter
	@Getter
	private ReaderDto readerSearch;

	@Setter
	@Getter
	private BookDto bookSearch;
}
