package com.iba.kozlov.web.application;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;
@ManagedBean(name="autoCompleteValueBean",eager=true)
@SessionScoped
public class AutoCompleteValueBean {

	@Override
	public String toString() {
		return "SearchBean [authorSearch=" + authorSearch + ", readerSearch=" + readerSearch + ", bookSearch="
				+ bookSearch + "]";
	}
	public AutoCompleteValueBean(){
		authorSearch=new WriterBean();
	}

	@Setter
	@Getter
	private WriterBean authorSearch;

	@Setter
	@Getter
	private ReaderBean readerSearch;

	@Setter
	@Getter
	private BookBean bookSearch;
	
	@Setter
	@Getter
	private List<WriterBean> writerBean;
	@Setter
	@Getter
	private List<ReaderBean> readerBean;
	@Setter
	@Getter
	private List<BookBean> bookBean;
}
