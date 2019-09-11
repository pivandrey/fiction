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
    <title>Book</title>
</head>
<body>
    <div>
        <a href="/">На главную</a>
        <h2>${book.name}</h2>
        <div>
            <span>Год</span>
            <span>${book.year}</span>
        </div>
        <div>
            <span>Авторы</span>
            <ul>
<%--                <c:forEach var="author" items="${book.authors}">--%>
<%--                    <li>--%>
<%--                        <a href="/author/${author.id}">${author.fullname}</a>--%>
<%--                    </li>--%>
<%--                </c:forEach>--%>
            </ul>
        </div>
        <div>
            <span>Жанры</span>
            <span>${book.authors}</span>
            <ul>
<%--                <c:forEach var="genre" items="${book.genres}">--%>
<%--                    <li>--%>
<%--                        <a href="/genre/${genre.id}">${genre.name}</a>--%>
<%--                    </li>--%>
<%--                </c:forEach>--%>
            </ul>
        </div>
        <a href="/book/edit/${book.id}">Редактировать</a>
    </div>
</body>
</html>
