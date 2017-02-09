package com.iba.kozlov.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.AutoComplete;
import com.iba.kozlov.web.books.Mapper;
import com.iba.kozlov.web.books.view.MainBean;
import com.iba.kozlov.web.books.view.searchBean.BookBean;
import com.iba.kozlov.web.books.view.searchBean.WriterBean;

@FacesConverter("com.iba.kozlov.BookConverter")
public class BookConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {

		MainBean mainBean = null;

		mainBean = (MainBean) fc.getApplication().evaluateExpressionGet(fc, "#{mainBean}", MainBean.class);


		List<BookBean> bookBean = mainBean.getBookBean();
		if (value != null && value.trim().length() > 0) {
			try {
				for (BookBean book : bookBean) {
					if (value.equals(String.valueOf(book.getId()))) {
						return book;
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
		//получается что отсюда берется value для getAsObject
		if (value instanceof BookBean)
			return String.valueOf((((BookBean) value).getId()));
		
		return null;

	}

}
