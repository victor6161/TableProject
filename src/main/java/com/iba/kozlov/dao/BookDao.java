package com.iba.kozlov.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iba.kozlov.dto.BookDto;
import com.iba.kozlov.jdbc.ConnectionCustomer;



public class BookDao {


	List<BookDto> arrayList=new ArrayList<>();
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement prstmt;
	private ConnectionCustomer connectionCustomer=new ConnectionCustomer();
	public List<BookDto>  read() {
		String query = "SELECT books.id,bookname,author,price,username FROM books LEFT JOIN user ON books.user_id=user.id ";
		try {
			stmt = connectionCustomer.getConnection().createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String bookname = rs.getString(2);
				String author = rs.getString(3);
				int price=rs.getInt(4);
				String userId=rs.getString(5);
				System.out.println("Books id : " + id);
				System.out.println("BookName :" + bookname);
				System.out.println("author :" + author);
				System.out.println("userId :" + userId);
				arrayList.add(new BookDto(bookname,author,price,userId));
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
	
	public  void createBook(String bookname,String author,int price,int user_id) {
		String query = "INSERT INTO books"
				+ "(bookname, author, price,user_id) VALUES"
				+ "(?,?,?,?)";
	    //String query = "INSERT INTO books (bookname,author,price,booked,user_id) VALUES ( 'Zara', 'Ali', 18,true,1)";
		try {
			prstmt  = new ConnectionCustomer().getConnection().prepareStatement(query);
			prstmt.setString(1, bookname);
			prstmt.setString(2, author);
			prstmt.setInt(3, price);
			prstmt.setInt(4, user_id);
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

	public  void updatePrice(int id, int price) {
		String query = "UPDATE books SET price=? WHERE id=?";
		try {
			prstmt = new ConnectionCustomer().getConnection().prepareStatement(query);
			prstmt.setInt(1, price);
			prstmt.setInt(2, id);
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
		try {

			prstmt = new ConnectionCustomer().getConnection().prepareStatement(query);
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
}
