package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");//mime type 
		PrintWriter out=response.getWriter();
    	 int id = Integer.parseInt(request.getParameter("stdid")); 
    	 StudentDao sd2 = new StudentDao();
    	  
           int status = sd2.delete(id);
          if(status == 0)
          {
        	  out.println("Record not deleted");
          }
          else
          {
        	  out.println("Record deleted ");
        	// response.sendRedirect("index.jsp");
        	  out.print("<h1><a href = 'index.jsp'> Go to HOME </a></h1>");
          }
	
	
	
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

}
