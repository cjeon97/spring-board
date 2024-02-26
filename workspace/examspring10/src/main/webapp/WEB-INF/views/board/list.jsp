<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
<h1>Board</h1>
<form action="#">
	<input type="text" name="keyword" placeholder="Keyword">
	<input type="submit" value="Search">
</form>
<p><a href="<c:url value='/board/regist'/>"><button>Post</button></a></p>
<table border="1px">
	<tr>
		<th>No.</th>
		<th>Title</th>
		<th>Registration</th>
		<th>View Count</th>
	</tr>
	<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.num}</td>
			<td><a href="<c:url value='/board/detail/${board.num}'/>">${board.title}</a></td>
			<td><javatime:format value="${board.regdate}" pattern="yyyy/ MM/ dd/ HH:mm:ss"/></td>
			<td>${board.readcnt}</td>
		</tr>
	</c:forEach>
</table>

<div>
&lt;&lt; [1] [2] [3] &gt;&gt;
</div>
</body>
</html>
