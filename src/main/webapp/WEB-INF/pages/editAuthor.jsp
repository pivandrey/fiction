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
    <title>Редактирование автора</title>
    <link href="<c:url value="/res/addAuthor.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
    <div>
        <h2>${author.fullname}</h2>
        <c:url value="/author/edit" var="var" />
        <form:form modelAttribute="author" action="${var}" method="POST">
            <form:input type="hidden" path="id" value="${author.id}" />

            <form:label path="fullname" cssClass="label">Полное имя</form:label>
            <form:input type="text" path="fullname" id="fullname" value="${author.fullname}" cssClass="input" />
            <form:errors path="fullname" />

            <form:label path="birthday" cssClass="label">Год рождения</form:label>
            <form:input type="text" path="birthday" id="birthday" value="${author.birthday}" cssClass="input" />
            <form:errors path="birthday" />

            <form:label path="biography" cssClass="label">Биография</form:label>
            <form:input type="text" path="biography" id="biography" value="${author.biography}" cssClass="input" />
            <form:errors path="biography" />

            <form:label path="books" cssClass="label">Книги</form:label>
            <form:select path="books" multiple="true" id="books">
                <c:forEach items="${booksList}" var="book">
                    <c:set var="isSelected" value="false" />
                    <c:forEach items="${author.books}" var="bookSelect">
                        <c:if test="${bookSelect.id==book.id}">
                            <c:set var="isSelected" value="true" />
                        </c:if>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${isSelected}">
                            <form:option value="${book.id}" selected="selected">${book.name}</form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${book.id}">${book.name}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>

            <form:button type="submit">Сохранить</form:button>
        </form:form>
    </div>
</body>
</html>
