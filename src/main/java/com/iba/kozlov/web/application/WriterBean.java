package com.iba.kozlov.web.application;

import lombok.Getter;
import lombok.Setter;

public class WriterBean {
	@Override
	public String toString() {
		return "WriterBean [id=" + id + ", name=" + name + ", surname=" + surname + "]";
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
	@Setter
	@Getter
	private String country;
	
	public WriterBean(){
	
	}
	public WriterBean(String writerSurname) {
		this.surname=writerSurname;
	}
}
