<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
    <title>Angular QuickStart</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="<c:url value="/angular/styles.css" />">
    <!-- Polyfill(s) for older browsers -->
    <script src="<c:url value="/angular/node_modules/core-js/client/shim.min.js" />"></script>

    <script src="<c:url value="/angular/node_modules/zone.js/dist/zone.js"/>"></script>
    <script src="<c:url value="/angular/node_modules/systemjs/dist/system.src.js"/>"></script>

    <script src="<c:url value="/angular/systemjs.config.js"/>"></script>
    <script>
      System.import('app').catch(function(err){ console.error(err); });
    </script>
</head>
<body>
<h1>
    <my-app>Loading AppComponent content here ...</my-app>
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>