<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="${pageContext.request.contextPath}/register" method="post">
    <label for="login">Логин:</label>
    <input name="login" id="login" type="text"><br/>
    <label for="password">Пароль:</label>
    <input name="password" id="password" type="password">
    <p><input type="submit" value="Зарегистрироваться"></p>
    <p style="color: red">${requestScope.error}</p>
</form>