package com.iba.kozlov.web.application;

import lombok.Getter;
import lombok.Setter;

public class BookBean {
	@Setter
	@Getter
	private int id;

	@Setter
	@Getter
	private String bookname;
	@Setter
	@Getter
	private Integer price;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result + id;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookBean other = (BookBean) obj;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (id != other.id)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	

}
