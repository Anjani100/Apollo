package Nurse_reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Nurse_login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String e = request.getParameter("Email-N");
				String p = request.getParameter("Password-N");
				ResultSet rs;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital", "root", "admin");
					Statement stm = con.createStatement();
					
						rs = stm.executeQuery("select * from apollo where (Name = '"+e+"' or Email = '"+e+"') and Pass_word = '"+p+"'");
						if(rs.next()){
							System.out.println("Login Successful!");
							HttpSession hs = request.getSession();
							hs.setAttribute("nur1", e);
							RequestDispatcher rd = request.getRequestDispatcher("Home_Page.jsp");
							rd.forward(request, response);
						}
						else {
							System.out.println("Please check your Username or Password.");
							RequestDispatcher rd = request.getRequestDispatcher("Login_nurse_wrong_password.html");
							rd.forward(request, response);
						}
				}
				catch(Exception e1) {
					System.out.print(e1);
				}
					
			}
}