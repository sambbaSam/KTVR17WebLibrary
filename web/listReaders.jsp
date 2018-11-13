<%-- 
    Document   : listReader
    Created on : Oct 5, 2018, 8:44:58 AM
    Author     : Sanata
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- библиотека  для создания шаблонов в HTML документе -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список читателей</title>
    </head>
    <body>
        <h3>Список читателей</h3>
        <c:forEach var="reader" items="${listReaders}"><!-- конструкция списка, где каждый объект списка вставляется в переменную $(listBooks) -->
            <ul>
                <li>${reader.name}  ${reader.surname}. ${reader.city}</li>  
            </ul>   
        </c:forEach>    
    <br>
        <p><a href="page2">Home</a><br><br>
            
    </body>
</html>