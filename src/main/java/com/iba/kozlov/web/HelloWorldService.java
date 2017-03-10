package com.iba.kozlov.web;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.iba.kozlov.bl.service.BookService;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.WriterDto;

@Path("demo")
public class HelloWorldService {
	@EJB
	BookService bookService;
	Mapper mapper = new Mapper();

	@GET
	@Path("all_books")
	@Produces(MediaType.APPLICATION_JSON)
	public BooksData getBooks() {
		List<BookDto> bookDtoDb = bookService.readBooks();
		BooksData booksData = getBook(bookDtoDb);
		return booksData;
	}

	@GET
	@Path("all_books_by_author")
	@Produces(MediaType.APPLICATION_JSON)
	public BooksData getBooksByAuthor(@QueryParam("id") Integer id) {
		BookDto bookDto = new BookDto();
		WriterDto writerDto = new WriterDto();

		writerDto.setId(id);
		List<WriterDto> writersDto = new ArrayList<WriterDto>();
		writersDto.add(writerDto);
		bookDto.setWriters(writersDto);

		List<BookDto> bookDtoDb = bookService.searchBooks(bookDto);
		BooksData booksData = getBook(bookDtoDb);
		return booksData;

	}
	public BooksData getBook(List<BookDto> bookDtoDb){
		List<BookDtoJson> bookDtoJson = new ArrayList<BookDtoJson>();
		for (BookDto bookDtoItem : bookDtoDb) {
			bookDtoJson.add(mapper.bookDtoToDtoJson(bookDtoItem));
		}
		
		BooksData booksData = new BooksData();
		booksData.setBooks(bookDtoJson);
		return booksData;
	}

}
