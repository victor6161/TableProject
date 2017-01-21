package com.iba.kozlov.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.iba.kozlov.dao.BookDao;
import com.iba.kozlov.dto.BookDto;

/*@ManagedBean(name = "bookService")
@ApplicationScoped*/
public class BookService {

	public List<BookDto> createBooks() {
	/*		List<BookDto> list=new ArrayList<>();
		list.add(new BookDto("war and peace","tolsti",1));
		list.add(new BookDto("war war ","chechov",1));
		list.add(new BookDto("war, war and only war","turgenev",1));
		return list;*/
		
		return new BookDao().read();
	}
}
