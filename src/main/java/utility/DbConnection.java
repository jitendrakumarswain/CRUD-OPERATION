package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public 	static 	Connection 	getCon() {
		
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","abinash");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException es)
		{
			es.printStackTrace();
		}
			if(con == null)
			{
				System.out.println("Connection not established  ");
			}
			else 
			{
				System.out.println("Connection established");
			}
		return con;
		
	}
	
	
}
