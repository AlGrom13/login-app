<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Users</h3>
<c:if test="${users != null}">
    <table>
        <tr>
            <th>Login</th>
            <th>Password</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${authUser.role == 'ADMIN'}">
    <h3>Add user</h3>
    <form action="${pageContext.request.contextPath}/workspace" method="post">
        <label for="firstName">Login</label>
        <input id="firstName" type="text" name="login"><br/>

        <label for="lastName">Password</label>
        <input id="lastName" type="text" name="password"><br/>

        <label for="email">Role</label>
        <input id="email" type="text" name="role"><br/>

        <input type="submit" value="Create user">
    </form>
</c:if>

<a href="${pageContext.request.contextPath}/logout">logout</a>
