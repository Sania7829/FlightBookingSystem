package flightBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
public static boolean validate(String username, String password) {
		
		boolean status=false;  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con1=DriverManager.getConnection("jdbc:Mysql://localhost:3306/flight_booking_project","root","password@123");   
			      
			PreparedStatement ps=con1.prepareStatement(  
			"select * from logindetails where u_name=? and Password=?");  
			ps.setString(1,username);  
			ps.setString(2,password);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
			          
			}catch(Exception e){System.out.println(e);}  
			return status;  
			}

}
