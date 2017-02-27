package com.iba.kozlov.web.writers.converter;

import java.util.List;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.application.ApplicationBean;
import com.iba.kozlov.web.application.WriterBean;
import com.iba.kozlov.web.writers.Mapper;
import com.iba.kozlov.web.writers.view.SearchBean;




@FacesConverter("com.iba.kozlov.web.writer.AuthorConverter")
public class AuthorConverter implements Converter {
	private static final Logger LOGGER = Logger.getLogger(AuthorConverter.class);
	Mapper mapper=new Mapper();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {

		ApplicationBean autoCompleteValueBean = null;

		autoCompleteValueBean = (ApplicationBean) fc.getApplication().evaluateExpressionGet(fc, "#{applicationBean}", ApplicationBean.class);


		List<WriterBean> writerBean = autoCompleteValueBean.getWriterBeans();
		if (value != null && value.trim().length() > 0) {
			try {
				for (WriterBean writer : writerBean) {
					if (value.equals(String.valueOf(writer.getId()))) {
						LOGGER.info("converter"+writer.toString());
						WriterDto writerDto= mapper.writerBeanToDto(writer);
						SearchBean searchBean=mapper.writerDtoToSearchBean(writerDto);
						return  searchBean;
					}
				}
				return null;
			} catch (NumberFormatException e) {
				throw new ConverterException();
			}
		} else {
			return null;
		}
		// �������� ������
		// ����� �� id - value
	
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		//���������� ��� ������ ������� value ��� getAsObject
		if (value instanceof WriterBean)
			return String.valueOf((((WriterBean) value).getId()));
		
		return null;

	}

}
