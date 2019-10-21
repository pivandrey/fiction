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
    <link href="<c:url value="/res/entity.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="root">
        <a href="/">На главную</a>
        <h1>${author.fullname}</h1>
        <table>
            <tr>
                <th class="first"><span>Дата рождения</span></th>
                <td><span>${author.birthday}</span></td>
            </tr>
            <tr>
                <th class="first"><span>Биография</span></th>
                <td><span>${author.biography}</span></td>
            </tr>
            <tr>
                <th class="first"><span>Книги</span></th>
                <td>
                    <ul>
                        <c:forEach var="book" items="${author.books}">
                            <li>
                                <a href="/book/${book.id}">${book.name}</a>
                                <span>${book.year}</span>
                            </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </table>

        <div class="buttons">
            <a href="/author/edit/${author.id}">Редактировать</a>
            <a href="/author/delete/${author.id}">Удалить</a>
        </div>
    </div>
</body>
</html>
