package com.iba.kozlov.web.books.view;



import java.util.List;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBean", eager = true)
@SessionScoped
public class MainBean {

	@Setter
	@Getter
	private EditorBean editorBean;

	@Setter
	@Getter
	private TableRowBean selectedBook;

	@Setter
	@Getter
	private List<TableRowBean> tableRowBeanList;
	@Setter
	@Getter
	private AddBean addBean;
	
	@Setter
	@Getter
	private SearchBean searchBean;
	
	@Setter
	@Getter
	private Integer totalPrice;
	
	@Setter
	@Getter
	private Integer amount;



	public MainBean() {
		searchBean=new SearchBean();
		addBean = new AddBean();
		editorBean = new EditorBean();
		
	}

}
