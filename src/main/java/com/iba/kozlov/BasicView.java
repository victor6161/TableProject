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
import com.iba.kozlov.viewDto.ViewTableDto;

@ManagedBean(name = "BasicView")
@SessionScoped
public class BasicView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9060484284854089052L;

	private List<ViewTableDto> books = new ArrayList<>();

	private BookService service = new BookService();

	@PostConstruct
	public void init() {
		books = service.createBooks();
	}

	public List<ViewTableDto> getBooks() {
		return books;
	}

	public void setBooks(List<ViewTableDto> books) {
		this.books = books;
	}

}
