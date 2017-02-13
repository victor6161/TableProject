package com.iba.kozlov.db.dao;

public class WriterQueryFacade {
	public static String getQueryUpdateSurname(){
		return "UPDATE writer SET surname=?  WHERE id=?";
	}
	
	public static String getQueryCreate(){
		return "INSERT INTO writer (name,surname,country) VALUES (?,?,?)";
	}
	
	public static String getQueryRead(){
		return "SELECT id,name,surname,country FROM writer";
	}

	public static String getQueryUpdate() {
		
		return "Update writer SET name=?,surname=?,country=? WHERE id=?";
	}
}
