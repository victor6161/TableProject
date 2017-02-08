package com.iba.kozlov.db.dto;

import lombok.Getter;
import lombok.Setter;

public class ReaderDto {
	@Override
	public String toString() {
		return "ReaderDto [id=" + id + ", name=" + name + ", surname=" + surname + "]";
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
	
	public ReaderDto(String username) {
		super();
		this.surname = username;
	}

	public ReaderDto() {
		
	}

	public ReaderDto(int id, String readerName, String readerSurname) {
		this.id=id;
		this.name=readerName;
		this.surname=readerSurname;
	}

}
