package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.iba.kozlov.AuthorConverter")
public class AuthorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		return "asd";
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		return null;
	}
	
}
