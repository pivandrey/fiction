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
    <c:if test="${empty author.fullname}">
        <title>Add Author</title>
    </c:if>
    <c:if test="${!empty author.fullname}">
        <title>Edit Author</title>
    </c:if>
</head>
<body>
<div>
    <c:if test="${!empty author.fullname}">
        <h2>${author.fullname}</h2>
        <c:url value="/author/edit" var="var"/>
    </c:if>
    <c:if test="${empty author.fullname}">
        <h2>Добавление автора</h2>
        <c:url value="/author/add" var="var"/>
    </c:if>
    <form:form action="${var}" method="POST">
        <c:if test="${!empty author.fullname}">
            <form:input type="hidden" path="id" value="${author.id}" />

            <form:label path="fullname">Полное имя</form:label>
            <form:input type="text" path="fullname" id="fullname" value="${author.fullname}" />
            <form:label path="birthday">Год рождения</form:label>
            <form:input type="text" path="birthday" id="birthday" value="${author.birthday}" />
            <form:label path="biography">Биография</form:label>
            <form:input type="text" path="biography" id="biography" value="${author.biography}" />
            <form:label path="books">Книги</form:label>
            <form:select path="bookIds" multiple="multiple" id="books">
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

            <form:button type="submit" value="Сохранить" />
        </c:if>
        <c:if test="${empty author.fullname}">
            <form:label path="fullname">Полное имя</form:label>
            <form:input type="text" path="fullname" id="fullname" />
            <form:label path="birthday">Год рождения</form:label>
            <form:input type="text" path="birthday" id="birthday" />
            <form:label path="biography">Биография</form:label>
            <form:input type="text" path="biography" id="biography" />
            <form:label path="books">Книги</form:label>
            <form:select path="bookIds" multiple="true" id="books">
                <c:forEach var="book" items="${booksList}">
                    <form:option value="${book.id}">
                        <span>${book.name}</span>
                    </form:option>
                </c:forEach>
            </form:select>
            <form:button type="submit" value="Сохранить" />
        </c:if>
    </form:form>
</div>
</body>
</html>
