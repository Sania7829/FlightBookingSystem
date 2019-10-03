package flightBooking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet1
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        //Print writer is uded to display in frontend 
        String name=request.getParameter("u_name");  
        String password=request.getParameter("Password");  
        String repeatpassword=request.getParameter("RepeatPassword");  
        String email=request.getParameter("Email_Id");  
          
        RegisterCust r=new RegisterCust();  
        r.setU_name(name);;  
        r.setPassword(password);
        r.setRepeatPassword(repeatpassword);
        r.setEmail_id(email);
          
        int status=RegisterCustDao.save(r);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("userLogin.html").include(request, response);; 
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  

	}

