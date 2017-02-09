package com.iba.kozlov.web.books.view.searchBean;

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
	public WriterBean(){
		this.id=0;
		this.name="";
		this.surname="";
	}
	public WriterBean(String writerSurname) {
		this.surname=writerSurname;
	}
}
