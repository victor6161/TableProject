package com.iba.kozlov.web.component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "dataModel", eager = true)
@SessionScoped
public class DataModel {
	@Setter
	@Getter
	private List<ChartBean> chartValue;
	@PostConstruct
	public void init(){
		chartValue=new ArrayList<>();
		chartValue.add(new ChartBean("rrr",12));
		chartValue.add(new ChartBean("eee",17));
		chartValue.add(new ChartBean("qwert",-23));
	}

}
