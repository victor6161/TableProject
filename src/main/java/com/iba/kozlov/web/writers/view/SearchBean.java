package com.iba.kozlov.web.writers.view;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class SearchBean implements Serializable {
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
