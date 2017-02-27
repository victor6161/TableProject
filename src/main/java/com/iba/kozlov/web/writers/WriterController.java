package com.iba.kozlov.web.writers;

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

import com.iba.kozlov.web.writers.view.MainBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "writerController", eager = true)
@SessionScoped
public class WriterController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9100700357291394307L;
	private static final Logger LOGGER = Logger.getLogger(WriterController.class);
	@Setter
	@Getter
	private String rowsPerPage = "10";

	public void onPaginate() {
		LOGGER.info("select row " + rowsPerPage);
	}
	
	@Setter
	@Getter
	@ManagedProperty(value = "#{writerMainBean}")
	MainBean writerMainBean;
	
	@Setter
	@Getter
	@ManagedProperty(value = "#{applicationBean}")
	ApplicationBean applicationBean;
	
	WriterDataFacade facade = new WriterDataFacade(this);

	BookService bookService = new BookServiceImpl();
	ReaderService readerService=new ReaderService();
	WriterService writerService=new WriterService();

	Mapper mapper = new Mapper();
	@PostConstruct
	public void init() {
		
		facade.initData();

	}
	public void add() {
		LOGGER.info("add!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");	
		facade.add();
	}
	public void edit() {
		LOGGER.info("edit");

		facade.edit();
	}
	public void onEditOpen() {
		LOGGER.info("onEditOpen");

		facade.onEditOpen();
	}
	public void onAddOpen() {
		LOGGER.info("onAddOpen");

		facade.onAddOpen();
	}
	
	public void onSearch(){
		LOGGER.info("onSearch");
		facade.onSearch();
	}
}
