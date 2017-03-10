package com.iba.kozlov.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement
public class BooksData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5724747741916955987L;
	@Setter
	@Getter
	private List<BookDtoJson> books = new ArrayList<BookDtoJson>();
}
