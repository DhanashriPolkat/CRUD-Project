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
 * Servlet implementation class Update_Controller
 */
@WebServlet("/Update_Controller")
public class Update_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Controller() {
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
         
        String name= request.getParameter("name");
        String email= request.getParameter("email");
        String phone= request.getParameter("phone");
        String doj= request.getParameter("doj");
        String eoj= request.getParameter("dob");
        String adhar= request.getParameter("adhar");
        
        
        stud_add_bo eb=new stud_add_bo();
        eb.setId(id);
        eb.setName(name);
        eb.setEmail(email);
        eb.setPhone(phone);
        eb.setDoj(doj);
        eb.setEoj(eoj);
        eb.setAdhar(adhar);
        
       int status= student_dao.Update(eb);
       
       if(status>0) {
     	   
     	  RequestDispatcher rd=request.getRequestDispatcher("All_Employee_Controller");
     	    rd.forward(request, response);
	}
	}

}
