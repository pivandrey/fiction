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
    <title>Author</title>
</head>
<body>
    <div>
        <a href="/">На главную</a>
        <h2>${author.fullname}</h2>
        <div>
            <span>Дата рождения</span>
            <span>${author.birthday}</span>
        </div>
        <div>
            <span>Биография</span>
            <span>${author.biography}</span>
        </div>
        <div>
            <span>Книги</span>
            <ul>
                <c:forEach var="book" items="${author.books}">
                    <li>
                        <a href="/book/${book.id}">${book.name}</a>
                        <span>${book.year}</span>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <a href="/author/edit/${author.id}">Редактировать</a>
        <a href="/author/delete/${author.id}">Удалить</a>
    </div>
</body>
</html>
