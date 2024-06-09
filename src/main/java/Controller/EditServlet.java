package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Student;
import dao.StudentDao;


public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");//mime type 
		PrintWriter out=response.getWriter();
		int sid=Integer.parseInt(request.getParameter("stdid"));
		StudentDao s=new StudentDao();
		Student s2=s.getStudentById(sid);
		
		    out.println("<h1>Update Student</h1>");  
	        out.print("<form action='StudentServlet' method='post'>");  
	        out.print("<table>");  
	    
	        out.print("<tr><td></td><td><input type='hidden' name='stdId' value='"+s2.getStdid()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='stdName' value='"+s2.getStdname()+"'/></td></tr>");  
	        out.print("<tr><td>Email:</td><td><input type='email' name='stdEmail' value='"+s2.getStdemail()+"'/></td></tr>"); 
	        out.print("<tr><td>RollNo:</td><td><input type='text' name='stdRollno' value='"+s2.getStdrollno()+"'/></td></tr>"); 
	        out.print("<tr><td>Password:</td><td><input type='password' name='stdPassword' value='"+s2.getStdPassword()+"'/>" ); 
	        out.print("</td></tr>");  
	      
	       
	        out.print("<input type='hidden' name='event' value='update'/>");
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>"); 
	        
	        out.print("</form>");  
	          
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
