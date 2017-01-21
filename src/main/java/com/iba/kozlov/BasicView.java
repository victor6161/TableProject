package com.iba.kozlov;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.iba.kozlov.dto.BookDto;
import com.iba.kozlov.service.BookService;

@ManagedBean(name = "BasicView")
@SessionScoped
public class BasicView implements Serializable {
	private List<BookDto> books = new ArrayList<>();

	private BookService service = new BookService();

	@PostConstruct
	public void init() {
		books = service.createBooks();
	}

	public List<BookDto> getBooks() {
		return books;
	}

	public void setBooks(List<BookDto> books) {
		this.books = books;
	}

}
