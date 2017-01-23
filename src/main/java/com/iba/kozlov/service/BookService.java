package com.iba.kozlov.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.iba.kozlov.converter.Mapper;
import com.iba.kozlov.dao.BookDao;
import com.iba.kozlov.dto.BookDto;
import com.iba.kozlov.search.BookSearchCriteria;
import com.iba.kozlov.viewDto.ViewTableDto;

/*@ManagedBean(name = "bookService")
@ApplicationScoped*/
public class BookService {

	public List<ViewTableDto> createBooks() {
		BookSearchCriteria bookSearchCriteria =  new BookSearchCriteria();
		/*bookSearchCriteria.setAuthor("turgenev");*/
		bookSearchCriteria.setPrice(11);
		bookSearchCriteria.setName("mumu");
		List<BookDto> bookDto= new BookDao().read(bookSearchCriteria);
		List<ViewTableDto> viewTableDto = new ArrayList<>();
		for(BookDto bookDtoItem :bookDto){
			viewTableDto.add(new Mapper().BookDtoToViewTableDto(bookDtoItem));
		}
		return viewTableDto;
	}
}
