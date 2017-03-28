package com.iba.kozlov.web.application;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class RegistrationBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private String surname;
	@Setter
	@Getter
	private String login;
	@Setter
	@Getter
	private String password;
	@Setter
	@Getter
	private String email;

}
