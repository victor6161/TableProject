package com.iba.kozlov.web.writer;

import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.application.WriterBean;
import com.iba.kozlov.web.writers.view.TableRowBean;

public class Mapper {

	public TableRowBean WriterDtoToTableRowBean(WriterDto writer) {
		TableRowBean tableRowBean=new TableRowBean();
		tableRowBean.setId(writer.getId());
		tableRowBean.setName(writer.getName());
		tableRowBean.setSurname(writer.getSurname());
		tableRowBean.setCountry(writer.getCountry());
		return tableRowBean;
	}

	public WriterDto TableRowBeanToWriterDto(TableRowBean addBean) {
		WriterDto writerDto=new WriterDto();
		writerDto.setId(addBean.getId());
		writerDto.setName(addBean.getName());
		writerDto.setSurname(addBean.getSurname());
		writerDto.setCountry(addBean.getCountry());
		return writerDto;
	}

	public TableRowBean WriterBeanToTableRowBean(WriterBean writer) {
		TableRowBean tableRowBean=new TableRowBean();
		tableRowBean.setId(writer.getId());
		tableRowBean.setName(writer.getName());
		tableRowBean.setSurname(writer.getSurname());
		tableRowBean.setCountry(writer.getCountry());
		return tableRowBean;
	}

}
