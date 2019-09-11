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
        <form action="${var}" method="POST">
            <c:if test="${!empty author.fullname}">
                <input type="hidden" name="id" value="${author.id}">

                <label for="fullname">Полное имя</label>
                <input type="text" name="fullname" id="fullname" value="${author.fullname}">
                <label for="birthday">Год рождения</label>
                <input type="text" name="birthday" id="birthday" value="${author.birthday}">
                <label for="biography">Биография</label>
                <input type="text" name="biography" id="biography" value="${author.biography}">

                <input type="submit" value="Сохранить">
            </c:if>
            <c:if test="${empty author.fullname}">
                <label for="fullname">Полное имя</label>
                <input type="text" name="fullname" id="fullname">
                <label for="birthday">Год рождения</label>
                <input type="text" name="birthday" id="birthday">
                <label for="biography">Биография</label>
                <input type="text" name="biography" id="biography">

                <input type="submit" value="Сохранить">
            </c:if>
        </form>
    </div>
</body>
</html>
