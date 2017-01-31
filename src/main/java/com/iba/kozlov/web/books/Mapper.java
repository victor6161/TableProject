package com.iba.kozlov.web.books;

import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.UserDto;
import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.EditorBean;
import com.iba.kozlov.web.books.view.TableRowBean;

public class Mapper {

	public TableRowBean BookDtoToViewTableDto(BookDto bookDto) {
		TableRowBean viewDto = new TableRowBean();
		viewDto.setBookDto(bookDto);
		viewDto.setId(bookDto.getId());
		viewDto.setAuthor(bookDto.getAuthor());
		viewDto.setBookname(bookDto.getBookname());
		viewDto.setPrice(bookDto.getPrice());
		viewDto.setUsername(bookDto.getUserDto().getUsername());
		return viewDto;
	}

	public BookDto ViewTableDtoToBookDto(TableRowBean viewDto) {
		BookDto boookDto = new BookDto();
		// boookDto.setBookDto(bookDto);
		boookDto.setId(viewDto.getId());
		boookDto.setAuthor(viewDto.getAuthor());
		boookDto.setBookname(viewDto.getBookname());
		boookDto.setPrice(viewDto.getPrice());
		boookDto.setUserDto(new UserDto(viewDto.getUsername()));
		return boookDto;
	}

	public BookDto AddBeanToBookDto(AddBean addBean) {
		BookDto bookDto = new BookDto();
		bookDto.setAuthor(addBean.getAuthor());
		bookDto.setBookname(addBean.getBookname());
		bookDto.setPrice(addBean.getPrice());
		bookDto.setUserDto(new UserDto(addBean.getUsername()));
		return bookDto;
	}

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
	}
}
