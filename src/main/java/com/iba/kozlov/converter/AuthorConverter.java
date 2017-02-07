package com.iba.kozlov.converter;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.AutoComplete;
import com.iba.kozlov.web.books.BookController;
import com.iba.kozlov.web.books.Mapper;
import com.iba.kozlov.web.books.view.MainBean;
import com.iba.kozlov.web.books.view.WriterBean;



@FacesConverter("com.iba.kozlov.AuthorConverter")
//@RequestScoped
public class AuthorConverter implements Converter {
	private static final Logger LOGGER = Logger.getLogger(AuthorConverter.class);

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {

		MainBean mainBean = null;

		mainBean = (MainBean) fc.getApplication().evaluateExpressionGet(fc, "#{mainBean}", MainBean.class);


		List<WriterBean> writerBean = mainBean.getWriterBean();
		if (value != null && value.trim().length() > 0) {
			try {
				for (WriterBean writer : writerBean) {
					if (value.equals(String.valueOf(writer.getId()))) {
						return new Mapper().WriterBeanToDto(writer);
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
	/*	 AutoComplete autoComplete = (AutoComplete)
		 fc.getExternalContext().getApplicationMap();
		 return autoComplete.byAuthor(value);*/
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		//получается что отсюда берется value для getAsObject
		if (value instanceof WriterDto)
			return String.valueOf((((WriterDto) value).getId()));
		
		return null;

	}

}
