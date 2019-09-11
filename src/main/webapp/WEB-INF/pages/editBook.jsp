<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.09.2019
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty book.name}">
        <title>Add Book</title>
    </c:if>
    <c:if test="${!empty book.name}">
        <title>Edit Book</title>
    </c:if>
</head>
<body>
    <div>
        <c:if test="${!empty book.name}">
            <h2>${book.name}</h2>
            <c:url value="/book/edit" var="var"/>
        </c:if>
        <c:if test="${empty book.name}">
            <h2>Добавление книги</h2>
            <c:url value="/book/add" var="var"/>
        </c:if>
        <form action="${var}" method="POST">
            <c:if test="${!empty book.name}">
                <input type="hidden" name="id" value="${book.id}">
                <label for="name">Название</label>
                <input type="text" name="name" id="name" value="${book.name}">
                <label for="year">Год</label>
                <input type="text" name="year" id="year" value="${book.year}">
            </c:if>
            <c:if test="${empty book.name}">
                <label for="name">Название</label>
                <input type="text" name="name" id="name">
                <label for="year">Год</label>
                <input type="text" name="year" id="year">
            </c:if>
            <input type="submit" value="Сохранить">
        </form>
    </div>
</body>
</html>
