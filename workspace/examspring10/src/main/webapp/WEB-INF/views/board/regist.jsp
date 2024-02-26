<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
<form:form>
<fieldset>
<legend>게시글 등록</legend>
	<p>
		<form:input path="title" placeholder="제목"/>
		<form:errors path="title"/>
	</p>
	<p>
		<form:textarea path="content" placeholder="내용" cols="25" rows="5"/>
		<form:errors path="content"/>
	</p>
	<p><input type="submit" value="등록"></p>
</fieldset>
</form:form>
</body>
</html>