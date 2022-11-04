<!-- These top 3 lines are for importing -->
<!-- This form import is so you can use form:form tags so you can accept info to the model and push it to the controller -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- These last two tags are for enabling java in your JSP, your model objects are java code, so you need them to display their values -->
<!-- c:if, c:choose, c:when, c:forEach tags can also be used to do java logic for things like tables -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>Our Space</title>

</head>


<body class="text-center">
	<c:choose>
	<!-- testing when the user is on the model, display their name -->
		<c:when test="${user != null}">
		<!-- The ${} is JSTL, this lets you do java in the html -->
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
