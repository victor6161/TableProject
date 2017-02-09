package com.iba.kozlov.web.books.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.iba.kozlov.bl.service.WriterService;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.books.Mapper;
import com.iba.kozlov.web.books.view.searchBean.WriterBean;

import lombok.Getter;
import lombok.Setter;

public class EditorBean {


	@Override
	public String toString() {
		return "EditorBean [id=" + id + ", price=" + price + ", bookname=" + bookname + ", author=" + author
				+ ", writer=" + writer + ", writers=" + writers + "]";
	}
	@Setter
	@Getter
	private int id;
	@Setter
	@Getter
	private int price;

	@Setter
	@Getter
	private String bookname;
	@Setter
	@Getter
	private String author;

	@Setter
	@Getter
	private WriterBean writer;
	@Setter
	@Getter
	private List<WriterBean> writers;

	

}
