package employee_handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.stud_add_bo;
import com_dao.student_dao;

/**
 * Servlet implementation class All_Employee_Controller
 */
@WebServlet("/All_Employee_Controller")
public class All_Employee_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All_Employee_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   
		   pw.print("<a href='Home.html'>Back Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		   pw.print("<a href='Menu.html'>Back Menu</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		   pw.print("<a href='Insert.html' class='btn'>Add New Data</a><br><br>");
		   
		   
		   pw.print("<body style=\"background-color: rgb(229 208 217 / 18%); backdrop-filter: blur(1px);\">");
		   pw.print("<centre><div style=\"border: solid 2px; background-color: #2dcaf912;color: #c7b0e3; height: fit-content;width: fit-content;margin-left: 250px;margin-top: 100px;border-radius: 20px;padding: 20px;\">");
		   
		   pw.print("<table border='1px' width='100%'> ");
		    
		    pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone </th> <th> Date Of Joining</th> <th> Date Of Birth</th> <th> Adhar Details</th> <th> Delete</th><th> Update</th></tr>");
		   
		   
		   
		  List<stud_add_bo> list= student_dao.getAllEmployee();
		   
		  for(stud_add_bo eb:list) {
			  
			   pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getDoj()+"</td><td>"+eb.getEoj()+"</td><td>"+eb.getAdhar()+"</td><td><a href='Delete_Servlet?id="+eb.getId()+"'>delete </a></td><td><a href='Edit_handler?id="+eb.getId()+"'>edit </a></td></tr>"); 
		  }
		  
		   
		  pw.print("</table>");
	}
	

}
