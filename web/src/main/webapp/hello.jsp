<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Hello, ${sessionScope.authUser.login}</h1>
<a href="${pageContext.request.contextPath}/logout">logout</a>
