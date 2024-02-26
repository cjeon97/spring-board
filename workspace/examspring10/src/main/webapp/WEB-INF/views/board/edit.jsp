<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<p><a href="<c:url value='/board/list'/>"><button>목록으로</button></a></p>
<form:form>
<fieldset>
<legend>게시글 수정</legend>
<form:hidden path="num"/>
	<p>
		<form:input path="title" placeholder="제목"/>
		<form:errors path="title"/>
	</p>
	<p>
		<form:textarea path="content" placeholder="내용" cols="25" rows="5"/>
		<form:errors path="content"/>
	</p>
	<input type="submit" value="수정">
</fieldset>
</form:form>
</body>
</html>