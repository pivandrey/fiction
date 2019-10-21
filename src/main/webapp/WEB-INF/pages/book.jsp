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
    <link href="<c:url value="/res/entity.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="root">
        <a href="/">На главную</a>
        <h1>${book.name}</h1>
        <table>
            <tr>
                <th class="first"><span>Год</span></th>
                <td><span>${book.year}</span></td>
            </tr>
            <tr>
                <th class="first"><span>Авторы</span></th>
                <td>
                    <ul>
                        <c:forEach var="author" items="${book.authors}">
                            <li>
                                <a href="/author/${author.id}">${author.fullname}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
                <th class="first"><span>Жанры</span></th>
                <td>
                    <ul>
                        <c:forEach var="genre" items="${book.genres}">
                            <li>
                                <a href="/genre/${genre.id}">${genre.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </table>

        <div class="buttons">
            <a href="/book/edit/${book.id}">Редактировать</a>
            <a href="/book/delete/${book.id}">Удалить</a>
        </div>
    </div>
</body>
</html>
