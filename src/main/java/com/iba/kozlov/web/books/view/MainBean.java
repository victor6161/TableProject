package com.iba.kozlov.web.books.view;

import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;


@ManagedBean(name = "mainBean",eager=true)
@SessionScoped
public class MainBean {
	private SearchBean searchBean;
	private EditorBean editorBean;
	

	
	private TableRowBean selectedBook;
	public TableRowBean getSelectedBook() {
		return selectedBook;
	}


	public void setSelectedBook(TableRowBean selectedBook) {
		this.selectedBook = selectedBook;
	}


	private List<TableRowBean> tableRowBeanList;
	private AddBean addBean;
	

	
	public MainBean() {
		addBean=new AddBean();

		editorBean=new EditorBean();
		
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
