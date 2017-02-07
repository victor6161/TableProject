package com.iba.kozlov.web.books;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.BookService;
import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.db.dao.BookDao;
import com.iba.kozlov.db.dao.BookSearchCriteria;
import com.iba.kozlov.db.dao.ReaderDao;
import com.iba.kozlov.db.dao.WriterDao;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.view.TableRowBean;

@ManagedBean(name = "autoComplete", eager = true)
@SessionScoped
public class AutoComplete {
	private static final Logger LOGGER = Logger.getLogger(BookController.class);
	 static boolean isEmptyAutoCompleteAuthor = true;
	 static boolean isEmptyAutoCompleteBook = true;
	 static boolean isEmptyAutoCompleteReader = true;
	List<WriterDto> writerDto = new ArrayList<>();
	List<ReaderDto> readerDto = new ArrayList<>();
	List<BookDto> bookDto = new ArrayList<>();
	BookService bookService = new BookServiceImpl();

	public List<WriterDto> byAuthor(String autoCompleteText) {
		LOGGER.info("complete method by author");
		List<WriterDto> results = new ArrayList<>();

		if (isEmptyAutoCompleteAuthor) {
			writerDto = new ArrayList<>();
			writerDto = new WriterDao().read(new BookSearchCriteria());
			isEmptyAutoCompleteAuthor = false;
		}
		for (WriterDto writer : writerDto) {

			if (writer == null)
				continue;
			if (writer.getSurname().contains(autoCompleteText)) {
				results.add(writer);
			}
		}
		return results;
	}

	public List<BookDto> byBookname(String autoCompleteText) {
		LOGGER.info("complete method by bookname");
		List<BookDto> results = new ArrayList<>();

		if (isEmptyAutoCompleteBook) {
			bookDto = new ArrayList<>();
			bookDto = new BookDao().read(new BookSearchCriteria());
			isEmptyAutoCompleteBook = false;
		}
		for (BookDto book : bookDto) {

			if (book == null)
				continue;
			if (book.getBookname().contains(autoCompleteText)) {
				results.add(book);
			}
		}
		return results;
	}

	public List<ReaderDto> byReader(String autoCompleteText) {
		LOGGER.info("complete method by reader");
		List<ReaderDto> results = new ArrayList<>();

		if (isEmptyAutoCompleteReader) {
			readerDto = new ArrayList<>();
			readerDto = new ReaderDao().read(new BookSearchCriteria());
			isEmptyAutoCompleteReader = false;
		}
		for (ReaderDto reader : readerDto) {

			if (reader == null || reader.getSurname() == null)
				continue;
			if (reader.getSurname().contains(autoCompleteText)) {
				results.add(reader);
			}
		}
		return results;
	}
}
