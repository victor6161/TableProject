package com.iba.kozlov.db.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class WriterDto implements Serializable  {
	@Override
	public String toString() {
		return "WriterDto [name=" + name + ", id=" + id + ", surname=" + surname + ", country=" + country + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public WriterDto(int id) {
		this.id=id;
		
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
	public WriterDto(int id, String writerName, String writerSurname, String country) {
		this.id=id;
		this.surname=writerSurname;
		this.name=writerName;
		this.country=country;
	}
}
