<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cocoa Page Not Found</title>
</head>
<body>
404! Page not found.
Oh No Java Duke looks like something went wrong!
<img src="http://www.comscigate.com/gifs/duke/Duke_Thread.gif" />
<c:catch var="exception">
		<% int x = 5/0; %>
</c:catch>
<c:if test="${exception ne null }">
	<p>Exception is: ${exception }</p>
	Exception message: ${exception.message}
</c:if>
</body>
</html>