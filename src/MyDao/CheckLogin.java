package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLogin {
	
	private static final String Select_login_query = "select * from mytable where email=? and password=?";
	
	public static boolean validate(String Email, String Password){
		boolean status = false;
		
		try {
			Connection con = GetConnection.Connect();
			
			PreparedStatement ps = con.prepareStatement(Select_login_query);
			
			ps.setString(1, Email);
			ps.setString(2, Password);
			
			ResultSet rs = ps.executeQuery();
			
			status = rs.next();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

}
