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

public class Nurse_regis extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String n = request.getParameter("Username_N");
				String a = request.getParameter("Age_N");
				String c = request.getParameter("Contact_N");
				String e = request.getParameter("Email_N");
				String p = request.getParameter("Password_N");
				String b = request.getParameter("Branch_N");
				String ph = request.getParameter("Patients_N");
				ResultSet rs;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital", "root", "admin");
					Statement stm = con.createStatement();
					
						int i = stm.executeUpdate("insert into Apollo (Name, Age, Contact, Email, Pass_word, Branch, Patients_handled) values('"+n+"', '"+a+"', '"+c+"', '"+e+"', '"+p+"', '"+b+"', '"+ph+"')");
						if(i == 1){
							System.out.println("Data Uplaoaded Successfully!");
							RequestDispatcher rd = request.getRequestDispatcher("Login_nurse.html");
							rd.forward(request, response);
						}
				}
				catch(Exception e1) {
					System.out.print(e1);
				}
					
			}
}
