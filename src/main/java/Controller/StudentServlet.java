package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Entity.Student;

import dao.StudentDao;

@WebServlet("/stdservlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String event=request.getParameter("event");
			System.out.println(event);

			if(event.equals("save")) // event is used for doing the CRUD  operation in 1 servlet file .
			{
				String name=request.getParameter("stdName");// this stdName is coming from the index.jsp inside label.
				String email=request.getParameter("stdEmail");
				int roll = Integer.parseInt(request.getParameter("stdRollno"));
				String password=request.getParameter("stdPassword");
				
			
				Student obj = new Student();
				obj.setStdname(name);
				obj.setStdemail(email);
				obj.setStdrollno(roll);
				obj.setStdPassword(password);
				StudentDao sd=new StudentDao();
			
				int status=sd.saveStudent( obj );  // now we have to pass this object to DAO 
				if(status==0) 
				{
					out.print("<h1>Record Not Inserted!</h1>");
				}
				else 
				{
					out.print("Record  Inserted!");
					out.print("<h1><a href = 'index.jsp'> Go to HOME </a></h1>");
				}
			}
			//end of the save
			else if(event.equals("view")) {
				
				StudentDao  sd=new StudentDao();
				List<Student> stdList=sd.viewStudent();
				System.out.println(stdList);
				
				
				out.print("<table border='1' width='100%'>");  
		        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Roll NO</th>"
		        		+ "<th>Password</th>  ");
		        out.print("<th>Edit</th><th>Delete</th></tr>");    // To display the fields on the browser 
		        
		        
		        for(Student e:stdList){  
		         out.print("<tr><td>"+e.getStdid()+"</td><td>"+e.getStdname()+"</td>"); 
		         out.print("<td>"+e.getStdemail()+"</td>"); 
		         out.print("<td>"+e.getStdrollno()+"</td><td>"+e.getStdPassword()+"</td>");
		         out.print("<td><a href='EditServlet?stdid="+e.getStdid()+"'>edit</a></td> "); 
		         out.print("<td><a href='DeleteServlet?stdid="+e.getStdid()+"'>delete</a></td></tr>");  
		        }  
		        out.print("</table>"); 
			}
			
			//end of view 
			else if(event.equals("update")) {
				
				
				int id=Integer.parseInt(request.getParameter("stdId"));
				String name=request.getParameter("stdName");// this stdName is coming from the index.jsp inside label.
				String email=request.getParameter("stdEmail");
				int roll = Integer.parseInt(request.getParameter("stdRollno"));
				String password=request.getParameter("stdPassword");
				
				Student obj =new Student();
				
				obj.setStdid(id);
				obj.setStdname(name);
				obj.setStdemail(email);
				obj.setStdrollno(roll);
				obj.setStdPassword(password);
				
				StudentDao sd=new StudentDao();
				int status=sd.updateStudent(obj);
				if(status==0) 
				{
					out.print("<h1>Record Not Updated!</h1>");
				}else {
					out.print("Record  Updated!");
					out.print("<h1><a href = 'index.jsp'> Go to HOME </a></h1>");
				}
			}

			}
	}

	




