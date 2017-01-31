package com.iba.kozlov.web.books;

import java.io.Serializable;


public class BookDataFacade implements Serializable {


	private static final long serialVersionUID = -5823792094177216548L;
	
	private BookController controller; 
	
	public BookDataFacade(BookController pController) {
		controller = pController;
	}

}
