package com.iba.kozlov.dao;

import com.iba.kozlov.exception.CriteriaNullException;
import com.iba.kozlov.search.BookSearchCriteria;

public class BookQueryFacade {
	
	public static String getQueryBook(BookSearchCriteria pCriteria) throws CriteriaNullException {
		String query=new String();
		
		if(pCriteria==null){
			throw new CriteriaNullException();
		/*	return "SELECT books.id,bookname,author,price,username FROM "
					+ "books LEFT JOIN user ON books.user_id=user.id ";*/
		}
		if(!pCriteria.getAuthor().isEmpty()){
				query = "SELECT books.id,bookname,author,price,username FROM "	
				+ "where bookname = '" + pCriteria.getAuthor() + "'"
				+ "books LEFT JOIN user ON books.user_id=user.id ";
		}else{
				query = "SELECT books.id,bookname,author,price,username FROM "
				+ "books LEFT JOIN user ON books.user_id=user.id ";
		}
		return query;
	}

}
