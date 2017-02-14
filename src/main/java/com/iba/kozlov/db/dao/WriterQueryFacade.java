package com.iba.kozlov.db.dao;



public class WriterQueryFacade {
	public static String getQueryUpdateSurname(){
		return "UPDATE writer SET surname=?  WHERE id=?";
	}
	
	public static String getQueryCreate(){
		return "INSERT INTO writer (name,surname,country) VALUES (?,?,?)";
	}
	
	public static String getQueryRead(WriterSearchCriteria pCriteria){
		StringBuffer query = new StringBuffer("SELECT id,name,surname,country FROM writer");
		if (pCriteria == null) {
			return query.toString();
		}
		if(pCriteria.getWriterId()!=null){
			query.append(" where id="+pCriteria.getWriterId());
		}
		
		return query.toString();
	}

	public static String getQueryUpdate() {
		
		return "Update writer SET name=?,surname=?,country=? WHERE id=?";
	}
}
