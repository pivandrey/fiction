<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.09.2019
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Library</title>
    <link href="<c:url value="/res/library.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
    <h1>This is a library: you're see authors, books, genres.</h1>
    <div class="block">
        <h2>Авторы</h2>

        <c:url value="/author/add" var="addAuthor" />
        <a href="${addAuthor}">Добавить автора</a>

        <table>
            <tr>
                <th class="mainRow">Автор</th>
                <th class="mainRow">Год рождения</th>
                <th class="mainRow">Биография</th>
            </tr>
            <c:forEach var="author" items="${authorsList}">
                <tr>
                    <td><a href="/author/${author.id}">${author.fullname}</a></td>
                    <td>${author.birthday}</td>
                    <td>${author.biography}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="block">
        <h2>Книги</h2>

        <c:url value="/book/add" var="addBook" />
        <a href="${addBook}">Добавить книгу</a>

        <table>
            <tr>
                <th class="mainRow">Название</th>
                <th class="mainRow">Год</th>
            </tr>
            <c:forEach var="book" items="${booksList}">
                <tr>
                    <td><a href="/book/${book.id}">${book.name}</a></td>
                    <td>${book.year}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="block">
        <h2>Жанры</h2>

        <c:url value="/genre/add" var="addGenre" />
        <a href="${addGenre}">Добавить жанр</a>

        <table>
            <tr>
                <th class="mainRow">Название</th>
            </tr>
            <c:forEach var="genre" items="${genresList}">
                <tr>
                    <td><a href="/genre/${genre.id}">${genre.name}</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
