package com.bv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bv.connection.DBconnect;

public class LoginDao {
	
public static boolean validateUser(String username, String password)  {
			String sql = "select username, password from logindetails "
					+ "where username = ? and password= ?";
			boolean status = false;
			Connection con = DBconnect.getConnection();
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
			ResultSet rs = 	pstmt.executeQuery();
			status = rs.next();
			if(status)
			{
				return status;
			}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return status;
		}

	}

