package com.iba.kozlov.web.component;


import java.util.List;




import lombok.Getter;
import lombok.Setter;


public class DataModel {
	public DataModel(){
		staggerLabels=true;
		tooltips=false;
		showValues=true;
		idChart="chart";
		key="Cumulative Return";
		duration=500;
	}

	@Setter
	@Getter
	private List<ChartBean> chartValue;
	
	@Setter
	@Getter
	private boolean staggerLabels;
	@Setter
	@Getter
	private boolean tooltips;
	@Setter
	@Getter
	private boolean showValues;
	@Setter
	@Getter
	private String idChart;
	@Setter
	@Getter
	private String key;
	
	@Setter
	@Getter
	private Integer  duration;

}
