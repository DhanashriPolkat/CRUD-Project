package employee_handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.stud_add_bo;
import com_dao.student_dao;

/**
 * Servlet implementation class Add_handler
 */
@WebServlet("/Add_handler")
public class Add_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 response.setContentType("text/html");
		    PrintWriter pw=response.getWriter();
		    String id=request.getParameter("id");
		     String name=request.getParameter("name");
		     String email=request.getParameter("email");
		     String phone=request.getParameter("phone");
		     String doj=request.getParameter("doj");
		     String dob=request.getParameter("dob");
		     String adhar=request.getParameter("adhar");
		     
		   
		     
		     stud_add_bo ab=new stud_add_bo(id,name, email, phone, doj, dob, adhar);
		     
		    int status= student_dao.add_data(ab);
		    
		    if(status>0) {
		    	
		    	 RequestDispatcher rd=request.getRequestDispatcher("All_Employee_Controller");
		    	 rd.forward(request, response);
		    	
		    }else {
		    	pw.print("Something went wrong!!!");
		    	RequestDispatcher rd=request.getRequestDispatcher("Insert.html");
		    	 rd.include(request, response);
		    }
		     
	}
	

}
