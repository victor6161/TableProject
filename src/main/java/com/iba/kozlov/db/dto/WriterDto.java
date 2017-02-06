package com.iba.kozlov.db.dto;

import lombok.Getter;
import lombok.Setter;

public class WriterDto {
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private int id;
	@Setter
	@Getter
	private String surname;
	@Setter
	@Getter
	private String country;
	
	public WriterDto(String writerSurname) {
		this.surname=writerSurname;
	}
	public WriterDto() {
		
	}
	public WriterDto(int id, String writerSurname) {
		this.id=id;
		this.surname=writerSurname;
	}
	public WriterDto(int id, String writerName, String writerSurname) {
		this.id=id;
		this.surname=writerSurname;
		this.name=writerName;
	}
}
