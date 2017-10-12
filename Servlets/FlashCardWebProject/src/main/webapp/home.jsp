<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<!--  JSP: Java Sever Pages
		Type of Template Engine
		Template = HTML
 -->
				<!-- JSP scriptlet called expression to print to the webpage -->
<h1>The user <%=  request.getParameter("username") %> has logged in!</h1>

<a href="profile.jsp">Goto Profile</a>
</body>
</html>