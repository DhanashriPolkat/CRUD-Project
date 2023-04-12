package employee_handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.stud_add_bo;
import com_dao.student_dao;

/**
 * Servlet implementation class Edit_handler
 */
@WebServlet("/Edit_handler")
public class Edit_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
          
	      
	    
	      stud_add_bo eb= student_dao.getEmployeeById(id);
	  
	    
		 
		pw.print("<form  action='Update_Controller' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Joining : </td> <td><input type='text' name='doj' value='"+eb.getDoj()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Birth: </td> <td><input type='text' name='dob' value='"+eb.getEoj()+"'/></td></tr>");
	   	pw.print("<tr><td>Adhar Card: </td> <td><input type='text' name='adhar' value='"+eb.getAdhar()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
	}

}
