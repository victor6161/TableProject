package com.iba.kozlov.web.application;

import lombok.Getter;
import lombok.Setter;

public class ReaderBean {

	@Override
	public String toString() {
		return "ReaderBean [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	@Setter
	@Getter
	private int id;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private String surname;
	

}
