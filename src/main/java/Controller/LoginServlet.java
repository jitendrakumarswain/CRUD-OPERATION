package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Student;
import dao.LoginDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 
		
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginDao ed = new LoginDao();
		
		boolean status = ed.validateData(email ,password);
		if(status==false)
		{
			out.println("<h1>login failed</h1>");
			
		}
		else
		{
			out.println("<h1>login Successfull</h1>");
			//out.println(email+"<h1>Welcome to our pogramming world !</h1>");
			Student obj=ed.getStudent(email,password);
			//out.println(obj.getName()+"<h1>Welcome to our pogramming world !</h1>");
			///out.println(obj.getDesignation()+"<h1>Welcome to our pogramming world !</h1>");
			
			HttpSession session=request.getSession();  
	        session.setAttribute("xyz",obj.getStdname()); 
	        out.print("<a href='Home.jsp'>Home</a>");
		
		
		
		
		
		
		
		
		
		
	}

	}
}
