package employee_handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.login_bo;
import com_dao.student_dao;

/**
 * Servlet implementation class Sign_up_handler
 */
@WebServlet("/Sign_up_handler")
public class Sign_up_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sign_up_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("mail");
		int pass=Integer.parseInt(request.getParameter("pss"));
		String ph=request.getParameter("phone");
		
		login_bo lb=new login_bo();
		
		lb.setName(name);
		lb.setEmail(email);
		lb.setPassword(pass);
		lb.setPhoneNo(ph);
		
		int status=student_dao.sign_up(lb);
		
		
		if(status>0)
		{
			pw.print("Signup successfully");
			
			RequestDispatcher rd=request.getRequestDispatcher("Login_page.html");
			
			rd.forward(request, response);
		}
		
		else
		{
			pw.print("Something went wrong");
			
			RequestDispatcher rd=request.getRequestDispatcher("Sign_up.html");
			
			rd.include(request, response);
		}
		
		
	}

}
