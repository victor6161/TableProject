package com.iba.kozlov.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;

import com.iba.kozlov.web.books.Mapper;
import com.iba.kozlov.web.books.view.MainBean;
import com.iba.kozlov.web.books.view.searchBean.ReaderBean;
import com.iba.kozlov.web.books.view.searchBean.WriterBean;

@FacesConverter("com.iba.kozlov.ReaderConverter")
public class ReaderConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {

		MainBean mainBean = null;

		mainBean = (MainBean) fc.getApplication().evaluateExpressionGet(fc, "#{mainBean}", MainBean.class);

		List<ReaderBean> readerBean = mainBean.getReaderBean();
		if (value != null && value.trim().length() > 0) {
			try {
				for (ReaderBean reader : readerBean) {
					if (value.equals(String.valueOf(reader.getId()))) {
						return new Mapper().ReaderBeanToDto(reader);
					}
				}
				return null;
			} catch (NumberFormatException e) {
				throw new ConverterException();
			}
		} else {
			return null;
		}
		// получить список
		// найти по id - value
	
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		 
		// отсюда берется value для getAsObject
		if (value instanceof ReaderDto)
			return String.valueOf((((ReaderDto) value).getId()));

		return null;

	}

}
