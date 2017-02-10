package com.iba.kozlov.web.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


import com.iba.kozlov.web.application.AutoCompleteValueBean;
import com.iba.kozlov.web.application.BookBean;


@FacesConverter("com.iba.kozlov.BookConverter")
public class BookConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {
		AutoCompleteValueBean autoCompleteValueBean = null;

		autoCompleteValueBean = (AutoCompleteValueBean) fc.getApplication().evaluateExpressionGet(fc, "#{autoCompleteValueBean}", AutoCompleteValueBean.class);
		


		List<BookBean> bookBean = autoCompleteValueBean.getBookBean();
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
		// �������� ������
		// ����� �� id - value
	
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		//���������� ��� ������ ������� value ��� getAsObject
		if (value instanceof BookBean)
			return String.valueOf((((BookBean) value).getId()));
		
		return null;

	}

}