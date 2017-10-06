<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.revature.beans.CocoaBean" %>
<!-- JSTL: JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cocoa Home</title>
</head>
<body>
Welcome. Today's flavor is <%= ((CocoaBean) request.getAttribute("dayFlavor")).getFlavor() %>
<!--  Display all the beans! -->
	<%-- ${} expression language: very powerful --%> 
	
<!-- 
	5 library of JSTL 
		core - java flow control
		fmt  - formating text, e.g. currency, cut off decimals etc
   functions - String manipulation
   		SQL  - don't use
   		XML  - also don't use 
-->
<c:out value="${ dayFlavor.id }"></c:out> 
<c:if test="${ dayFlavor.id == 3 }">
	<h1>dayFlavor id is 3!</h1>
</c:if>

<!-- For Loop for the all the CocoaBeans -->
<ul>
	<c:forEach var="b" items="${ cocaList }" >
		<li>${ b.id} ${ b.flavor }</li>
	</c:forEach>
</ul>
</body>
</html>