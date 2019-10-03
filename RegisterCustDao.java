package flightBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegisterCustDao {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
        	Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/flight_booking_project","root","password@123");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
	    public static int save(RegisterCust rc){  
	        int status=0;  
	        try{  
	            Connection con=RegisterCustDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
                        "insert into logindetails values (default,?,?,?,?)");  
	            //prepared statement is a interface which is used to execute a query and pass parameters at run time
	            ps.setString(1,rc.getU_name());  
	            ps.setString(2,rc.getPassword());  
	            ps.setString(3,rc.getRepeatPassword());  
	            ps.setString(4,rc.getEmail_id());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	/*
	 * public static int update(RegisterCust rc){ int status=0; try{ Connection
	 * con=RegisterCustDao.getConnection(); PreparedStatement
	 * ps=con.prepareStatement(
	 * "update logindetails set u_name=?,Password=?,RepeatPassword=?,Email_id=? where Reg_id=?"
	 * ); ps.setString(1,rc.getU_name()); ps.setString(2,rc.getPassword());
	 * ps.setString(3,rc.getRepeatPassword()); ps.setString(4,rc.getEmail_id());
	 * ps.setInt(5,rc.getReg_id());
	 * 
	 * status=ps.executeUpdate();
	 * 
	 * con.close(); }catch(Exception ex){ex.printStackTrace();}
	 * 
	 * return status; }
	 */

	/*
	 * public static int delete(int Reg_id){ int status=0; try{ Connection
	 * con=RegisterCustDao.getConnection(); PreparedStatement
	 * ps=con.prepareStatement("delete from logindetails where =?");
	 * ps.setInt(1,Reg_id); status=ps.executeUpdate();
	 * 
	 * con.close(); }catch(Exception e){e.printStackTrace();}
	 * 
	 * return status; } public static RegisterCust getEmployeeById(int Reg_id){
	 * RegisterCust r=new RegisterCust();
	 * 
	 * try{ Connection con=RegisterCustDao.getConnection(); PreparedStatement
	 * ps=con.prepareStatement("select * from logindetails where Reg_id=?");
	 * ps.setInt(1,Reg_id); ResultSet rs=ps.executeQuery(); if(rs.next()){
	 * r.setReg_id(rs.getInt(1)); r.setU_name(rs.getString(2));
	 * r.setPassword(rs.getString(3)); r.setRepeatPassword(rs.getString(4));
	 * r.setEmail_id(rs.getString(5)); } con.close(); }catch(Exception
	 * ex){ex.printStackTrace();}
	 * 
	 * return r; }
	 */  
	    public static List<RegisterCust> getAllEmployees(){  
	        List<RegisterCust> list=new ArrayList<RegisterCust>();  
	          
	        try{  
	            Connection con=RegisterCustDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from logindetails");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	    	    	RegisterCust r=new RegisterCust();  
	    	    	r.setReg_id(rs.getInt(1));  
	                r.setU_name(rs.getString(2));  
	                r.setPassword(rs.getString(3));  
	                r.setRepeatPassword(rs.getString(4));
	                r.setEmail_id(rs.getString(5)); 
	                list.add(r);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    } 
}
