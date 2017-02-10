package com.iba.kozlov.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dto.ReaderDto;

public class ReaderDao {
	
	private static final Logger LOGGER = Logger.getLogger(BookDao.class);
	
	public List<ReaderDto> read() {
		LOGGER.info("method read all reader ");
		List<ReaderDto> arrayList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = new CustomConnection().getConnection().createStatement();

			rs = stmt.executeQuery(ReaderQueryFacade.getQueryReadReader());

			while (rs.next()) {
				int id = rs.getInt(1);
				String readerName=rs.getString(2);
				String readerSurname = rs.getString(3);

				LOGGER.info("id " + id);
				LOGGER.info("readerSurname " + readerSurname);

				arrayList.add(new ReaderDto(id,readerName, readerSurname));
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
