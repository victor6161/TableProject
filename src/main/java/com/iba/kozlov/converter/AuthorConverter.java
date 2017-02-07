package com.iba.kozlov.converter;

import java.util.List;

import javax.faces.bean.ManagedProperty;
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
import com.iba.kozlov.web.books.view.MainBean;
import com.iba.kozlov.web.books.view.WriterBean;

import lombok.Getter;
import lombok.Setter;

@FacesConverter("com.iba.kozlov.AuthorConverter")
public class AuthorConverter implements Converter {
	private static final Logger LOGGER = Logger.getLogger(AuthorConverter.class);
	@Setter
	@Getter
	@ManagedProperty(value = "#{mainBean}")
	private MainBean mainBean;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {
		List<WriterBean> writerBean = mainBean.getWriterBean();
		if (value != null && value.trim().length() > 0) {
			try {
				for (WriterBean writer : writerBean) {
					if (writer.getSurname().equals(value)) {
						return writer;
					}
				}

				// получить список
				// найти по id - value
				// AutoComplete autoComplete = (AutoComplete)
				// fc.getExternalContext().getApplicationMap();
				// return autoComplete.byAuthor(value);
				return null;
			} catch (NumberFormatException e) {
				throw new ConverterException();
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {

		if (value instanceof WriterDto)
			return ((WriterDto) value).getSurname();

		return null;

	}

}
