<%--
  Created by IntelliJ IDEA.
  User: vplat
  Date: 10.10.2019
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login Form</h2>

    <form action='<spring:url value="/loginAction"/>' method="post">
        <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><button type="submit">Login</button></td>
            </tr>
        </table>
    </form>

    <table>
        <tr>
            <td>№</td>
            <td>name</td>
            <td>password</td>
            <td>roles</td>
        </tr>
        <tr>
            <td>1</td>
            <td>root</td>
            <td>root</td>
            <td>ROLE_VISITOR, ROLE_EDITOR, ROLE_CREATOR</td>
            <td>Can do all actions</td>
        </tr>
        <tr>
            <td>2</td>
            <td>creator</td>
            <td>creator</td>
            <td>ROLE_EDITOR, ROLE_CREATOR</td>
            <td>Can edit and create, but not can see entities</td>
        </tr>
        <tr>
            <td>3</td>
            <td>visitor</td>
            <td>visitor</td>
            <td>ROLE_VISITOR</td>
            <td>Only can see entities</td>
        </tr>
        <tr>
            <td>4</td>
            <td>guest</td>
            <td>guest</td>
            <td>ROLE_GUEST</td>
            <td>Only can login</td>
        </tr>
    </table>

    <br/>
</body>
</html>
