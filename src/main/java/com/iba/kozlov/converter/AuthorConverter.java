package com.iba.kozlov.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.web.books.BookController;

@FacesConverter("com.iba.kozlov.AuthorConverter")
public class AuthorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {
		
	    if(value != null && value.trim().length() > 0) {
            try {
                BookController controller = (BookController) fc.getExternalContext().getApplicationMap();
                return  controller.complete(value);
            } catch(NumberFormatException e) {
                throw new ConverterException();
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		return null;
	}
	
}