package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Bean.PhoneBook;
import Util.DBUtil;

public class PhoneDAO {
	public static Connection con;
	public int insert(PhoneBook pb) {
	       int b=0;
	try {
		con = DBUtil.getConnection();
		
		 String insertSql = "INSERT INTO contacts (name, phone_number, email, address) VALUES (?, ?, ?, ?)";
	     PreparedStatement pstmt = con.prepareStatement(insertSql);
	     pstmt.setString(1, pb.name);
	     pstmt.setString(2,pb.phoneNumber);
	     pstmt.setString(3,pb.email);
	     pstmt.setString(4,pb.address);
	     b=pstmt.executeUpdate();
	      } catch (SQLException e) {
		e.printStackTrace();
	   }finally {
		   try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
          return b;
	}
	
	public int searchContact(String name) {
		int b=0;
		try {
		con = DBUtil.getConnection();
		 String insertSql = "SELECT * FROM contacts WHERE name=?";
	     PreparedStatement pstmt = con.prepareStatement(insertSql);
	     pstmt.setString(1,name);
	     ResultSet rst=pstmt.executeQuery();
	     while(rst.next()) {
	    	 System.out.println();
	    	 System.out.println("Name:"+rst.getString(1));
	    	 System.out.println("Phone Number:"+rst.getString(2));
	    	 System.out.println("Email:"+rst.getString(3));
	    	 System.out.println("Address:"+rst.getString(4));
	    	 System.out.println("Id:"+rst.getString(5));
	       b++;
	     }
	      } catch (SQLException e) {
	    	  b=0;
		e.printStackTrace();
	   }finally {
		   try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
		return b;
	}
	
	public int updateContact(int id,String name,String phoneNumber,String email,String address) {
		int b=0;
		try {
			con = DBUtil.getConnection();
			 String insertSql = "UPDATE contacts set name=?,phone_number=?,email=?,address=? WHERE id=?";
		     PreparedStatement pstmt = con.prepareStatement(insertSql);
		     pstmt.setString(1,name);
		     pstmt.setString(2,phoneNumber);
		     pstmt.setString(3,email);
		     pstmt.setString(4,address);
		     pstmt.setInt(5,id);
		     b=pstmt.executeUpdate();
		      } catch (SQLException e) {
			e.printStackTrace();
		   }finally {
			   try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			   }
		return b;
	}
	
	public int deleteContact(String name) {
		int b=0;
		try {
			con = DBUtil.getConnection();
			 String insertSql = "DELETE FROM contacts WHERE name=?";
		     PreparedStatement pstmt = con.prepareStatement(insertSql);
		     pstmt.setNString(1,name);
		     b=pstmt.executeUpdate();
		      } catch (SQLException e) {
			e.printStackTrace();
		   }finally {
			   try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			   }
		return b;
	}
	public int displayContact() {
		int b=0;
		try {
		con = DBUtil.getConnection();
		 String insertSql = "SELECT * FROM contacts";
	     PreparedStatement pstmt = con.prepareStatement(insertSql);
	     ResultSet rst=pstmt.executeQuery();
	     while(rst.next()) {
	    	 System.out.println();
	    	 System.out.println("Name:"+rst.getString(1));
	    	 System.out.println("Phone Number:"+rst.getString(2));
	    	 System.out.println("Email:"+rst.getString(3));
	    	 System.out.println("Address:"+rst.getString(4));
	    	 System.out.println("Id:"+rst.getString(5));
	    	 System.out.println("________________________________");
	       b++;
	     }
	      } catch (SQLException e) {
	    	  b=0;
		e.printStackTrace();
	   }finally {
		   try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
		return b;
	}
}
