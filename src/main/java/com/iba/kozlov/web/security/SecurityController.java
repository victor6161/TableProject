package com.iba.kozlov.web.security;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.ReaderService;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.web.application.ApplicationBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "securityController", eager = true)
@SessionScoped
public class SecurityController {
	@Setter
	@Getter
	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;

	@EJB
	private ReaderService readerService;

	private static final Logger LOGGER = Logger.getLogger(SecurityController.class);

	public String validateUsernamePassword() {
		LOGGER.info("validateUsernamePassword");
		if (checkPassword()) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", applicationBean.getLoginBean().getLogin());
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
		List<ReaderDto> readers = readerService.readReaders();
		for (ReaderDto reader : readers) {
			if (applicationBean.getLoginBean().getLogin().equals(reader.getLogin())
					&& applicationBean.getLoginBean().getPassword().equals(reader.getPassword())) {
				applicationBean.getLoginBean().setRole(reader.getRole());
				return true;	
			}
		}
		return false;
	}
}
