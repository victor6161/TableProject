/**
 * 
 */
package com.iba.kozlov.web.books;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.iba.kozlov.bl.service.BookService;
import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.web.books.view.AddBean;
import com.iba.kozlov.web.books.view.MainBean;


/**
 * @author KazlouV
 *
 */
@ManagedBean(name = "bookController",eager=true)
@SessionScoped
public class BookController implements Serializable {
	
	@ManagedProperty(value="#{mainBean}")
	private MainBean mainBean;
    public MainBean getMainBean() {
		return mainBean;
	}
    
    @PostConstruct
	public void init() {
		
		mainBean.setTableRowBeanList(bookService.readBooks());
	}

	public void setMainBean(MainBean mainBean) {
		this.mainBean = mainBean;
	}

	BookService bookService=new BookServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -4973724563495030465L;

	public void onSearch() {
		
	}

	public void add() {
		bookService.addBooks(mainBean.getAddBean());
		mainBean.setTableRowBeanList(bookService.readBooks());
	}
	
	public void onRemove(){
		
	}
}
