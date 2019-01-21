<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href = "Home_Page.css">
<style type="text/css">
	img{
		width: 40px;
		position: absolute;
		left: 115px;
		top: 85px;
	}
	#home{
		color: cadetblue;
		position: absolute;
		left: 170px;
		top: 92px;
		font-size: 25px;
		font-family: 'Franklin Gothic Medium';
		text-decoration: none;
	}
	#header1{
		color: darkslateblue;
		position: absolute;
		left: 420px;
		top: 100px;
		text-decoration: none;
	}
	#header2{
		color: darkslateblue;
		position: absolute;
		left: 560px;
		top: 100px;
		text-decoration: none;
	}
	#header3{
		color: darkslateblue;
		position: absolute;
		left: 700px;
		top: 100px;
		text-decoration: none;
	}
	#header4{
		color: darkslateblue;
		position: absolute;
		left: 815px;
		top: 100px;
		text-decoration: none;
	}
	#header6{
		color: darkslateblue;
		position: absolute;
		left: 1060px;
		top: 100px;
		text-decoration: none;
	}
	#header7{
		color: darkslateblue;
		position: absolute;
		left: 1200px;
		top: 100px;
		text-decoration: none;
	}
	#header5{
		color: darkslateblue;
		position: absolute;
		left: 990px;
		top: 100px;
		text-decoration: none;
	}
	#Reg{
		position: absolute;
		top: 95px;
		left: 1280px;
		height: 30px;
		background-color: white;
		border: 1px;
		border-color: limegreen;
		border-style: solid;
		border-radius: 5px;
		width: 100px;
	}
	#Reg:hover{
		background-color: limegreen;
		color: white;
	}
	#a5{
	position: absolute;
	left: 100px;
	top: 660px;
	color: dimgrey;
	text-decoration: none;
	}
	#a6{
		position: absolute;
		left: 100px;
		top: 690px;
		color: dimgrey;
		text-decoration: none;
	}
	#a7{
		position: absolute;
		left: 100px;
		top: 720px;
		color: dimgrey;
		text-decoration: none;
	}
	#a8{
		position: absolute;
		left: 100px;
		top: 750px;
		color: dimgrey;
		text-decoration: none;
	}
	#a9{
		position: absolute;
		left: 100px;
		top: 780px;
		color: dimgrey;
		text-decoration: none;
	}
	#a10{
		position: absolute;
		left: 400px;
		top: 660px;
		color: dimgrey;
		text-decoration: none;
	}
	#a11{
		position: absolute;
		left: 400px;
		top: 690px;
		color: dimgrey;
		text-decoration: none;
	}
	#a12{
		position: absolute;
		left: 400px;
		top: 720px;
		color: dimgrey;
		text-decoration: none;
	}
	#a13{
		position: absolute;
		left: 400px;
		top: 750px;
		color: dimgrey;
		text-decoration: none;
	}
	#a14{
		position: absolute;
		left: 700px;
		top: 660px;
		color: dimgrey;
		text-decoration: none;
	}
	#a15{
		position: absolute;
		left: 700px;
		top: 690px;
		color: dimgrey;
		text-decoration: none;
	}
	#a16{
		position: absolute;
		left: 700px;
		top: 720px;
		color: dimgrey;
		text-decoration: none;
	}
	#a17{
		position: absolute;
		left: 1000px;
		top: 660px;
		color: dimgrey;
		text-decoration: none;
	}
	#a18{
		position: absolute;
		left: 1000px;
		top: 690px;
		color: dimgrey;
		text-decoration: none;
	}
	#a19{
		position: absolute;
		left: 1000px;
		top: 720px;
		color: dimgrey;
		text-decoration: none;
	}
	#header1:hover{
		color: cadetblue;
	}
	#header2:hover{
		color: cadetblue;
	}
	#header3:hover{
		color: cadetblue;
	}
	#header4:hover{
		color: cadetblue;
	}
	#header5:hover{
		color: cadetblue;
	}
	#header6:hover{
		color: cadetblue;
	}
	#header7:hover{
		color: cadetblue;
	}
	#a5:hover{
		color: green;
	}
	#a6:hover{
		color: green;
	}
	#a7:hover{
		color: green;
	}
	#a8:hover{
		color: green;
	}
	#a9:hover{
		color: green;
	}
	#a10:hover{
		color: green;
	}
	#a11:hover{
		color: green;
	}
	#a12:hover{
		color: green;
	}
	#a13:hover{
		color: green;
	}
	#a14:hover{
		color: green;
	}
	#a15:hover{
		color: green;
	}
	#a16:hover{
		color: green;
	}
	#a17:hover{
		color: green;
	}
	#a18:hover{
		color: green;
	}
	#a19:hover{
		color: green;
	}
	table {
		border-collapse: collapse;
		position: absolute;
		top: 200px;
		left: 300px;
		width: 900px;
		height: 70px;
	}
	caption {
		font-size: 25px;
		color: cadetblue;
		font-family: 'Fra';
		padding: 20px;
	}
	th, tr, td {
		padding: 20px;
		font-size: 20px;
		font-family: 'Fra';
	}
	table, th {
		table-border: 20px;
		border-color: dimgrey;
	}
	thead {
		background-color: black;
		color: white;
	}
	tbody {
		background-color: dimgrey;
		color: white;
	}
</style>
<title>Apollo Hospital</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<a id = "home" href = "index.jsp">Apollo Hospital</a>
	<a href = "index.jsp"><img src = "https://image3.mouthshut.com/images/imagesp/925860290s.jpg" alt = "Apollo Hospital" /></a>	<a id = "header1" href = "Doctor_details.jsp">View Details</a>
	<a id = "header1" href = "Nurse_details.jsp">View Details</a>
	<a id = "header2" href = "UpdateN.jsp">Update Details</a>
	<a id = "header3" href = "">Resources</a>
	<a id = "header4" href = "Home_Page.jsp">View Patient Details</a>
	<a id = "header5" href = "">Blog</a>
	<a id = "header6" href = "Home.jsp">Add Patient Details</a>
	<form action = "index.jsp" method = "post">
		<input id = "Reg" type = "submit" value = "Sign Out"/>
	</form>
	<table border = 1>
		<caption>Account Details</caption>
		<thead>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Contact</th>
			<th>Email-ID</th>
          	<th>Branch</th>
          	<th>Patients_Handled</th>
		</thead>
		<%
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital", "root", "admin");
    			Statement stm = con.createStatement();
    			ResultSet rs;
    			HttpSession hs = request.getSession();
    			String s = (String)hs.getAttribute("nur1");
    			rs = stm.executeQuery("Select * from apollo where Name = '"+s+"'");
    			while(rs.next()) {
    				System.out.println(rs.getInt(1));%><tr><td><%= rs.getInt(1) %></td>
    				<%System.out.println(rs.getString(2));%><td><%= rs.getString(2) %></td>
    				<%System.out.println(rs.getInt(3));%><td><%= rs.getInt(3) %></td>
    				<%System.out.println(rs.getLong(4));%><td><%= rs.getLong(4) %></td>
    				<%System.out.println(rs.getString(5));%><td><%= rs.getString(5) %></td>
    				<%System.out.println(rs.getString(7));%><td><%= rs.getString(7) %></td>
    				<%System.out.println(rs.getString(8));%><td><%= rs.getString(8) %></td></tr>
    			<% }
        	}
        	catch(Exception e){
				System.out.println(e);
			}
		%>
	</table>
	<p id = "a1">
		<br><br><a id = "a5" href = "">Questions? Contact Us.</a>
		<br><br><a id = "a6" href = "">FAQ</a>
		<br><br><a id = "a7" href = "">Investor Relations</a>
		<br><br><a id = "a8" href = "">Privacy</a>
		<br><br><a id = "a9" href = "">Our Team<br><br><br><br></a>
	</p>
	<p id = "a2">
		<br><br><a id = "a10" href = "">Help Center</a>
		<br><br><a id = "a11" href = "">Jobs</a>
		<br><br><a id = "a12" href = "">Cookie Preference</a>
		<br><br><a id = "a13" href = "">Legal Notices</a>
	</p>
	<p id = "a3">
		<br><br><a id = "a14" href = "">Account</a>
		<br><br><a id = "a15" href = "">Cart</a>
		<br><br><a id = "a16" href = "">Corporation</a>
	</p>
	<span id = "a4">
		<br><br><a id = "a17" href = "">Media</a>
		<br><br><a id = "a18" href = "">Terms of Appointments</a>
		<br><br><a id = "a19" href = "">Contact Us</a>
	</span>
</body>
</html>