<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>Our Space</title>

</head>


<body class="text-center">
	<c:choose>
		<c:when test="${user != null}">
		    <h1>Hi ${user.getUsername()}</h1>
		</c:when>
		<c:otherwise>
		    <h1>Hi mom</h1>
		</c:otherwise>
	</c:choose>
	<a href="/sign-up">to sign up</a>
	<a href="/sign-in">to sign in</a>
	<c:if test="${user != null }">
		<a href="/profile/${user.getId()}">to profile</a>
	</c:if>
</body>

</html>
