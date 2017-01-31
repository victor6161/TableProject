/**
 * 
 */
package com.iba.kozlov.web.books;

import java.io.Serializable;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.BookService;
import com.iba.kozlov.bl.service.BookServiceImpl;

import com.iba.kozlov.web.books.view.EditorBean;
import com.iba.kozlov.web.books.view.MainBean;

/**
 * @author KazlouV
 *
 */
@ManagedBean(name = "bookController", eager = true)
@SessionScoped
public class BookController implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(BookController.class);
	private static final long serialVersionUID = -4973724563495030465L;

	@ManagedProperty(value = "#{mainBean}")
	private MainBean mainBean;

	BookDataFacade facade = new BookDataFacade(this);
	BookService bookService = new BookServiceImpl();

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

	public void initEdit() {
		LOGGER.info("initEdit");
		Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		int editId = Integer.valueOf(param.get("editId"));
		EditorBean editBean = new EditorBean();
		editBean.setId(editId);
		LOGGER.info("id=" + editId);
		editBean.setPrice(bookService.findPriceById(editId));
		LOGGER.info("price=" + bookService.findPriceById(editId));
		mainBean.setEditorBean(editBean);
		

	}

	public void edit() {
		LOGGER.info("edit"+mainBean.getEditorBean().getId());
		bookService.editBooks(mainBean.getEditorBean());
		mainBean.setTableRowBeanList(bookService.readBooks());
	}

	public void onSearch() {

	}

	public void add() {
		LOGGER.info("add");
		bookService.addBooks(mainBean.getAddBean());
		mainBean.setTableRowBeanList(bookService.readBooks());
		mainBean.getAddBean().destructor();

	}

	public void onRemove() {

	}
}
