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

public class Nur_det extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				
				String n = request.getParameter("Name-N");
				ResultSet rs;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital", "root", "admin");
					Statement stm = con.createStatement();
					
						rs = stm.executeQuery("select * from apollo where Name = '"+n+"'");
						if(rs.next()){
							System.out.println("Patient Details");
							HttpSession hs = request.getSession();
							hs.setAttribute("nurse", n);
							RequestDispatcher rd = request.getRequestDispatcher("Admin_nur.jsp");
							rd.forward(request, response);
						}
						else {
							System.out.println("No Data found for " + n);
							RequestDispatcher rd = request.getRequestDispatcher("Admin_Page_wrong_details.jsp");
							rd.forward(request, response);
						}
				}
				catch(Exception e1) {
					System.out.print(e1);
				}
				
					
			}
}