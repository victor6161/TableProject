package com.iba.kozlov;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "AuthorFilter")
@SessionScoped
public class AuthorFilter {
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthorValue(String authorValue) {
		this.author = authorValue;
	} 
}
