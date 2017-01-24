/**
 * 
 */
package com.iba.kozlov.web.books;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.iba.kozlov.bl.service.BookService;
import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.web.books.view.ManageBean;
import com.iba.kozlov.web.books.view.TableRowBean;

/**
 * @author KazlouV
 *
 */
@ManagedBean(name = "bookController")
@SessionScoped
public class BookController implements Serializable {
	private ManageBean manageBean=new ManageBean();
    BookService bookService=new BookServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -4973724563495030465L;

	public void onSearch() {
		
	}

	public void add() {
		bookService.addBooks(manageBean.getAddBean());
	}
	
	public void onRemove(){
		
	}
}
