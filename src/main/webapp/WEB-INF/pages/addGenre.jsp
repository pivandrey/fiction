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
    <title>Добавление жанра</title>
    <link href="<c:url value="/res/edit.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
    <div>
        <h2>Добавление жанра</h2>
        <c:url value="/genre/add" var="var" />
        <form:form action="${var}" modelAttribute="genre" method="POST">
            <form:label path="name" cssClass="label">Название</form:label>
            <form:input type="text" path="name" id="name" cssClass="input" />
            <form:errors path="name" />

            <form:button type="submit">Сохранить</form:button>
        </form:form>
    </div>
</body>
</html>
