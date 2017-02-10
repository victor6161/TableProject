package com.iba.kozlov.web.converter;

import java.util.List;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;



import com.iba.kozlov.web.application.AutoCompleteValueBean;
import com.iba.kozlov.web.application.WriterBean;




@FacesConverter("com.iba.kozlov.AuthorConverter")
public class AuthorConverter implements Converter {
	private static final Logger LOGGER = Logger.getLogger(AuthorConverter.class);

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {

		AutoCompleteValueBean autoCompleteValueBean = null;

		autoCompleteValueBean = (AutoCompleteValueBean) fc.getApplication().evaluateExpressionGet(fc, "#{autoCompleteValueBean}", AutoCompleteValueBean.class);


		List<WriterBean> writerBean = autoCompleteValueBean.getWriterBean();
		if (value != null && value.trim().length() > 0) {
			try {
				for (WriterBean writer : writerBean) {
					if (value.equals(String.valueOf(writer.getId()))) {
						LOGGER.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!converter"+writer.toString());
						return writer;
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
		if (value instanceof WriterBean)
			return String.valueOf((((WriterBean) value).getId()));
		
		return null;

	}

}
