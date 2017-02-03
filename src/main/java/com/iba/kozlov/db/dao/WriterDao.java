package com.iba.kozlov.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.iba.kozlov.db.dto.WriterDto;


public class WriterDao {
	private static final Logger LOGGER = Logger.getLogger(BookDao.class);
	public List<WriterDto>  read(BookSearchCriteria pCriteria) {
		LOGGER.info("read all writer method");
		List<WriterDto> arrayList=new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = new CustomConnection().getConnection().createStatement();
			
			rs = stmt.executeQuery(BookQueryFacade.getQueryReadWriter());
		
			while (rs.next()) {
				int id = rs.getInt(1);
				String writerSurname = rs.getString(2);
			
				LOGGER.info("id "+id);
				LOGGER.info("bookname "+writerSurname);
			
				arrayList.add(new WriterDto(id,writerSurname));
			}
			return arrayList;
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
				try {
					stmt.close();
				} catch (SQLException se1) {
				}
				try {
					rs.close();
				} catch (SQLException se1) {
				}
			
		}
		return arrayList;
	}
	
}
