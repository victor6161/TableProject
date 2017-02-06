/**
 * 
 */
package com.iba.kozlov.bl.service;

import java.util.List;


import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.EditorBean;
import com.iba.kozlov.web.books.view.SearchBean;
import com.iba.kozlov.web.books.view.TableRowBean;


public interface BookService {

	void addBooks(AddBean addBean);
	List<TableRowBean> readBooks();
	void editBooks(EditorBean editorBean);

	/*
	int findPriceById(int editId);

	List<TableRowBean> findBooks(SearchBean search);*/
	

	
}
