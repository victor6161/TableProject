package com.iba.kozlov.web.application;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class LoginBean implements Serializable {
	public LoginBean() {
		super();
		
	}

	@Setter
	@Getter
	private String role;
	@Setter
	@Getter
	private String password;
	@Setter
	@Getter
	private String message;
	@Setter
	@Getter
	private String login;

	public boolean hasRole(String role) {
		return this.role.equals(role);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginBean other = (LoginBean) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

}
