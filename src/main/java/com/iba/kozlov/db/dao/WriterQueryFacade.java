package com.iba.kozlov.db.dao;

public class WriterQueryFacade {
	public static String getQueryUpdateSurname(){
		return "UPDATE writer SET surname=?  WHERE id=?";
	}
	
	public static String getQueryCreate(){
		return "INSERT INTO writer (surname) VALUES (?)";
	}
	
	public static String getQueryRead(){
		return "SELECT id,name,surname FROM writer";
	}
}
