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

public class Nurse_update extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String n = request.getParameter("Name");
				String p = request.getParameter("Password");
				String np = request.getParameter("NPassword");
				ResultSet rs;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital", "root", "admin");
					Statement stm = con.createStatement();
					
						int i = stm.executeUpdate("update apollo set Pass_word = '"+np+"' where (Name = '"+n+"' or Email = '"+n+"') and Pass_word = '"+p+"'");
						if(i == 1){
							System.out.println("Data Updated Successfully!");
						}
						else {
							System.out.println("Check your Username or Password");
							RequestDispatcher rd = request.getRequestDispatcher("UpdateN_wrong_password.jsp");
							rd.forward(request, response);
						}
				}
				catch(Exception e1) {
					System.out.print(e1);
				}
					
			}
}
