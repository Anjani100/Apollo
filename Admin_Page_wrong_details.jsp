<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Login.css">
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
		left: 520px;
		top: 100px;
		text-decoration: none;
	}
	#header3{
		color: darkslateblue;
		position: absolute;
		left: 620px;
		top: 100px;
		text-decoration: none;
	}
	#header4{
		color: darkslateblue;
		position: absolute;
		left: 720px;
		top: 100px;
		text-decoration: none;
	}
	#header5{
		color: darkslateblue;
		position: absolute;
		left: 820px;
		top: 100px;
		text-decoration: none;
	}
	#header6{
		color: darkslateblue;
		position: absolute;
		left: 880px;
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
	#name1{
		left: 388px;
	}
	#input1{
		top: 375px;
	}
	#input5{
		left: 380px;
		top: 480px;
		width: 200px;
		height: 40px;
	}
	#name3{
		left: 940px;
	}
	#input3{
		top: 375px;
	}
	#input6{
		left: 940px;
		top: 480px;
		width: 200px;
		height: 40px;
	}
	#wrong{
		font-size: 20px;
		font-family: 'Fra';
		color: red;
		position: absolute;
		left: 590px;
		top: 180px;
	}
</style>
<title>Apollo Hospital-Admin</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<a id = "home" href = "index.jsp">Apollo Hospital</a>
	<a href = "index.jsp"><img src = "https://image3.mouthshut.com/images/imagesp/925860290s.jpg" alt = "Apollo Hospital" /></a>
	<a id = "header1" href = "">Products</a>
	<a id = "header2" href = "">Customers</a>
	<a id = "header3" href = "">Resources</a>
	<a id = "header4" href = "">Research</a>
	<a id = "header5" href = "">Blog</a>
	<a id = "header6" href = "">About Us</a>
	<form action = "index.jsp" method = "post">
		<input id = "Reg" type = "submit" value = "Sign Out"/>
	</form>
	<p id = "wrong">No Employee found for this name!</p>
	<h2 id = "doc">Doctor</h2>
	<h2 id = "nur">Nurse</h2>
	<form action = "Doc-det" method = "post" onsubmit = "return Validation();">
	<br><br><span id = "name1">Doctor's Name</span><br><br><input id = "input1" type = "text" name = "Name-D" required/>
	<br><br><input id = "input5" type = "submit" value = "View Details" name = "LogInD"/>
	</form>
	<form action = "Nur-det" method = "post" onsubmit = "return Validation();">
	<br><br><span id = "name3">Nurse's Name</span><br><br><input id = "input3" type = "text" name = "Name-N" required/>
	<br><br><input id = "input6" type = "submit" value = "View Details" name = "LogInN"/>
	</form>
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