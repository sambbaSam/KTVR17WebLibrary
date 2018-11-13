<%-- 
    Document   : newBook
    Created on : Sep 26, 2018, 10:50:01 AM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новая книга</title>
    </head>
    <body>
        <h1>Добавляем в библиотеку новую книгу</h1>
        <form action="addBook" method="POST" name="form1" id="_form1">
             <p>Название:<br><input type="text" name="nameBook">
             <p>Автор:<br><input type="text" name="author">
             <p>Год издания:<br><input type="text" name="yearPublished">
             <p>ISBN:<br><input type="text" name="isbn">
             <p>Количество экземпрляров:<br><input type="text" name="count">
            <p><input type="submit" value="Добавить">
        </form>
        <hr>
        <p><button><a href="welcom">Home</a></button></p>
    </body>
</html>
