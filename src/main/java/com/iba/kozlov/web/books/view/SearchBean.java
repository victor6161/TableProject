/**
 * 
 */
package com.iba.kozlov.web.books.view;

import java.io.Serializable;
import java.util.List;

import com.iba.kozlov.web.application.BookBean;
import com.iba.kozlov.web.application.ReaderBean;
import com.iba.kozlov.web.application.WriterBean;

import lombok.Getter;
import lombok.Setter;


public class SearchBean implements Serializable {


	public SearchBean() {
		timeSearchBean = new TimeSearchBean();
	}
	private static final long serialVersionUID = -3320379691024559538L;
	
	@Setter
	@Getter
	private List<WriterBean> authorSearch;

	@Setter
	@Getter
	private ReaderBean readerSearch;

	@Setter
	@Getter
	private BookBean bookSearch;
	@Setter
	@Getter
	private TimeSearchBean timeSearchBean;

}
