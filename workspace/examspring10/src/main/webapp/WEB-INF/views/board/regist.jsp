<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post</title>
</head>
<body>
<form:form>
<fieldset>
<legend>Post</legend>
	<p>
		<form:input path="title" placeholder="Title"/>
		<form:errors path="title"/>
	</p>
	<p>
		<form:textarea path="content" placeholder="Content" cols="25" rows="5"/>
		<form:errors path="content"/>
	</p>
	<p><input type="submit" value="post"></p>
</fieldset>
</form:form>
</body>
</html>
