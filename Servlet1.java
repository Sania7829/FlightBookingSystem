package flightBooking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  response.setContentType("text/html");

		PrintWriter out=response.getWriter();
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		out.print("<h1>Display the records</h1>");
		 out.print("<table border='1'><tr><th>Id</th><th>Source</th><th>Destination</th><th>Departure Time</th><th>Arrival Time</th><th>Price</th><th></th></tr>");
/*		out.print("<table border='1'><tr><th>Id</th><th>Source</th><th>Destination></th><th>Departure Time</th><th>Arrival Time</th><th>Price</th>");
*/		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/flight_booking_project","root","password@123");   
			      
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from flightData where source='Mumbai' and destination='Nagpur'");  
			System.out.println(rs);
			while(rs.next())
			{
				out.print("<tr><td>");
				out.println(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getTime(4));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getTime(5));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(6));
				out.print("</td>");
				out.print("<td>");
				out.println("<button><a href=\"userLogin.html\">Book</button>");
				out.print("<td>");
				out.print("</tr>");
	}	          
			}catch(Exception e){System.out.println(e);}  
out.print("</table>");

			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
