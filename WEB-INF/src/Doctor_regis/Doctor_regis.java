package Doctor_regis;

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

public class Doctor_regis extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String n = request.getParameter("Username_D");
				String a = request.getParameter("Age_D");
				String c = request.getParameter("Contact_D");
				String e = request.getParameter("Email_D");
				String p = request.getParameter("Password_D");
				String b = request.getParameter("Branch_D");
				String ph = request.getParameter("Patients_D");
				ResultSet rs;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital", "root", "admin");
					Statement stm = con.createStatement();
					
						int i = stm.executeUpdate("insert into doctor (Name, Age, Contact, Email, Pass_word, Branch, Patients_handled) values('"+n+"', '"+a+"', '"+c+"', '"+e+"', '"+p+"', '"+b+"', '"+ph+"')");
						if(i == 1){
							System.out.println("Data Uploaded Successfully!");
							RequestDispatcher rd = request.getRequestDispatcher("Login_nurse.html");
							rd.forward(request, response);
						}
				}
				catch(Exception e1) {
					System.out.print(e1);
				}
					
			}
}
