package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MyPojo.ModelClass;

public class SelectDetails {
	
	private static final String get_Details_Query = "select * from mytable where email=? and password=?";
	
	public static ModelClass getUserDetails(String Email, String Password){
		
		ModelClass pojo = new ModelClass();
		
		try {
			Connection con = GetConnection.Connect();
			
			PreparedStatement ps = con.prepareStatement(get_Details_Query);
			
			ps.setString(1, Email);
			ps.setString(2, Password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				pojo.setId(rs.getInt(1));
				pojo.setName(rs.getString(2));
				pojo.setEmail(rs.getString(3));
				pojo.setCity(rs.getString(4));
				pojo.setContact(rs.getString(5));
				pojo.setPassword(rs.getString(6));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pojo;
		
	}

}
