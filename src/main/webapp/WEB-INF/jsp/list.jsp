<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<c:forEach items="${userList}" var="user">
		<h1>Hi ${user.getUsername()}</h1>
		<h1>Hi ${user.getEmail()}</h1>
	</c:forEach>
</div>

</body>
</html>