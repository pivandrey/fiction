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
        <h2>Добавление автора</h2>
        <c:url value="/author/add" var="var" />
        <form:form action="${var}" modelAttribute="author" method="POST">
            <form:label path="fullname">Полное имя</form:label>
            <form:input type="text" path="fullname" id="fullname" />
            <form:errors path="fullname" />

            <form:label path="birthday">Год рождения</form:label>
            <form:input type="text" path="birthday" id="birthday" />
            <form:errors path="birthday" />

            <form:label path="biography">Биография</form:label>
            <form:input type="text" path="biography" id="biography" />
            <form:errors path="biography" />

            <form:label path="book">Книги</form:label>
            <form:select path="book" multiple="true" id="book">
                <c:forEach var="book" items="${booksList}">
                    <form:option value="${book.id}">
                        <span>${book.name}</span>
                    </form:option>
                </c:forEach>
            </form:select>

            <form:button type="submit" value="Сохранить" />
        </form:form>
    </div>
</body>
</html>