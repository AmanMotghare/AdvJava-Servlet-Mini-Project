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

import MyDao.SelectDetails;
import MyPojo.ModelClass;

@WebServlet("/profile")
public class Profile extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		//false returns null is session is not present
		
		if(session!=null){
			
			String Email = (String) session.getAttribute("email");
			String Password = (String) session.getAttribute("password");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("navbar.html");
			dispatcher.include(request, response);
			
			ModelClass pojo = SelectDetails.getUserDetails(Email, Password);
			

			
			out.print("<!DOCTYPE html><html>"
							+ "<head>"
							+ "<meta charset='ISO-8859-1'>"
							+ "<title>Insert title here</title>"
							+ "<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css'"
							+ "integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>"
							+ "</head>"
							+ "<body class='container'>"
							+ "<h2 class='container text-center'>Welcome "+ pojo.getName()+"</h2>"
							+ "<hr>"
							+ "<div class='container'>"
							+ "<div class='card' style='width: 25rem; margin-left: 40%;'>"
							+ "<div class='card-body '>"
							+ "<h5 class='card-title text-center'>Your Details</h5>"
							+ "<hr>"
							+ "<p>"
							+ "<h4>City : "+pojo.getCity()+" </h4>"
							+ "<h4>Contact : "+pojo.getContact()+"</h4>"
							+ "<h4>Email : "+pojo.getEmail()+"</h4>"
							+ "<h4>Password : "+pojo.getPassword()+"</h4>"
							+ "</p>"
							+ "</div>"
							+ "</div>"
							+ "</div>"
							+ "</body>"
							+ "</html>'");
			
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
