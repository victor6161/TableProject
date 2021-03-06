package com.iba.kozlov.web.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


import com.iba.kozlov.web.application.ApplicationBean;
import com.iba.kozlov.web.application.ReaderBean;


@FacesConverter("com.iba.kozlov.ReaderConverter")
public class ReaderConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {

		ApplicationBean autoCompleteValueBean = null;

		autoCompleteValueBean = (ApplicationBean) fc.getApplication().evaluateExpressionGet(fc, "#{applicationBean}", ApplicationBean.class);

		List<ReaderBean> readerBean = autoCompleteValueBean.getReaderBeans();
		if (value != null && value.trim().length() > 0) {
			try {
				for (ReaderBean reader : readerBean) {
					if (value.equals(String.valueOf(reader.getId()))) {
						return reader;
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
		 
		// ������ ������� value ��� getAsObject
		if (value instanceof ReaderBean)
			return String.valueOf((((ReaderBean) value).getId()));

		return null;

	}

}
