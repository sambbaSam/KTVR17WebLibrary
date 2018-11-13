<%-- 
    Document   : page2
    Created on : Sep 26, 2018, 9:44:11 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!---<h1>Hello Page2.jsp</h1>--->
        <!---${text}--->
        <a href="newBook"> Добавить книгу</a><br><br>
        <a href="newReader"> Добавить читателя</a><br><br>
        <a href="showBooks"> Список книг</a><br><br>
        <a href="showReaders"> Список читателей</a><br><br>
        <a href="library">Выдать книгу</a><br><br>
        <a href="showTakeBook">Список выданных книг</a><br><br>
        <!------>
        
        <h3>Добавлена книга:</h3><!---   или все данные книги книги ${book}--->
        <b>Название -</b>  ${book.nameBook}<br>
        <b>Автор -</b>  ${book.author}<br><br>
        
        <h3>Добавлен читатель:</h3><!---   или все данные читател ${reader}--->
        <b>Имя -</b>  ${reader.name}<br>
        <b>Фамилия -</b>  ${reader.surname}<br>
        <b>Телефон -</b>  ${reader.phone}<br>
        <b>Город -</b>  ${reader.city}<br>
  
    </body>
</html>
