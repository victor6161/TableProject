package com.iba.kozlov.web.writers.view;

import lombok.Getter;
import lombok.Setter;

public class AddBean {
	public AddBean(){
		this.id=0;
		this.name="";
		this.surname="";
		this.country="";
		
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

}
