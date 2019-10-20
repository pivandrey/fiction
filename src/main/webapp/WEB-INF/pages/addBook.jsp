<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.09.2019
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавление книги</title>
    <link href="<c:url value="/res/addAuthor.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
    <div>
        <h2>Добавление книги</h2>
        <c:url value="/book/add" var="var" />
        <form:form action="${var}" modelAttribute="book" method="POST">
            <form:label path="name" cssClass="label">Название</form:label>
            <form:input type="text" path="name" id="fullname" cssClass="input" />
            <form:errors path="name" />

            <form:label path="year" cssClass="label">Год</form:label>
            <form:input type="text" path="year" id="birthday" />
            <form:errors path="year" />

            <form:label path="authors" cssClass="label">Авторы</form:label>
            <form:select path="authors" multiple="true" id="authors">
                <c:forEach var="author" items="${authorsList}">
                    <form:option value="${author.id}">
                        <span>${author.fullname}</span>
                    </form:option>
                </c:forEach>
            </form:select>

            <form:label path="genres" cssClass="label">Жанры</form:label>
            <form:select path="genres" multiple="true" id="genres">
                <c:forEach var="genre" items="${genresList}">
                    <form:option value="${genre.id}">
                        <span>${genre.name}</span>
                    </form:option>
                </c:forEach>
            </form:select>

            <form:button type="submit">Сохранить</form:button>
        </form:form>
    </div>
</body>
</html>
