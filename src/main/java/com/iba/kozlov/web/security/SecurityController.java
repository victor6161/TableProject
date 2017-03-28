package com.iba.kozlov.web.security;



import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.ReaderService;

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

	@Setter
	@Getter
	@EJB
	private ReaderService readerService;
	@Setter
	@Getter
	private Mapper mapper = new Mapper();

	SecurityDataFacade dataFacade = new SecurityDataFacade(this);

	private static final Logger LOGGER = Logger.getLogger(SecurityController.class);

	public String validateUsernamePassword() {
		LOGGER.info("validateUsernamePassword");
		return dataFacade.validateUsernamePassword();
	}

	public String logout() {
		LOGGER.info("logout");
		return dataFacade.logout();
	}
	public String registration() {
		LOGGER.info("registration");
		return dataFacade.registration();
	}

}
