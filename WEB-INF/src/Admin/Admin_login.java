package Admin;

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

public class Admin_login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				
				String ed = request.getParameter("Email-A");
				String pd = request.getParameter("Password-A");
				ResultSet rs;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital", "root", "admin");
					Statement stm = con.createStatement();
					
						rs = stm.executeQuery("select * from admin where (Email = '"+ed+"' or Name= '"+ed+"') and Pass_word = '"+pd+"'");
						if(rs.next()){
							System.out.println("Login Successful!");
							HttpSession hs = request.getSession();
							hs.setAttribute("key4", ed);
							RequestDispatcher rd = request.getRequestDispatcher("Admin_Page.jsp");
							rd.forward(request, response);
						}
						else {
							System.out.println("Please check your Username or Password.");
							RequestDispatcher rd = request.getRequestDispatcher("Admin_wrong_details.html");
							rd.forward(request, response);
						}
				}
				catch(Exception e1) {
					System.out.print(e1);
				}
				
					
			}
}