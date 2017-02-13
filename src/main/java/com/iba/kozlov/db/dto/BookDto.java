package com.iba.kozlov.db.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class BookDto implements Serializable {

	@Override
	public String toString() {
		return "BookDto [id=" + id + ", bookname=" + bookname + ", price=" + price + ", reader=" + reader + ", writer="
				+ writer + ", writer_id=" + writerId + ", reader_id=" + readerId + "]";
	}



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

	

	public BookDto(int id, int writerId) {
		this.id=id;
		this.writerId=writerId;
	}



	


	@Setter
	@Getter
	private Integer id;
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
	private List<WriterDto> writers;
	@Setter
	@Getter
	private int writerId;
	@Setter
	@Getter
	private int readerId;

}
