package PatientDetails;

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

public class Patient_details_nur extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				
				String n = request.getParameter("Pat_name");
				ResultSet rs;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital", "root", "admin");
					Statement stm = con.createStatement();
					
						rs = stm.executeQuery("select * from stage where Name = '"+n+"'");
						if(rs.next()){
							System.out.println("Patient Details");
							HttpSession hs = request.getSession();
							hs.setAttribute("key2", n);
							RequestDispatcher rd = request.getRequestDispatcher("Patient_details_nur.jsp");
							rd.forward(request, response);
						}
						else {
							System.out.println("No Data found for " + n);
							RequestDispatcher rd = request.getRequestDispatcher("Home_Page_wrong_details.jsp");
							rd.forward(request, response);
						}
				}
				catch(Exception e1) {
					System.out.print(e1);
				}
				
					
			}
}