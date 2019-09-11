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
</head>
<body>
    This is a library: you're see authors, books, genres.
    <h2>Authors</h2>
    <table>
        <tr>
            <th>fullname</th>
            <th>birthday</th>
            <th>biography</th>
        </tr>
        <c:forEach var="author" items="${authorsList}">
            <tr>
                <td><a href="/author/${author.id}">${author.fullname}</a></td>
                <td>${author.birthday}</td>
                <td>${author.biography}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Add author</h2>
    <c:url value="/author/add" var="addAuthor" />
    <a href="${addAuthor}">Add new author</a>

    <h2>Books</h2>
    <table>
        <tr>
            <th>name</th>
            <th>year</th>
        </tr>
        <c:forEach var="book" items="${booksList}">
            <tr>
                <td><a href="/book/${book.id}">${book.name}</a></td>
                <td>${book.year}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Add book</h2>
    <c:url value="/book/add" var="addBook" />
    <a href="${addBook}">Add new book</a>

    <h2>Genres</h2>
    <table>
        <tr>
            <th>name</th>
        </tr>
        <c:forEach var="genre" items="${genresList}">
            <tr>
                <td><a href="/genre/${genre.id}">${genre.name}</a></td>
            </tr>
        </c:forEach>
    </table>

    <h2>Add Genre</h2>
    <c:url value="/genre/add" var="addGenre" />
    <a href="${addBook}">Add new genre</a>

</body>
</html>
