package com.iba.kozlov.web.books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;



import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.application.BookBean;
import com.iba.kozlov.web.application.ReaderBean;
import com.iba.kozlov.web.application.WriterBean;
import com.iba.kozlov.web.books.view.TableRowBean;


public class BookDataFacade implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(BookDataFacade.class);

	private static final long serialVersionUID = -5823792094177216548L;
	
	private BookController controller; 
	
	public BookDataFacade(BookController pController) {
		controller = pController;
		
	}
	
	public void initData() {
		
		List<BookDto> bookDto = controller.bookService.readBooks();
		
		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : bookDto) {
			viewTableDto.add(controller.mapper.BookDtoToViewTableDto(bookDtoItem));
		}
		controller.mainBean.setTableRowBeanList(viewTableDto);
		
		List<WriterDto> writerDto= controller.writerService.readWriters();
		List<WriterBean> writerBean=new ArrayList<>();
	
		for(WriterDto writer:writerDto){
			writerBean.add(controller.mapper.ViewWriterBean(writer));
		}
		controller.autoCompleteValueBean.setWriterBean(writerBean);
		
		List<ReaderDto> readerDto= controller.readerService.readReaders();
		List<ReaderBean> readerBean=new ArrayList<>();
		
		for(ReaderDto reader:readerDto){
			readerBean.add(controller.mapper.ReaderDtoToBean(reader));
		}
		controller.autoCompleteValueBean.setReaderBean(readerBean);
		
		List<BookBean> bookBean=new ArrayList<>();
		for(BookDto book:bookDto){
			bookBean.add(controller.mapper.BookDtoToBean(book));
		}
		controller.autoCompleteValueBean.setBookBean(bookBean);
		controller.mainBean.getEditorBean().setWriters(writerBean);
		
	}

	public void editBook() {
		AutoComplete.isEmptyAutoCompleteAuthor = true;
		AutoComplete.isEmptyAutoCompleteBook = true;
		AutoComplete.isEmptyAutoCompleteReader = true;

		controller.bookService.editBooks(controller.mapper.EditorBeanToBookDto(controller.mainBean.getEditorBean()));
		
		List<BookDto> bookDto = controller.bookService.readBooks();
		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : bookDto) {
			viewTableDto.add(controller.mapper.BookDtoToViewTableDto(bookDtoItem));
		}
		controller.mainBean.setTableRowBeanList(viewTableDto);
		
	}

	public void onSearch() {
		BookDto bookDto = new BookDto();
		if (controller.autoCompleteValueBean.getAuthorSearch() != null) {
			bookDto.setWriter(controller.mapper.WriterBeanToDto(controller.autoCompleteValueBean.getAuthorSearch()));
		}
		if (controller.autoCompleteValueBean.getReaderSearch() != null) {
			bookDto.setReader(controller.mapper.ReaderBeanToDto(controller.autoCompleteValueBean.getReaderSearch()));
		}
		if (controller.autoCompleteValueBean.getBookSearch() != null) {
			
			bookDto.setId(controller.autoCompleteValueBean.getBookSearch().getId());
		}

		List<BookDto> resultSearch = controller.bookService.searchBooks(bookDto);

		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : resultSearch) {
			viewTableDto.add(controller.mapper.BookDtoToViewTableDto(bookDtoItem));
		}
		controller.mainBean.setTableRowBeanList(viewTableDto);
		
	}

	public void onEditOpen() {
		Mapper mapper= new Mapper();
		BookDto bookDto = mapper.ViewTableDtoToBookDto(controller.mainBean.getSelectedBook());
		LOGGER.info("onEditOpen" + bookDto.toString());
		
		
		List <WriterBean> writerBean=new ArrayList<WriterBean>();// не смог в маппер получить mainBean , так сохраняется ,  список писателей
		writerBean=controller.mainBean.getEditorBean().getWriters();
		
		controller.mainBean.setEditorBean(mapper.BookDtoToEditorBean(bookDto));
		
		controller.mainBean.getEditorBean().setWriters(writerBean);
		LOGGER.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^onEditOpen" + controller.mainBean.getSelectedBook().getWriterBean().toString());
		
		controller.mainBean.getEditorBean().setWriter(controller.mainBean.getSelectedBook().getWriterBean());
		
	}

	public void add() {
		
		BookDto book = controller.mapper.AddBeanToBookDto(controller.mainBean.getAddBean());
		LOGGER.info("book" + book.toString());
		controller.bookService.addBooks(book);

		List<BookDto> bookDto = controller.bookService.readBooks();
		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : bookDto) {
			viewTableDto.add(controller.mapper.BookDtoToViewTableDto(bookDtoItem));
		}
		AutoComplete.isEmptyAutoCompleteAuthor = true;
		AutoComplete.isEmptyAutoCompleteBook = true;
		AutoComplete.isEmptyAutoCompleteReader = true;
		controller.mainBean.setTableRowBeanList(viewTableDto);
		controller.mainBean.getAddBean().setAuthor(null);
		controller.mainBean.getAddBean().setBookname(null);
		controller.mainBean.getAddBean().setPrice(0);
		
	}
	

}
