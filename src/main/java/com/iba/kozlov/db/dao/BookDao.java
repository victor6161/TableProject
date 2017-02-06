package com.iba.kozlov.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.db.xception.CriteriaNullException;



public class BookDao {
	private static final Logger LOGGER = Logger.getLogger(BookDao.class);
	public List<BookDto>  read(BookSearchCriteria pCriteria) {
		LOGGER.info("readDao");
		List<BookDto> arrayList=new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = new CustomConnection().getConnection().createStatement();
			try {
				rs = stmt.executeQuery(BookQueryFacade.getQueryBook(pCriteria));
			} catch (CriteriaNullException e) {
				LOGGER.fatal("CriteriaNullException" +e.getMessage());
			}
			while (rs.next()) {
				int id = rs.getInt(1);
				String bookname = rs.getString(2);
				int price=rs.getInt(3);
				String writerSurname = rs.getString(4);
				String readerSurname=rs.getString(5);
				ReaderDto readerDto=new ReaderDto(readerSurname);
				WriterDto writerDto=new WriterDto(writerSurname);
				LOGGER.info("id "+id);
				LOGGER.info("bookname "+bookname);
				LOGGER.info("price "+price);
				LOGGER.info("writerSurname "+writerSurname);
				LOGGER.info("readerSurname "+readerSurname);
				arrayList.add(new BookDto(id,bookname,price,readerDto,writerDto));
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
	public List<BookDto>  readId(BookSearchCriteria pCriteria) {
		LOGGER.info("readId");
		List<BookDto> arrayList=new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = new CustomConnection().getConnection().createStatement();
			rs = stmt.executeQuery(BookQueryFacade.getQueryIdWriterIdBook());
			
			while (rs.next()) {
				int id = rs.getInt(1);
				
				int writerId=rs.getInt(2);
				
				LOGGER.info("id "+id);
				LOGGER.info("writerId "+writerId);
			
				arrayList.add(new BookDto(id,writerId));
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
	
	
	public  void addBook(BookDto bookDto) {
		LOGGER.info("addBook");
		PreparedStatement prstmt = null;
		try {
			prstmt  = new CustomConnection().getConnection().prepareStatement(BookQueryFacade.getQueryInsertBook());
			prstmt.setString(1, bookDto.getBookname());
			prstmt.setInt(2, bookDto.getPrice());
			prstmt.setInt(3, bookDto.getWriterId());
			prstmt.setInt(4, 2);
			prstmt.executeUpdate();

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
				try {
					prstmt.close();
				} catch (SQLException se1) {
				}
			
			
		}
	}
	/*

	public  void updatePrice(BookDto bookDto) {
		LOGGER.info("updatePrice id=" +bookDto.getId()+" new price is "+bookDto.getPrice());
		PreparedStatement prstmt = null;
		try {
			prstmt = new CustomConnection().getConnection().prepareStatement(BookQueryFacade.getQueryUpdatePrice());
			prstmt.setInt(1, bookDto.getPrice());
			prstmt.setInt(2, bookDto.getId());
			prstmt.executeUpdate();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {

				try {
					prstmt.close();
				} catch (SQLException se1) {
				}
			
		}
	}

	public void deleteBook(int id) {
		String query = "DELETE FROM books WHERE id=?";
		PreparedStatement prstmt = null;
		try {

			prstmt = new CustomConnection().getConnection().prepareStatement(query);
			prstmt.setInt(1, id);
			prstmt.executeUpdate();

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
				try {
					prstmt.close();
				} catch (SQLException se1) {
				}
		}
		
	}
	public void deleteBook(BookDto bookDto) {
		String query = "DELETE FROM books WHERE id=?";
		PreparedStatement prstmt = null;
		try {

			prstmt = new CustomConnection().getConnection().prepareStatement(query);
			prstmt.setInt(1, bookDto.getId());
			prstmt.executeUpdate();

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
				try {
					prstmt.close();
				} catch (SQLException se1) {
				}
		}
		
	}*/

	public void updateAll(BookDto bookDto) {
		
		LOGGER.info("updatePrice id=" +bookDto.getId()+" new price is "+bookDto.getPrice()+" new bookname is "+bookDto.getBookname());
		PreparedStatement prstmt = null;
		try {
			prstmt = new CustomConnection().getConnection().prepareStatement(BookQueryFacade.getQueryUpdateBook());
			prstmt.setInt(1, bookDto.getPrice());
			prstmt.setString(2, bookDto.getBookname());
		/*	prstmt.setString(3, bookDto.getWriter().getSurname());*/
			prstmt.setInt(3, bookDto.getId());
			prstmt.executeUpdate();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {

				try {
					prstmt.close();
				} catch (SQLException se1) {
				}
			
		}
	}
}
