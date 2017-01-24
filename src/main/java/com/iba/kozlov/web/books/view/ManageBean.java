package com.iba.kozlov.web.books.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.iba.kozlov.bl.service.BookServiceImpl;

@ManagedBean(name = "manageBean")
@SessionScoped
public class ManageBean {
	private SearchBean searchBean;
	private EditorBean editorBean;
	
	private List<TableRowBean> tableRowBeanList;
	private AddBean addBean;
	
	private BookServiceImpl service = new BookServiceImpl();

	@PostConstruct
	public void init() {
		setTableRowBeanList(service.createBooks());
	}

	
	public SearchBean getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(SearchBean searchBean) {
		this.searchBean = searchBean;
	}


	public EditorBean getEditorBean() {
		return editorBean;
	}

	public void setEditorBean(EditorBean editorBean) {
		this.editorBean = editorBean;
	}




	public List<TableRowBean> getTableRowBeanList() {
		return tableRowBeanList;
	}


	public void setTableRowBeanList(List<TableRowBean> tableRowBeanList) {
		this.tableRowBeanList = tableRowBeanList;
	}


	public AddBean getAddBean() {
		return addBean;
	}


	public void setAddBean(AddBean addBean) {
		this.addBean = addBean;
	}
	
}
