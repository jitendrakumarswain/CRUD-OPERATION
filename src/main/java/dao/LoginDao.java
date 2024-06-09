package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Student;
import utility.DbConnection;

public class LoginDao {

	public  boolean  validateData(String email , String password)
	{
		boolean status=false;
		try 
		{
			Connection con = DbConnection.getCon();
			String query = "select count(*) from std where email=? and password=? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			status =ps.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return status;
	}
	//View By username password
		public Student getStudent(String email,String password) {
			Student obj=new Student();
			try {
				Connection con=DbConnection.getCon();
				String query="select id,name,email,rollno,password from std where email=? and password=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					obj.setStdid(rs.getInt(1));
					obj.setStdname(rs.getString(2));
					obj.setStdemail(rs.getString(3));
					obj.setStdrollno(rs.getInt(4));
					obj.setStdPassword(rs.getString(6));
				}
			}catch(Exception e) {
				e.getMessage();
			}
			
			return obj;
		}
	
	
	
	
	
	
}
