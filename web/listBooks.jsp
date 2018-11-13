<%-- 
    Document   : listBooks
    Created on : Oct 3, 2018, 10:46:46 AM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список книг</title>
    </head>
    <body>
        <h1>Список книг:</h1>
        <ol type="1">
            <c:forEach var="book" items="${listBooks}">
                <li>
                    ${book.nameBook} ${book.author} 
                    <a href="deleteBook?deleteBookId=${book.id}">Удалить книгу</a>
                </li>
            </c:forEach>
        </ol>
        <hr>
        <p><button><a href="welcom">Home</a></button></p>
    </body>
</html>
