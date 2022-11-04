<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
<link rel="stylesheet" type="text/css" href="/css/sign-up.css"/>
<link rel="stylesheet" type="text/css" href="/css/stuff.css"/>
</head>
<body class="flex-col">
	<div class="header full-width flex-row">
		<!-- The form should have model attribute, that is the name of the model you put on the page in the getMapping, case sensitive -->
		<!-- action leads you to the next mapping in the controller to go to, method if its a postmapping or whatever call type you are making, get, post, put, delete -->
		<form:form modelAttribute="user" action="sign-in" method="post">
				<div class="form-group col-md-6">
					<label for="inputName">Username</label>
					<!-- Make sure you have a form:input for your form:form, not regular input tags -->
					<!-- Your path should be the same name as the class variable its mapping to, CASE SENSITIVE -->
					<form:input path="username" type="text" class="form-control" id="intputMake" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputName">Password</label>
					<!-- Make sure you have a form:input for your form:form, not regular input tags -->
					<!-- Your path should be the same name as the class variable its mapping to, CASE SENSITIVE -->
					<form:input path="password" type="password" class="form-control" id="intputMake" />
				</div>
				<!-- You have a form:button to submit your form:form, regular button tag doesnt work -->
				<form:button type="submit" class="btn btn-primary">Submit</form:button>
			</form:form>
	</div>
</body>
</html>