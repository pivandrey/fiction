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
    <c:if test="${empty genre.name}">
        <title>Add Genre</title>
    </c:if>
    <c:if test="${!empty genre.name}">
        <title>Edit Genre</title>
    </c:if>
</head>
<body>
    <div>
        <c:if test="${!empty genre.name}">
            <h2>${genre.name}</h2>
            <c:url value="/genre/edit" var="var"/>
        </c:if>
        <c:if test="${empty genre.name}">
            <h2>Добавление жанра</h2>
            <c:url value="/genre/add" var="var"/>
        </c:if>
        <form action="${var}" method="POST">
            <c:if test="${!empty genre.name}">
                <input type="hidden" name="id" value="${genre.id}">
                <label for="name">Название</label>
                <input type="text" name="name" id="name" value="${genre.name}">
            </c:if>
            <c:if test="${empty genre.name}">
                <label for="name">Название</label>
                <input type="text" name="name" id="name">
            </c:if>
            <input type="submit" value="Сохранить">
        </form>
    </div>
</body>
</html>
