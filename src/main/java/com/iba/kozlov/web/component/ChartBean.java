package com.iba.kozlov.web.component;

import lombok.Getter;
import lombok.Setter;

public class ChartBean implements Comparable<ChartBean> {
	public ChartBean() {
		super();
	}

	public ChartBean(String writerSurname, Integer bookAmount) {
		super();
		this.writerSurname = writerSurname;
		this.bookAmount = bookAmount;
	}

	@Setter
	@Getter
	private String writerSurname;

	@Setter
	@Getter
	private Integer bookAmount;

	@Override
	public int compareTo(ChartBean o) {
		if (this.getBookAmount() < o.getBookAmount()) {//сортировка по убыванию 
			return 1;
		}
		if (this.getBookAmount() > o.getBookAmount()) {
			return -1;
		}
		return 0;
	}

}
