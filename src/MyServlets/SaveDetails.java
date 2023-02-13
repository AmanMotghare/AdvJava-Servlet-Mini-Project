package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyDao.Insert;
import MyPojo.ModelClass;

@WebServlet("/saveDetails")
public class SaveDetails extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("SignUp.html");
		
		String Name = request.getParameter("name");
		String Email = request.getParameter("email");
		String City = request.getParameter("city");
		String Contact = request.getParameter("contact");
		String Password = request.getParameter("password");
		
		ModelClass pojo = new ModelClass();
		
		pojo.setName(Name);
		pojo.setEmail(Email);
		pojo.setContact(Contact);
		pojo.setCity(City);
		pojo.setPassword(Password);
		
		int status = Insert.InsertData(pojo);
		
		if(status>0){
			dispatcher.include(request,response);
			out.print("<script>alert('User Registration Done Successfully!')</script>");
		}
		else{	
			dispatcher.include(request,response);
			out.print("<script>alert('User Registration Failed')</script>");
		}
		
	}

}
