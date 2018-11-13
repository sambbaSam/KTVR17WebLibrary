<%-- 
    Document   : page2
    Created on : Sep 26, 2018, 9:37:07 AM
    Author     : Sanata
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Главная</title>
    </head>
    <body>
        <h1>Навигация по сайту</h1>
        ${textToPage}<br>
        <p><a href="newBook">Добавить книгу</a></p>
        <p><a href="newReader">Добавить читателя</a></p>
        <p><a href="showBooks">Список книг</a></p>
        <p><a href="showReader">Список читателей</a></p>
        <p><a href="library">Выдать книгу</a></p>
        <p><a href="showTakeBook">Список выданных книг</a></p>
        <hr>
        Добавлена книга: "${book.nameBook}", ${book.author} <br>
        Добавлен читатель:  ${reader.name}  ${reader.surname}<br>
         <hr>
         <p>Для администратора:</p>
        <p><button><a href="newRole">New Role</a></button></p>
        <p><button><a href="editUserRoles">Users Role</a></button></p>
    </body>
</html>
