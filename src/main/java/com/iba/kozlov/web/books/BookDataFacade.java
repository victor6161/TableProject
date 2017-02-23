package com.iba.kozlov.web.books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dto.BookDto;

import com.iba.kozlov.db.dto.WriterDto;

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
		controller.mainBean.setTableRowBeanList(getTable());
		
		
		
		controller.mainBean.getEditorBean().setWriters(controller.applicationBean.getWriters());
		controller.mainBean.getAddBean().setWriters(controller.applicationBean.getWriters());
	}



	public List<TableRowBean> getTable() {
		List<BookDto> bookDto = controller.bookService.readBooks();

		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : bookDto) {
			viewTableDto.add(controller.mapper.bookDtoToViewTableDto(bookDtoItem));
		}
		return viewTableDto;
	}

	public void editBook() {
		controller.bookService.editBooks(controller.mapper.editorBeanToBookDto(controller.mainBean.getEditorBean()));
		controller.mainBean.setTableRowBeanList(getTable());
	}

	public void onSearch() {
		LOGGER.info("onSearch");
		BookDto bookDto = new BookDto();

		if (controller.mainBean.getSearchBean().getAuthorSearch() != null) {
			LOGGER.info("1");
			List<WriterBean> writersSearch = controller.mainBean.getSearchBean().getAuthorSearch();
			List<WriterDto> result = new ArrayList<>();
			for (WriterBean writer : writersSearch) {
				LOGGER.info("2 "+writer.toString());
				result.add(controller.mapper.writerBeanToDto(writer));
			}
			bookDto.setWriters(result);

		}
		if (controller.mainBean.getSearchBean().getReaderSearch() != null) {
			bookDto.setReader(controller.mapper.readerBeanToDto(controller.mainBean.getSearchBean().getReaderSearch()));
		}
		if (controller.mainBean.getSearchBean().getBookSearch() != null) {

			bookDto.setId(controller.mainBean.getSearchBean().getBookSearch().getId());
		}

		List<BookDto> resultSearch = controller.bookService.searchBooks(bookDto);

		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : resultSearch) {
			viewTableDto.add(controller.mapper.bookDtoToViewTableDto(bookDtoItem));
		}
		controller.mainBean.setTableRowBeanList(viewTableDto);

	}

	public void onEditOpen() {
		Mapper mapper = new Mapper();
		BookDto bookDto = mapper.viewTableDtoToBookDto(controller.mainBean.getSelectedBook());
		LOGGER.info("onEditOpen" + bookDto.toString());

		List<WriterBean> writerBean = new ArrayList<WriterBean>();// не смог в
																	// маппер
																	// получить
																	// mainBean
																	// , так
																	// сохраняется
																	// , список
																	// писателей
		writerBean = controller.mainBean.getEditorBean().getWriters();

		controller.mainBean.setEditorBean(mapper.bookDtoToEditorBean(bookDto));

		controller.mainBean.getEditorBean().setWriters(writerBean);
		LOGGER.info("onEditOpen"
				+ controller.mainBean.getSelectedBook().getWriterBean().toString());

		controller.mainBean.getEditorBean().setWriter(controller.mainBean.getSelectedBook().getWriterBean());

	}

	public void add() {

		BookDto book = controller.mapper.addBeanToBookDto(controller.mainBean.getAddBean());
		LOGGER.info("book" + book.toString());
		controller.bookService.addBooks(book);

		controller.mainBean.setTableRowBeanList(getTable());

		
	}
	public void onAddOpen() {
		LOGGER.info("onAddOpen");
		
		/*addBean.setAuthor("");*/
		/*addBean.setBookname("");
		addBean.setPrice(0);
		addBean.setWriters(controller.applicationBean.getWriters());*/
		/*controller.mainBean.setAddBean(addBean);*/
		controller.mainBean.getAddBean().setBookname("");
		controller.mainBean.getAddBean().setPrice(0);
		controller.mainBean.getAddBean().setWriter(new WriterBean());

		
	
	}

}
