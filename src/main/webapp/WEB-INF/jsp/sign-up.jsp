<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="/css/sign-up.css"/>
<link rel="stylesheet" type="text/css" href="/css/stuff.css"/>
</head>
<body class="flex-col">
	<div class="header full-width flex-row">
		<form:form modelAttribute="user" action="sign-up" method="post">
				<div class="form-group col-md-6">
					<label for="inputName">Username</label>
					<form:input path="username" type="text" class="form-control" id="intputMake" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputName">Email</label>
					<form:input path="email" type="text" class="form-control" id="intputMake" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputName">Password</label>
					<form:input path="password" type="password" class="form-control" id="intputMake" />
				</div>
				<form:button type="submit" class="btn btn-primary">Submit</form:button>
			</form:form>
	</div>
</body>
</html>