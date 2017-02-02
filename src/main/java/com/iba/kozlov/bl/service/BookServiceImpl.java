package com.iba.kozlov.bl.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dao.BookDao;
import com.iba.kozlov.db.dao.BookSearchCriteria;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.web.books.Mapper;
import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.EditorBean;
import com.iba.kozlov.web.books.view.TableRowBean;

/*@ManagedBean(name = "bookService")
@ApplicationScoped*/
public class BookServiceImpl implements BookService{
	private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);
	
	public List<TableRowBean> readBooks() {
		LOGGER.info("createBooks method");
		BookSearchCriteria bookSearchCriteria =  new BookSearchCriteria();
	/*	bookSearchCriteria.setAuthor("turgenev");
		bookSearchCriteria.setPrice(11);
		bookSearchCriteria.setName("mumu");*/
		List<BookDto> bookDto= new BookDao().read(bookSearchCriteria);
		List<TableRowBean> viewTableDto = new ArrayList<>();
		for(BookDto bookDtoItem :bookDto){
			viewTableDto.add(new Mapper().BookDtoToViewTableDto(bookDtoItem));
		}
		return viewTableDto;
	}
	

	@Override
	public void addBooks(AddBean addBean) {
		LOGGER.info("addBook");
		new BookDao().addBook(new Mapper().AddBeanToBookDto(addBean));

	}
	@Override
	public void editBooks(EditorBean editorBean) {
		LOGGER.info("editBook");
		new BookDao().updateAll(new Mapper().EditorBeanToBookDto(editorBean));
		//new BookDao().updatePrice(new Mapper().EditorBeanToBookDto(editorBean));
	
	}
	@Override
	public int findPriceById(int id) {
		List<BookDto> bookDto= new BookDao().read(new BookSearchCriteria());
		for(BookDto book:bookDto){
			if(new Integer(book.getId()).equals(id)){
				return book.getPrice();
			}
		}
		return 0;
	}
	
	public List<TableRowBean> search(){
		BookSearchCriteria bookSearchCriteria =  new BookSearchCriteria();
		List<BookDto> bookDto= new BookDao().read(bookSearchCriteria);
		
		List<TableRowBean> viewTableDto = new ArrayList<>();
		for(BookDto bookDtoItem :bookDto){
			viewTableDto.add(new Mapper().BookDtoToViewTableDto(bookDtoItem));
		}
		return viewTableDto;	
	}
}
