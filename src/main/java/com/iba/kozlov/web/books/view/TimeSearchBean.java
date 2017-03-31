package com.iba.kozlov.web.books.view;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class TimeSearchBean {
	@Setter
	@Getter
	private Date from;
	@Setter
	@Getter
	private Date to;
	@Setter
	@Getter
	private boolean show = false;

}
