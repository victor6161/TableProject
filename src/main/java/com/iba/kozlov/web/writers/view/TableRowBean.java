package com.iba.kozlov.web.writers.view;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class TableRowBean implements Serializable {
	@Override
	public String toString() {
		return "TableRowBean [id=" + id + ", name=" + name + ", surname=" + surname + ", country=" + country + "]";
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
