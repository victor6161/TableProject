package com.iba.kozlov.web.writers.view;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class EditorBean implements Serializable {
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
