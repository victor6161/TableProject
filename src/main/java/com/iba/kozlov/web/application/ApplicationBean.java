package com.iba.kozlov.web.application;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.iba.kozlov.db.dao.BookDao;
import com.iba.kozlov.db.dao.BookSearchCriteria;
import com.iba.kozlov.db.dao.ReaderDao;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.Mapper;

import lombok.Getter;
import lombok.Setter;
@ManagedBean(name="applicationBean",eager=true)
@SessionScoped
public class ApplicationBean {


	public ApplicationBean(){
		
	}


	
	@Setter
	@Getter
	private List<WriterBean> writerBeans;
	@Setter
	@Getter
	private List<ReaderBean> readerBeans;
	@Setter
	@Getter
	private List<BookBean> bookBeans;
	
	public List<WriterBean> byAuthor(String autoCompleteText) {
		List<WriterBean> results = new ArrayList<>();
		for (WriterBean writer : writerBeans) {
			if (writer == null)
				continue;
			if (writer.getSurname().contains(autoCompleteText)) {
				results.add(writer);
			}
		}
		return results;		
	}
	public List<BookBean> byBookname(String autoCompleteText) {
		
		List<BookBean> results = new ArrayList<>();


		for (BookBean book : bookBeans) {

			if (book == null)
				continue;
			if (book.getBookname().contains(autoCompleteText)) {
				results.add(book);
			}
		}
		return results;
	}

	public List<ReaderBean> byReader(String autoCompleteText) {
		
		List<ReaderBean> results = new ArrayList<>();

	
		for (ReaderBean reader : readerBeans) {

			if (reader.getSurname() == null)
				continue;
			if (reader.getSurname().contains(autoCompleteText)) {
				results.add(reader);
			}
		}
		return results;
	}
	
	
	public void addToListWriters(){
		
	}
}
