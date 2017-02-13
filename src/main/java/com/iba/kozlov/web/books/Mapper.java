package com.iba.kozlov.web.books;





import com.iba.kozlov.bl.service.WriterService;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.application.BookBean;
import com.iba.kozlov.web.application.ReaderBean;
import com.iba.kozlov.web.application.WriterBean;
import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.EditorBean;

import com.iba.kozlov.web.books.view.TableRowBean;



public class Mapper {
	WriterService writerService=new WriterService();


	public TableRowBean bookDtoToViewTableDto(BookDto bookDto) {
		TableRowBean viewDto = new TableRowBean();
		viewDto.setId(bookDto.getId());
		viewDto.setWriterBean(viewWriterBean(bookDto.getWriter()));
		viewDto.setBookname(bookDto.getBookname());
		viewDto.setPrice(bookDto.getPrice());
		viewDto.setUsername(bookDto.getReader().getSurname());
		return viewDto;
	}

	public BookDto viewTableDtoToBookDto(TableRowBean viewDto) {
		BookDto boookDto = new BookDto();
		// boookDto.setBookDto(bookDto);
		boookDto.setId(viewDto.getId());
		boookDto.setWriter(new WriterDto(viewDto.getWriterBean().getSurname()));
		boookDto.setBookname(viewDto.getBookname());
		boookDto.setPrice(viewDto.getPrice());
		boookDto.setReader(new ReaderDto(viewDto.getUsername()));
		return boookDto;
	}

	public BookDto addBeanToBookDto(AddBean addBean) {
		BookDto bookDto = new BookDto();
		bookDto.setBookname(addBean.getBookname());
		bookDto.setPrice(addBean.getPrice());
		bookDto.setWriter(new WriterDto(addBean.getAuthor()));
		return bookDto;
	}
	
	public BookDto editorBeanToBookDto(EditorBean editorBean) {
		BookDto bookDto = new BookDto();
		bookDto.setPrice(editorBean.getPrice());
		bookDto.setId(editorBean.getId());
		bookDto.setWriter(writerBeanToDto(editorBean.getWriter()));
		bookDto.setBookname(editorBean.getBookname());
		return bookDto;
	}
	
	public EditorBean bookDtoToEditorBean(BookDto bookDto) {
		EditorBean editorBean = new EditorBean();
	/*	=mainBean.getEditorBean();*/
		editorBean.setId(bookDto.getId());
		/*editorBean.setAuthor(bookDto.getWriter().getSurname());*/
		editorBean.setBookname(bookDto.getBookname());
		editorBean.setPrice(bookDto.getPrice());
		return editorBean;
	}
	public WriterBean viewWriterBean(WriterDto writerDto){
		WriterBean writerBean=new WriterBean();
		writerBean.setId(writerDto.getId());
		writerBean.setName(writerDto.getName());
		writerBean.setSurname(writerDto.getSurname());
		writerBean.setCountry(writerDto.getCountry());
		
		return writerBean;
	}
	public WriterDto writerBeanToDto(WriterBean writerBean){
		WriterDto writerDto=new WriterDto();
		writerDto.setId(writerBean.getId());
		writerDto.setName(writerBean.getName());
		writerDto.setSurname(writerBean.getSurname());
		
		return writerDto;
	}
	
	public ReaderBean readerDtoToBean(ReaderDto readerDto){
		ReaderBean readerBean=new ReaderBean();
		readerBean.setId(readerDto.getId());
		readerBean.setName(readerDto.getName());
		readerBean.setSurname(readerDto.getSurname());
		return readerBean;
		
	}

	public ReaderDto readerBeanToDto(ReaderBean reader) {
		ReaderDto readerDto=new ReaderDto();
		readerDto.setId(reader.getId());
		readerDto.setName(reader.getName());
		readerDto.setSurname(reader.getSurname());
		return readerDto;
	}
	public BookDto bookBeanToDto(BookBean bookBean) {
		BookDto bookDto=new BookDto();
		bookDto.setId(bookBean.getId());
		bookDto.setBookname(bookBean.getBookname());
		return bookDto;
	}
	public BookBean bookDtoToBean(BookDto bookDto) {
		BookBean bookBean=new BookBean();
		bookBean.setId(bookDto.getId());
		bookBean.setBookname(bookDto.getBookname());
		bookBean.setPrice(bookDto.getPrice());
		return bookBean;
	}
}
