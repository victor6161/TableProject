package com.iba.kozlov.bl.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dao.BookDao;
import com.iba.kozlov.db.dao.BookSearchCriteria;
import com.iba.kozlov.db.dao.WriterDao;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.web.books.Mapper;
import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.EditorBean;
import com.iba.kozlov.web.books.view.TableRowBean;

public class BookServiceImpl implements BookService {
	private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);

	public List<TableRowBean> readBooks() {
		LOGGER.info("createBooks method");
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria();
		List<BookDto> bookDto = new BookDao().read(bookSearchCriteria);
		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : bookDto) {
			viewTableDto.add(new Mapper().BookDtoToViewTableDto(bookDtoItem));
		}
		return viewTableDto;
	}
	/*
	 * @Override public List<TableRowBean> findBooks(SearchBean search) {
	 * LOGGER.info("createBooks method"); BookSearchCriteria bookSearchCriteria
	 * = new BookSearchCriteria();
	 * bookSearchCriteria.setAuthor(search.getAuthor());
	 * bookSearchCriteria.setName(search.getBookname()); List<BookDto> bookDto=
	 * new BookDao().read(bookSearchCriteria); List<TableRowBean> viewTableDto =
	 * new ArrayList<>(); for(BookDto bookDtoItem :bookDto){
	 * viewTableDto.add(new Mapper().BookDtoToViewTableDto(bookDtoItem)); }
	 * return viewTableDto; }
	 */

	@Override
	public void addBooks(AddBean addBean) {
		LOGGER.info("addBook");
		Mapper mapper = new Mapper();
		addBean.getAuthor();
		LOGGER.info("author" + addBean.getAuthor());
		int writer_id = new WriterService().findIdBySurname(addBean.getAuthor());
		BookDto bookDto = mapper.AddBeanToBookDto(addBean);
		bookDto.setWriterId(writer_id);
		new BookDao().addBook(bookDto);
	}

	@Override
	public void editBooks(EditorBean editorBean) {
		LOGGER.info("editBook" + editorBean.toString());
		new BookDao().updateAll(new Mapper().EditorBeanToBookDto(editorBean));// ???
																				// транзакция
		new WriterDao().update(new Mapper().EditorBeanToBookDto(editorBean));

	}

	public int findWriterIdInBook(int bookId) {
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria();
		List<BookDto> bookDto = new BookDao().readId(bookSearchCriteria);

		for (BookDto bookDtoItem : bookDto) {
			if (new Integer(bookDtoItem.getId()).equals(bookId)) {
				return bookDtoItem.getWriterId();
			}
		}
		return 0;
	}
	/*
	 * @Override public int findPriceById(int id) { List<BookDto> bookDto= new
	 * BookDao().read(new BookSearchCriteria()); for(BookDto book:bookDto){
	 * if(new Integer(book.getId()).equals(id)){ return book.getPrice(); } }
	 * return 0; }
	 */

}
