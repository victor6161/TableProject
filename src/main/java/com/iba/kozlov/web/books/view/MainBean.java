package com.iba.kozlov.web.books.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.bl.service.ReaderService;
import com.iba.kozlov.bl.service.WriterService;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.Mapper;
import com.iba.kozlov.web.books.view.searchBean.BookBean;
import com.iba.kozlov.web.books.view.searchBean.ReaderBean;
import com.iba.kozlov.web.books.view.searchBean.WriterBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBean", eager = true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	private SearchBean searchBean;
	@Setter
	@Getter
	private EditorBean editorBean;

	@Setter
	@Getter
	private TableRowBean selectedBook;

	@Setter
	@Getter
	private List<TableRowBean> tableRowBeanList;
	@Setter
	@Getter
	private AddBean addBean;
	@Setter
	@Getter
	private List<WriterBean>  writerBean;
	@Setter
	@Getter
	private List<ReaderBean>  readerBean;
	@Setter
	@Getter
	private List<BookBean>  bookBean;

	public MainBean() {
		searchBean=new SearchBean();
		addBean = new AddBean();
		editorBean = new EditorBean();

	}
	@PostConstruct
	public void init() {
		List<WriterDto> writerDto= new WriterService().readWriters();
		List<WriterBean> writerBean=new ArrayList<>();
		Mapper mapper=new Mapper();
		for(WriterDto writer:writerDto){
			writerBean.add(mapper.ViewWriterBean(writer));
		}
		setWriterBean(writerBean);
		
		List<ReaderDto> readerDto= new ReaderService().readReaders();
		List<ReaderBean> readerBean=new ArrayList<>();
		
		for(ReaderDto reader:readerDto){
			readerBean.add(mapper.ReaderDtoToBean(reader));
		}
		setReaderBean(readerBean);
		
		List<BookDto> bookDto= new BookServiceImpl().readBooks();
		List<BookBean> bookBean=new ArrayList<>();
		
		for(BookDto book:bookDto){
			bookBean.add(mapper.BookDtoToBean(book));
		}
		setBookBean(bookBean);
	}
	}



