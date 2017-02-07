package com.iba.kozlov.web.books;



import java.io.Writer;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.bl.service.WriterService;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.EditorBean;
import com.iba.kozlov.web.books.view.TableRowBean;
import com.iba.kozlov.web.books.view.WriterBean;

public class Mapper {
	WriterService writerService=new WriterService();

	public TableRowBean BookDtoToViewTableDto(BookDto bookDto) {
		TableRowBean viewDto = new TableRowBean();
		viewDto.setId(bookDto.getId());
		viewDto.setAuthor(bookDto.getWriter().getSurname());
		viewDto.setBookname(bookDto.getBookname());
		viewDto.setPrice(bookDto.getPrice());
		viewDto.setUsername(bookDto.getReader().getSurname());
		return viewDto;
	}

	public BookDto ViewTableDtoToBookDto(TableRowBean viewDto) {
		BookDto boookDto = new BookDto();
		// boookDto.setBookDto(bookDto);
		boookDto.setId(viewDto.getId());
		boookDto.setWriter(new WriterDto(viewDto.getAuthor()));
		boookDto.setBookname(viewDto.getBookname());
		boookDto.setPrice(viewDto.getPrice());
		boookDto.setReader(new ReaderDto(viewDto.getUsername()));
		return boookDto;
	}

	public BookDto AddBeanToBookDto(AddBean addBean) {
		BookDto bookDto = new BookDto();
		bookDto.setBookname(addBean.getBookname());
		bookDto.setPrice(addBean.getPrice());
		bookDto.setWriter(new WriterDto(addBean.getAuthor()));
		return bookDto;
	}
	private static final Logger LOGGER = Logger.getLogger(BookController.class);
	public BookDto EditorBeanToBookDto(EditorBean editorBean) {
		BookDto bookDto = new BookDto();
		bookDto.setPrice(editorBean.getPrice());
		bookDto.setId(editorBean.getId());
	 	int writerId= new BookServiceImpl().findWriterIdInBook(editorBean.getId());
	 	 LOGGER.info("writerId*************************** "+ writerId);
		WriterDto writerDto=new WriterDto(writerId,editorBean.getAuthor());
		bookDto.setWriter(writerDto);
		bookDto.setBookname(editorBean.getBookname());
		return bookDto;
	}
	
	public EditorBean BookDtoToEditorBean(BookDto bookDto) {
		EditorBean editorBean = new EditorBean();
		editorBean.setId(bookDto.getId());
		editorBean.setAuthor(bookDto.getWriter().getSurname());
		editorBean.setBookname(bookDto.getBookname());
		editorBean.setPrice(bookDto.getPrice());
		return editorBean;
	}
	public WriterBean ViewWriterBean(WriterDto writerDto){
		WriterBean writerBean=new WriterBean();
		writerBean.setId(writerDto.getId());
		writerBean.setName(writerDto.getName());
		writerBean.setSurname(writerDto.getSurname());
		
		return writerBean;
	}
}
