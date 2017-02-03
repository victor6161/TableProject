package com.iba.kozlov.web.books;



import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.TableRowBean;

public class Mapper {

	public TableRowBean BookDtoToViewTableDto(BookDto bookDto) {
		TableRowBean viewDto = new TableRowBean();
		viewDto.setId(bookDto.getId());
	
		viewDto.setAuthor(bookDto.getWriter().getSurname());
		viewDto.setBookname(bookDto.getBookname());
		viewDto.setPrice(bookDto.getPrice());
	
		viewDto.setUsername(bookDto.getReader().getSurname());
		return viewDto;
	}

	/*public BookDto ViewTableDtoToBookDto(TableRowBean viewDto) {
		BookDto boookDto = new BookDto();
		// boookDto.setBookDto(bookDto);
		boookDto.setId(viewDto.getId());
		boookDto.setAuthor(viewDto.getAuthor());
		boookDto.setBookname(viewDto.getBookname());
		boookDto.setPrice(viewDto.getPrice());
		boookDto.setUserDto(new ReaderDto(viewDto.getUsername()));
		return boookDto;
	}*/

	public BookDto AddBeanToBookDto(AddBean addBean) {
		BookDto bookDto = new BookDto();
	/*	ReaderDto reader=new ReaderDto();
		WriterDto writer=new WriterDto();*/

		bookDto.setBookname(addBean.getBookname());
		bookDto.setPrice(addBean.getPrice());
	
		
		return bookDto;
	}
	/*
	public BookDto EditorBeanToBookDto(EditorBean editorBean) {
		BookDto bookDto = new BookDto();
		bookDto.setPrice(editorBean.getPrice());
		bookDto.setId(editorBean.getId());
		bookDto.setAuthor(editorBean.getAuthor());
		bookDto.setBookname(editorBean.getBookname());
		return bookDto;
	}

	public EditorBean BookDtoToEditorBean(BookDto bookDto) {
		EditorBean editorBean = new EditorBean();
		editorBean.setId(bookDto.getId());
		editorBean.setAuthor(bookDto.getAuthor());
		editorBean.setBookname(bookDto.getBookname());
		editorBean.setPrice(bookDto.getPrice());

		return editorBean;
	}*/
}
