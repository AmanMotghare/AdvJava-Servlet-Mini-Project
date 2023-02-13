package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(MyDao.CheckLogin.validate(email, password)){
			
			HttpSession session = request.getSession();
			System.out.println(session);
			session.setAttribute(email, email);
			session.setAttribute(password, password);
			
			response.sendRedirect("profile");
			
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);
			out.print("<script>alert('Invalid Credentials !! Please Try Again');</script>");
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}