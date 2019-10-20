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
    <title>Редактирование книги</title>
    <link href="<c:url value="/res/addAuthor.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
    <div>
        <h2>${book.name}</h2>
        <c:url value="/book/edit" var="var" />
        <form:form modelAttribute="book" action="${var}" method="POST">
            <form:input type="hidden" path="id" value="${book.id}" />

            <form:label path="name" cssClass="label">Название</form:label>
            <form:input type="text" path="name" id="fullname" value="${author.fullname}" cssClass="input" />
            <form:errors path="name" />

            <form:label path="year" cssClass="label">Год</form:label>
            <form:input type="text" path="year" id="birthday" value="${author.birthday}" cssClass="input" />
            <form:errors path="year" />

            <form:label path="authors" cssClass="label">Авторы</form:label>
            <form:select path="authors" multiple="true" id="authors">
                <c:forEach items="${authorsList}" var="author">
                    <c:set var="isSelected" value="false" />
                    <c:forEach items="${book.authors}" var="authorSelect">
                        <c:if test="${authorSelect.id==author.id}">
                            <c:set var="isSelected" value="true" />
                        </c:if>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${isSelected}">
                            <form:option value="${author.id}" selected="selected">${author.fullname}</form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${author.id}">${author.fullname}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>

            <form:label path="genres" cssClass="label">Жанры</form:label>
            <form:select path="genres" multiple="true" id="genres">
                <c:forEach items="${genresList}" var="genre">
                    <c:set var="isSelected" value="false" />
                    <c:forEach items="${book.genres}" var="genreSelect">
                        <c:if test="${genreSelect.id==genre.id}">
                            <c:set var="isSelected" value="true" />
                        </c:if>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${isSelected}">
                            <form:option value="${genre.id}" selected="selected">${genre.name}</form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${genre.id}">${genre.name}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>

            <form:button type="submit">Сохранить</form:button>
        </form:form>
    </div>
</body>
</html>
