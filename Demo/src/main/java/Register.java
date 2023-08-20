

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.print("test");
		String fName = request.getParameter("Name");
		String lName = request.getParameter("LastName");
		String email = request.getParameter("Email");
		
		String pass = request.getParameter("Password");
		
		String address = request.getParameter("Address");
		
		String month = request.getParameter("birthday_month");
		String day = request.getParameter("birthday_day");
		String year = request.getParameter("birthday_year");
		
		String gender = request.getParameter("radiobutton");
		String birth = month+"/"+day+"/"+year;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage", "root", "3zs63kg5");
			
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
			ps.setString(1, fName);
			ps.setString(2, lName);
			ps.setString(3, email);
			ps.setString(4, pass);
			ps.setString(5, address);
			ps.setString(6, birth);
			ps.setString(7, gender);
			
			int i=ps.executeUpdate();
			if(i>0) {
				out.print("You have successfully registered!");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			
		}
		out.close();
	}

}
