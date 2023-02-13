package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import MyPojo.ModelClass;

public class Insert {
	
	private static final String Insert_Query = "INSERT INTO MYTABLE (NAME,EMAIL,CITY,CONTACT,PASSWORD) VALUES (?,?,?,?,?)";

	
	public static int InsertData (ModelClass pojo) {
		
		 
		int status = 0;
		
		//Create Statement.
		//Connection is a return type.
		 
		try {
			Connection con = GetConnection.Connect();
			
			PreparedStatement ps = con.prepareStatement(Insert_Query);
			
			ps.setString(1, pojo.getName());
			ps.setString(2, pojo.getEmail());
			ps.setString(3, pojo.getCity());
			ps.setString(4, pojo.getContact());
			ps.setString(5, pojo.getPassword());
			
			//Execute update.
					
			status= ps.executeUpdate();
//			System.out.println(status);
			con.close();
		
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return status; 

	}
	
	
}
