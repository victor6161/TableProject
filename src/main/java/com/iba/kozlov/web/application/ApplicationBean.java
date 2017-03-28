package com.iba.kozlov.web.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.iba.kozlov.bl.service.BookService;

import com.iba.kozlov.bl.service.ReaderService;
import com.iba.kozlov.bl.service.WriterService;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.Mapper;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "applicationBean", eager = true)
@SessionScoped
public class ApplicationBean implements Serializable {

	private static final long serialVersionUID = 5550768740315016091L;

	Mapper mapper = new Mapper();

	@EJB
	WriterService writerService;
	@EJB
	BookService bookService;
	@EJB
	ReaderService readerService;

	public ApplicationBean() {
		loginBean = new LoginBean();
		registrationBean = new RegistrationBean();
	}

	@Setter
	@Getter
	private LoginBean loginBean;
	@Setter
	@Getter
	private RegistrationBean registrationBean;

	public void init() {
		setWriterBeans(getWriters());
		setReaderBeans(getReaders());
		setBookBeans(getBookBean());
	}

	public List<BookBean> getBookBean() {
		List<BookDto> bookDto = bookService.readBooks();
		List<BookBean> bookBean = new ArrayList<>();
		for (BookDto book : bookDto) {
			bookBean.add(mapper.bookDtoToBean(book));
		}
		return bookBean;
	}

	public List<ReaderBean> getReaders() {
		List<ReaderDto> readerDto = readerService.readReaders();
		List<ReaderBean> readerBean = new ArrayList<>();

		for (ReaderDto reader : readerDto) {
			readerBean.add(mapper.readerDtoToBean(reader));
		}
		return readerBean;
	}

	public List<WriterBean> getWriters() {
		List<WriterDto> writerDto = writerService.readWriters();
		List<WriterBean> writerBean = new ArrayList<>();

		for (WriterDto writer : writerDto) {
			writerBean.add(mapper.viewWriterBean(writer));
		}
		return writerBean;
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

	public void addToListWriters() {

	}
}
