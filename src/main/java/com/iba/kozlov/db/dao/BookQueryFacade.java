package com.iba.kozlov.db.dao;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.BookServiceImpl;
import com.iba.kozlov.db.xception.CriteriaNullException;

public class BookQueryFacade {
	
	public static String getQueryBook(BookSearchCriteria pCriteria) throws CriteriaNullException {
		StringBuffer query=new StringBuffer("SELECT  books.id,bookname,author,price,username FROM books LEFT JOIN user ON books.user_id=user.id");
		
		boolean bp=false;
		if(pCriteria==null){
			throw new CriteriaNullException();
			
		}
		if(pCriteria.getAuthor()==null){
			throw new CriteriaNullException();
		}
	/*	if(pCriteria.getAuthor().isEmpty() && pCriteria.getName().isEmpty() && pCriteria.getPrice().equals(0)){
			return query.toString();
		}else{
			query.append(" where ");
		}*/
		//на нулл строки проверить
		if(pCriteria.isEmpty()){
			return query.toString();
		}else{
			query.append(" where ");
		}
	
		
		if(!pCriteria.getAuthor().isEmpty()){
			bp=true;
			query.append("author='"+pCriteria.getAuthor()+"'");
		}
		
		if(!pCriteria.getName().isEmpty()){
			if(bp){
				query.append(" and ");
			}
			bp=true;
			query.append("bookname='"+pCriteria.getName()+"'");
		}
		if(!pCriteria.getPrice().equals(0)){
			if(bp){
				query.append(" and ");
			}
			query.append("price<"+pCriteria.getPrice().toString());
		}
		return query.toString();
	}
}

//stringbuffer несколько параметров

/*	query = "SELECT books.id,bookname,author,price,username FROM ";


if(!pCriteria.getAuthor().isEmpty()){
	append("author = ").append(pCriteria.getAuthor())
}
*/
/*	if(!pCriteria.getAuthor().isEmpty()){
		query = "SELECT books.id,bookname,author,price,username FROM "	
		+ "where bookname = '" + pCriteria.getAuthor() + "'"
		+ "books LEFT JOIN user ON books.user_id=user.id ";
}else{
		query = "SELECT books.id,bookname,author,price,username FROM "
		+ "books LEFT JOIN user ON books.user_id=user.id ";
}*/
