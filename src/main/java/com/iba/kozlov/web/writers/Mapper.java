package com.iba.kozlov.web.writer;

import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.application.WriterBean;
import com.iba.kozlov.web.writers.view.AddBean;
import com.iba.kozlov.web.writers.view.EditorBean;
import com.iba.kozlov.web.writers.view.SearchBean;
import com.iba.kozlov.web.writers.view.TableRowBean;

public class Mapper {

	public TableRowBean writerDtoToTableRowBean(WriterDto writer) {
		TableRowBean tableRowBean = new TableRowBean();
		tableRowBean.setId(writer.getId());
		tableRowBean.setName(writer.getName());
		tableRowBean.setSurname(writer.getSurname());
		tableRowBean.setCountry(writer.getCountry());
		return tableRowBean;
	}

	public WriterDto tableRowBeanToWriterDto(TableRowBean addBean) {
		WriterDto writerDto = new WriterDto();
		writerDto.setId(addBean.getId());
		writerDto.setName(addBean.getName());
		writerDto.setSurname(addBean.getSurname());
		writerDto.setCountry(addBean.getCountry());
		return writerDto;
	}



	public WriterDto addBeanToWriterDto(AddBean addBean) {
		WriterDto writerDto = new WriterDto();
		writerDto.setId(addBean.getId());
		writerDto.setName(addBean.getName());
		writerDto.setSurname(addBean.getSurname());
		writerDto.setCountry(addBean.getCountry());
		return writerDto;
	}

	public WriterDto editBeanToWriterDto(EditorBean editorBean) {
		WriterDto writerDto = new WriterDto();
		writerDto.setId(editorBean.getId());
		writerDto.setName(editorBean.getName());
		writerDto.setSurname(editorBean.getSurname());
		writerDto.setCountry(editorBean.getCountry());
		return writerDto;
	}

	public EditorBean writerDtoToEditBean(WriterDto writerDto) {
		EditorBean editorBean = new EditorBean();
		editorBean.setId(writerDto.getId());
		editorBean.setName(writerDto.getName());
		editorBean.setSurname(writerDto.getSurname());
		editorBean.setCountry(writerDto.getCountry());
		return editorBean;
	}
	public WriterDto writerBeanToDto(WriterBean writerBean){
		WriterDto writerDto=new WriterDto();
		writerDto.setId(writerBean.getId());
		writerDto.setName(writerBean.getName());
		writerDto.setSurname(writerBean.getSurname());
		
		return writerDto;
	}

	public SearchBean writerDtoToSearchBean(WriterDto writerDto) {
		SearchBean searchBean=new SearchBean();
		searchBean.setId(writerDto.getId());
		searchBean.setName(writerDto.getName());
		searchBean.setSurname(writerDto.getSurname());
		return searchBean;
	}

	public WriterDto searchBeanToWriterDto(SearchBean writerSearch) {
		WriterDto writerDto=new WriterDto();
		writerDto.setId(writerSearch.getId());
		writerDto.setName(writerSearch.getName());
		writerDto.setSurname(writerSearch.getSurname());
		
		return writerDto;
	}

}
