<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
<h1>기본 게시판</h1>
<form action="#">
	<input type="text" name="keyword" placeholder="검색">
	<input type="submit" value="검색">
</form>
<p><a href="<c:url value='/board/regist'/>"><button>글등록</button></a></p>
<table border="1px">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.num}</td>
			<td><a href="<c:url value='/board/detail/${board.num}'/>">${board.title}</a></td>
			<td><javatime:format value="${board.regdate}" pattern="yyyy년 MM월 dd일 HH시mm분ss초"/></td>
			<td>${board.readcnt}</td>
		</tr>
	</c:forEach>
</table>

<!-- 여기는 페이징 적용해보기 -->
<div>
&lt;&lt; [1] [2] [3] &gt;&gt;
</div>
</body>
</html>