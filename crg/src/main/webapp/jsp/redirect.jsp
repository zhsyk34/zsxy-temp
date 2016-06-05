<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <h3>用户列表</h3>
    <table>
        <thead>
        <tr>
            <td>index</td>
            <td>id</td>
            <td>name</td>
            <td>password</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="user" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
