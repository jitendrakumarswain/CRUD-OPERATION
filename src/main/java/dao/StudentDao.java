package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Entity.Student;

import utility.DbConnection;

public class StudentDao {
	
	
	//insert
		public int saveStudent(Student  obj) // receiving the call from employeeServlet 
		{
			int status=0;
			try {
			Connection con = DbConnection.getCon(); // creating the connection from dao to database.
			String query="insert into student.std(stdname,stdemail,stdrollno,stdpassword)values(?,?,?,?);";// give the same name as it is given in the table creation .
			PreparedStatement ps=con.prepareStatement(query); // it acts like a bridge  and we pass the query through it .
			
			ps.setString(1,obj.getStdname());
			ps.setString(2, obj.getStdemail());
			ps.setInt(3, obj.getStdrollno());
			ps.setString(4,obj.getStdPassword());
			status=ps.executeUpdate();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return status;
		}
		
	
		//View all
		public List<Student> viewStudent(){
			ArrayList<Student> stdList=new ArrayList<Student>();
			try 
			{
			Connection con=DbConnection.getCon();
			String query="select stdid,stdname,stdemail,stdrollno,stdpassword from std";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Student obj=new Student();
				obj.setStdid(rs.getInt(1));
				obj.setStdname(rs.getString(2));
				obj.setStdemail(rs.getString(3));
				obj.setStdrollno(rs.getInt(4));
				obj.setStdPassword(rs.getString(5));
				
				stdList.add(obj);;
			}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			return stdList;
		}
		
		//View By Id 
		public Student  getStudentById(int a) {
			Student obj=new Student();
			try {
				Connection con=DbConnection.getCon();
				String query="select stdid,stdname,stdemail,stdrollno,stdpassword from std where stdid=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, a);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					obj.setStdid(rs.getInt(1));
					obj.setStdname(rs.getString(2));
					obj.setStdemail(rs.getString(3));
					obj.setStdrollno(rs.getInt(4));				
					obj.setStdPassword(rs.getString(5));
				}
			}catch(Exception e) {
				e.getMessage();
			}
			
			return obj;
		}
		
		
		
		//Update
		public int updateStudent(Student obj)
		{
			int status=0;
			try {
				Connection con = DbConnection.getCon(); 
				String query="update std set stdname=?,stdemail=? ,stdrollno= ? ,stdpassword=? where stdid=?";
				PreparedStatement ps=con.prepareStatement(query); 
				ps.setString(1, obj.getStdname());
				ps.setString(2, obj.getStdemail());
				ps.setInt(3,obj.getStdrollno());
				ps.setString(4, obj.getStdPassword());
				ps.setInt(5, obj.getStdid());
				status=ps.executeUpdate(); // this method is present inside the preparedStatement .
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			
			return status;
		}
		
		// update over 
		
		public  int delete(int id){  
	        int status=0;  
	        try{  
	            
	        	Connection con = DbConnection.getCon();  
	            PreparedStatement ps=con.prepareStatement("delete from std where stdid=?");  
	            ps.setInt(1,id);  
	          
	            status=ps.executeUpdate(); 
	            System.out.println(status);
	            con.close();
	 
	        	}
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        
	        }  
	          
	        return status;  
	    }  
		
		


}
