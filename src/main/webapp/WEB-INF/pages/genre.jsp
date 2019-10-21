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
    <title>Genre</title>
</head>
<body>
    <div>
        <a href="/">На главную</a>
        <h2>${genre.name}</h2>
    </div>
    <a href="/genre/edit/${genre.id}">Редактировать</a>
    <a href="/genre/delete/${genre.id}">Удалить</a>
</body>
</html>
