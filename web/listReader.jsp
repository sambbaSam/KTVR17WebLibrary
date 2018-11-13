<%-- 
    Document   : istReader
    Created on : Oct 5, 2018, 9:11:16 AM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список читателей</title>
    </head>
    <body>
        <h1>Список читателей</h1>
       <ol type="1">
            <c:forEach var="reader" items="${listReader}">
                <li>${reader.name} ${reader.surname}</li>
            </c:forEach>
        </ol>
        <hr>
        <p><button><a href="welcom">Home</a></button></p>
    </body>
</html>
