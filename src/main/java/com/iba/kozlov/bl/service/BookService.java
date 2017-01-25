/**
 * 
 */
package com.iba.kozlov.bl.service;

import java.util.List;


import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.TableRowBean;

/**
 * @author KazlouV
 *
 */
public interface BookService {

	void addBooks(AddBean addBean);
	List<TableRowBean> readBooks();
}
