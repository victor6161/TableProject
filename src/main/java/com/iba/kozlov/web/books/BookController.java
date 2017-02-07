
package com.iba.kozlov.web.books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.BookService;
import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.bl.service.WriterService;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.view.EditorBean;
import com.iba.kozlov.web.books.view.MainBean;
import com.iba.kozlov.web.books.view.TableRowBean;
import com.iba.kozlov.web.books.view.WriterBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "bookController", eager = true)
@SessionScoped
public class BookController implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(BookController.class);
	private static final long serialVersionUID = -4973724563495030465L;
	@Setter
	@Getter
	@ManagedProperty(value = "#{mainBean}")
	private MainBean mainBean;

	BookDataFacade facade = new BookDataFacade(this);
	BookService bookService = new BookServiceImpl();

	@Setter
	@Getter
	private String rowsPerPage = "10";

	public void onPaginate() {
		LOGGER.info("select row " + rowsPerPage);
	}

	@PostConstruct
	public void init() {

		List<BookDto> bookDto = bookService.readBooks();

		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : bookDto) {
			viewTableDto.add(new Mapper().BookDtoToViewTableDto(bookDtoItem));
		}
		mainBean.setTableRowBeanList(viewTableDto);
		mainBean.setEditorBean(new EditorBean());
		// List<WriterDto> writerDto= new WriterService().readWriters();
		// List<WriterBean> writerBean=new ArrayList<>();
		// Mapper mapper=new Mapper();
		// for(WriterDto writer:writerDto){
		// writerBean.add(mapper.ViewWriterBean(writer));
		// }
		//
		// mainBean.setWriterBean(writerBean);
		// for(WriterBean writerBean2: mainBean.getWriterBean()){
		// LOGGER.info(writerBean2.toString());
		// }

	}

	public void edit() {
		LOGGER.info("edit" + mainBean.getEditorBean().toString());
		AutoComplete.isEmptyAutoCompleteAuthor = true;
		AutoComplete.isEmptyAutoCompleteBook = true;
		AutoComplete.isEmptyAutoCompleteReader = true;

		bookService.editBooks(new Mapper().EditorBeanToBookDto(mainBean.getEditorBean()));
		List<BookDto> bookDto = bookService.readBooks();
		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : bookDto) {
			viewTableDto.add(new Mapper().BookDtoToViewTableDto(bookDtoItem));
		}
		mainBean.setTableRowBeanList(viewTableDto);
	}

	public void onSearch() {
		LOGGER.info("Search*********************");
		/*
		 * LOGGER.info("onSearch!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +
		 * mainBean.getSearchBean().toString());
		 * mainBean.setTableRowBeanList(bookService.findBooks(mainBean.
		 * getSearchBean()));
		 */
	}

	public void onEditOpen() {
		BookDto bookDto = new Mapper().ViewTableDtoToBookDto(mainBean.getSelectedBook());
		LOGGER.info("onEditOpen" + bookDto.toString());
		mainBean.setEditorBean(new Mapper().BookDtoToEditorBean(bookDto));
	}

	public void add() {
		LOGGER.info("add");

		Mapper mapper = new Mapper();
		BookDto book = mapper.AddBeanToBookDto(mainBean.getAddBean());
		LOGGER.info("book" + book.toString());
		bookService.addBooks(book);

		List<BookDto> bookDto = bookService.readBooks();
		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : bookDto) {
			viewTableDto.add(new Mapper().BookDtoToViewTableDto(bookDtoItem));
		}
		AutoComplete.isEmptyAutoCompleteAuthor = true;
		AutoComplete.isEmptyAutoCompleteBook = true;
		AutoComplete.isEmptyAutoCompleteReader = true;
		mainBean.setTableRowBeanList(viewTableDto);
		mainBean.getAddBean().setAuthor(null);
		mainBean.getAddBean().setBookname(null);
		mainBean.getAddBean().setPrice(0);
	}

	public void onRemove() {

	}
}
