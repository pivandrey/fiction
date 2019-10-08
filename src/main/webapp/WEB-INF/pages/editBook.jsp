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

                <label for="authors">Авторы</label>
                <select name="authorIds" multiple="multiple" id="authors">
                    <c:forEach items="${authorsList}" var="author">
                        <c:set var="isSelected" value="false" />
                        <c:forEach items="${book.authors}" var="authorSelect">
                            <c:if test="${authorSelect.id==author.id}">
                                <c:set var="isSelected" value="true" />
                            </c:if>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${isSelected}">
                                <option value="${author.id}" selected="selected">${author.fullname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${author.id}">${author.fullname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>

                <label for="genres">Жанры</label>
                <select name="genreIds" multiple="multiple" id="genres">
                    <c:forEach items="${genresList}" var="genre">
                        <c:set var="isSelected" value="false" />
                        <c:forEach items="${book.genres}" var="genreSelect">
                            <c:if test="${genreSelect.id==genre.id}">
                                <c:set var="isSelected" value="true" />
                            </c:if>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${isSelected}">
                                <option value="${genre.id}" selected="selected">${genre.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${genre.id}">${genre.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </c:if>
            <c:if test="${empty book.name}">
                <label for="name">Название</label>
                <input type="text" name="name" id="name">
                <label for="year">Год</label>
                <input type="text" name="year" id="year">

                <label for="authors">Авторы</label>
                <select name="authorIds" multiple id="authors">
                    <c:forEach var="author" items="${authorsList}">
                        <option value="${author.id}">
                            <span>${author.fullname}</span>
                        </option>
                    </c:forEach>
                </select>

                <label for="genres">Жанры</label>
                <select name="genreIds" multiple id="genres">
                    <c:forEach var="genre" items="${genresList}">
                        <option value="${genre.id}">
                            <span>${genre.name}</span>
                        </option>
                    </c:forEach>
                </select>
            </c:if>
            <input type="submit" value="Сохранить">
        </form>
    </div>
</body>
</html>
