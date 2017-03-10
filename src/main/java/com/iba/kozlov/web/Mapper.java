package com.iba.kozlov.web;

import com.iba.kozlov.db.dto.BookDto;

public class Mapper {

	public BookDtoJson bookDtoToDtoJson(BookDto bookDtoItem) {
		BookDtoJson bookDtoJson = new BookDtoJson();
		bookDtoJson.setId(bookDtoItem.getId());
		bookDtoJson.setBookname(bookDtoItem.getBookname());
		bookDtoJson.setPrice(bookDtoItem.getPrice());
		bookDtoJson.setWriter(bookDtoItem.getWriter().getSurname());
		return bookDtoJson;
	}

}
