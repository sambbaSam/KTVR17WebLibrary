<%-- 
    Document   : showLogin
    Created on : Nov 12, 2018, 10:44:59 AM
    Author     : Sanata
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вход в систем</title>
    </head>
    <body>
        <h1>Введите логин и пароль</h1>
        ${info}<br>
        <form action="login" method="POST" name="form1" id="_form1">
            Логин:<br>
            <input type="text" name="login"><br>
            <br>
            Пароль:<br>
            <input type="password" name="password"><br>
            <br>
            <input type="submit" value="Войти">
        </form><br>
        <hr>
            <p><button><a href="welcom">Home</a></button></p>
    </body>
</html>
