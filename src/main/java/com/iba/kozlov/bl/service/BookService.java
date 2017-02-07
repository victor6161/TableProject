/**
 * 
 */
package com.iba.kozlov.bl.service;

import java.util.List;

import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.EditorBean;
import com.iba.kozlov.web.books.view.SearchBean;



public interface BookService {

	void addBooks(BookDto bookDto);
	List<BookDto> readBooks();
	void editBooks(BookDto BookDto);
	List<BookDto> searchBooks(BookDto bookDto);
	



	

	
}
