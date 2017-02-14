
package com.iba.kozlov.web.books;

import java.io.Serializable;


import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.BookService;
import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.bl.service.ReaderService;
import com.iba.kozlov.bl.service.WriterService;
import com.iba.kozlov.web.application.ApplicationBean;
import com.iba.kozlov.web.books.view.MainBean;


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
	MainBean mainBean;
	

	@Setter
	@Getter
	@ManagedProperty(value = "#{applicationBean}")
	ApplicationBean applicationBean;

	BookDataFacade facade = new BookDataFacade(this);
	
	BookService bookService = new BookServiceImpl();
	ReaderService readerService=new ReaderService();
	WriterService writerService=new WriterService();
	Mapper mapper = new Mapper();

	@Setter
	@Getter
	private String rowsPerPage = "10";

	public void onPaginate() {
		LOGGER.info("select row " + rowsPerPage);
	}

	@PostConstruct
	public void init() {
		
		facade.initData();

	}

	public void edit() {
		LOGGER.info("edit" + mainBean.getEditorBean().toString());
		LOGGER.info("***********************************************writer is "+mainBean.getEditorBean().getWriter());
		facade.editBook();
	}

	public void onSearch() {
		LOGGER.info("Search*");


		facade.onSearch();
	}

	public void onEditOpen() {
		
		facade.onEditOpen();
	}

	public void add() {
		LOGGER.info("add");

		facade.add();
	}

	public void onRemove() {

	}
}
