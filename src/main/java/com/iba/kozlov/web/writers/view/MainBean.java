package com.iba.kozlov.web.writers.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "writerMainBean", eager = true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	private List<TableRowBean> tableRowBeanList;
	@Setter
	@Getter
	private TableRowBean addBean;
	@Setter
	@Getter
	private TableRowBean selectedWriter;
	@Setter
	@Getter
	private TableRowBean editorBean;
	@Setter
	@Getter
	private TableRowBean authorSearch;

	public MainBean() {
		addBean = new TableRowBean();
	}
}
