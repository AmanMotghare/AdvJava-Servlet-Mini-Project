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

@WebServlet("/profile")
public class Profile extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		//false returns null is session is not present
		
		if(session!=null){
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("navbar.html");
			dispatcher.include(request, response);
			
			out.print("<h1>hey</h1>");
			
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("footer.html");
			dispatcher1.include(request, response);
			
			
			
		}
		else{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);
			out.print("<script>alert(''!! WARNING : PLEASE LOG IN FIRST !!');</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
