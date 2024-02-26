di<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Post</title>
</head>
<body>
<p><a href="<c:url value='/board/list'/>"><button>Lists</button></a></p>
<form:form>
<fieldset>
<legend>Edit Post</legend>
<form:hidden path="num"/>
	<p>
		<form:input path="title" placeholder="Title"/>
		<form:errors path="title"/>
	</p>
	<p>
		<form:textarea path="content" placeholder="Content" cols="25" rows="5"/>
		<form:errors path="content"/>
	</p>
	<input type="submit" value="Done">
</fieldset>
</form:form>
</body>
</html>
