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
        <title>Новый читатель</title>
    </head>
    <body>
        <h1>Добавляем в библиотеку нового читателя</h1>
        <form action="addReader" method="POST" name="form1" id="_form1">
             <p>Имя:<br> <input type="text" name="name"> 
             <p>Фамилия:<br><input type="text" name="surname"><br>
             <p>Телефон:<br><input type="text" name="phone">
             <p>Город:<br><input type="text" name="city">
             <p>Логин:<br><input type="text" name="login">
            <p>Пароль:<br><input  name="password1" type="password">
            <p>Повторить пароль:<br><input  name="password2" type="password">
            <p><input type="submit" value="Добавить">
        </form>
        <hr>
        <p><button><a href="welcom">Home</a></button></p>
        
    </body>
</html>
