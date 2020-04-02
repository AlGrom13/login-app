<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <style>
        html, body{width:100%; height:100%; margin:0}
        #action_form{
            position:absolute;
            width:200px;
            height:150px;
            left:50%;
            top:50%;
            margin-left:-100px;
            margin-top:-100px;
            border:1px solid

        }
        form{padding:14px}
    </style>
</head>
<body>
<div id="action_form">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="login">Логин:</label>
        <input name="login" id="login" type="text"><br/>
        <label for="password">Пароль:</label>
        <input name="password" id="password" type="password">
        <p><input type="submit" value="Войти"></p>
        <p style="color: red">${requestScope.error}</p>
    </form>
</div>
</body>
</html>