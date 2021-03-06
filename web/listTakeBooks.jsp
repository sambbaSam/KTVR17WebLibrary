<%-- 
    Document   : takeBooks.jsp
    Created on : Oct 5, 2018, 10:38:13 AM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Выданные книги</title>
    </head>
    <body>
        <h1>Список выданных книг</h1>
        ${info}
            <ul>
                <c:forEach var="history" items="${takeBooks}">
                    <li>Книга: ${history.book.nameBook} взята: ${history.reader.name} ${history.reader.surname}
                        <a href="returnBook?historyId=${history.id}"> Вернуть книгу</a></li>
                </c:forEach> 
            </ul>
            <hr>
            <p><button><a href="welcom">Home</a></button></p>
    </body>
</html>
