
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
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.web.books.view.EditorBean;
import com.iba.kozlov.web.books.view.MainBean;
import com.iba.kozlov.web.books.view.TableRowBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "bookController", eager = true)
@SessionScoped
public class BookController implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(BookController.class);
	private static final long serialVersionUID = -4973724563495030465L;

	@ManagedProperty(value = "#{mainBean}")
	private MainBean mainBean;

	BookDataFacade facade = new BookDataFacade(this);
	BookService bookService = new BookServiceImpl();

	
	private boolean isEmptyAutoComplete = true;
	List<TableRowBean> bookAll = new ArrayList<>();;

	public List<TableRowBean> complete(String autoCompleteText) {
		LOGGER.info("complete method");
		List<TableRowBean> results = new ArrayList<>();

		if (isEmptyAutoComplete) {
			bookAll = new ArrayList<>();
			bookAll = bookService.readBooks();
			isEmptyAutoComplete = false;
		}
		for (TableRowBean book : bookAll) {

			if (book.getAuthor() == null)
				continue;
			if (book.getAuthor().contains(autoCompleteText)) {
				results.add(book);
			}
		}
		return results;
	}

	@Setter
	@Getter
	private String rowsPerPage = "10";

	public void onPaginate() {
		LOGGER.info("select row " + rowsPerPage);
	}

	public MainBean getMainBean() {
		return mainBean;
	}

	@PostConstruct
	public void init() {
		mainBean.setTableRowBeanList(bookService.readBooks());
		mainBean.setEditorBean(new EditorBean());
	}

	public void setMainBean(MainBean mainBean) {
		this.mainBean = mainBean;
	}

	public void edit() {
		LOGGER.info("edit!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + mainBean.getEditorBean().toString());
		bookService.editBooks(mainBean.getEditorBean());
		mainBean.setTableRowBeanList(bookService.readBooks());
	}
	/*
	public void onSearch() {
		LOGGER.info("onSearch"+mainBean.getSearchBean().getAuthor()+mainBean.getSearchBean().getBookname()+mainBean.getSearchBean().getUsername());
		mainBean.setTableRowBeanList(bookService.findBooks(mainBean.getSearchBean()));
	}
	 */
	
	public void onEditOpen() {
		BookDto bookDto = new Mapper().ViewTableDtoToBookDto(mainBean.getSelectedBook());
		LOGGER.info("onEditOpen" + bookDto.toString());
		mainBean.setEditorBean(new Mapper().BookDtoToEditorBean(bookDto));
	}

	public void add() {
		LOGGER.info("add");
		bookService.addBooks(mainBean.getAddBean());
		mainBean.setTableRowBeanList(bookService.readBooks());
		mainBean.getAddBean().setAuthor(null);
		mainBean.getAddBean().setBookname(null);
		mainBean.getAddBean().setPrice(0);
	}

	public void onRemove() {

	}
}
