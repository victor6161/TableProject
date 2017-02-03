package com.iba.kozlov.db.dao;


import com.iba.kozlov.db.xception.CriteriaNullException;

public class BookQueryFacade {
/*	public static String getQueryUpdatePrice(){
		return "UPDATE book SET price=? WHERE id=?";
	}
	public static String getQueryUpdateBook(){
		return "UPDATE book SET price=?,bookname=?,author=?  WHERE id=?";
	}*/
	
	public static String getQueryInsertBook(){
		return "INSERT INTO book (bookname, price,writer_id,reader_id) VALUES (?,?,?,?)";
	}
	
	public static String getQueryReadWriter(){
		return "SELECT id,surname FROM writer";
	}
	public static String getQueryBook(BookSearchCriteria pCriteria) throws CriteriaNullException {
		StringBuffer query=new StringBuffer("SELECT  b.id,b.bookname,b.price,w.surname,r.surname FROM book as b LEFT JOIN reader as r ON b.reader_id=r.id LEFT JOIN writer as w ON b.writer_id=w.id");
		
	/*	boolean bp=false;
		if(pCriteria==null){
			throw new CriteriaNullException();
			
		}
		if(pCriteria.getAuthor()==null){
			throw new CriteriaNullException();
		}
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
		}*/
		return query.toString();
	}
}

