<%-- 
    Document   : editUserRoles
    Created on : 7.11.2018, 12:36:52
    Author     : Sanata
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Назначение ролей</title>
    </head>
    
    <body>
        <h2>Назначение пользователяm ролей</h2>
        <form action="changeUserRole" method="POST">

            <select name="user" value="">
                <c:forEach var="user" items="${listUsers}">
                    <option value="${user.id}">${user.login}</option>
                </c:forEach>
            </select>
            <select name="role">
                <c:forEach var="role" items="${listRoles}">
                    <option value="${role.id}">${role.name}</option>
                </c:forEach>
            </select>
            <button type="submit" name="setButton">Назначить</button>
            <button type="submit" name="deleteButton">Удалить</button>
        </form>
        <hr>
        <p><p><button><a href="welcom">Home</a></button></p>
    </body>
</html>
