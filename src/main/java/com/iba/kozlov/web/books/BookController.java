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

import org.apache.log4j.Logger;

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
	
	private static final Logger LOGGER = Logger.getLogger(BookController.class);
	private static final long serialVersionUID = -4973724563495030465L;
	
	@ManagedProperty(value="#{mainBean}")
	private MainBean mainBean;
	
	BookDataFacade facade = new BookDataFacade(this);
	
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
	public void edit(){
		LOGGER.info("edit");
		bookService.editBooks(mainBean.getEditorBean());
		mainBean.setTableRowBeanList(bookService.readBooks());
	}

	public void onSearch() {
		
	}

	public void add() {
		LOGGER.info("add");
		bookService.addBooks(mainBean.getAddBean());
		mainBean.setTableRowBeanList(bookService.readBooks());
		mainBean.getAddBean().setAuthor(null);
		mainBean.getAddBean().setBookname(null);
		mainBean.getAddBean().setPrice(0);
	}
	
	public void onRemove(){
		
	}
}
