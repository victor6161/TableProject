package com.iba.kozlov.web.security;


import java.util.Base64;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dto.ReaderDto;

public class SecurityDataFacade {
	private SecurityController sController;

	public SecurityDataFacade(SecurityController pController) {
		this.sController = pController;
	}
	private static final Logger LOGGER = Logger.getLogger(SecurityDataFacade.class);
	public String validateUsernamePassword() {
		LOGGER.info("validateUsernamePassword");
		if (checkPassword()) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username",sController.getApplicationBean().getLoginBean().getLogin());
			return "book";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Not Successful", "Not Successful"));
			return "login";
		}
	}
	public String logout() {
		LOGGER.info("logout");
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
	
	private boolean checkPassword() {
		List<ReaderDto> readers = sController.getReaderService().readReaders();
		
		for (ReaderDto reader : readers) {
			
			byte [] barr = Base64.getDecoder().decode(reader.getPassword());
			String passDB = new String(barr);
			if (sController.getApplicationBean().getLoginBean().getLogin().equals(reader.getLogin())
					&& sController.getApplicationBean().getLoginBean().getPassword().equals(passDB)) {
				sController.getApplicationBean().getLoginBean().setRole(reader.getRole());
				return true;	
			}
		}
		return false;
	}
	public String registration() {
		LOGGER.info("registration");
		ReaderDto readerDto = sController.getMapper().registrationBeanToReaderDto(sController.getApplicationBean().getRegistrationBean());
		sController.getReaderService().createReader(readerDto);
		return "login";
	}
	
}
