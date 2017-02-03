package com.iba.kozlov.db.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class BookDto implements Serializable {

	private static final long serialVersionUID = 5571130680992082254L;

	public BookDto(int id, String bookname, int price, ReaderDto reader, WriterDto writer) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.price = price;
		this.reader = reader;
		this.writer = writer;
	}

	public BookDto() {

	}

	@Setter
	@Getter
	private int id;
	@Setter
	@Getter
	private String bookname;
	@Setter
	@Getter
	private int price;
	@Setter
	@Getter
	private ReaderDto reader;
	@Setter
	@Getter
	private WriterDto writer;
	@Setter
	@Getter
	private int writer_id;
	@Setter
	@Getter
	private int reader_id;

}
