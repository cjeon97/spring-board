<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
</head>
<body>
<p><a href="<c:url value='/board/list'/>"><button>목록으로</button></a></p>
<fieldset>
<legend>${board.num}번 게시글</legend>
	<p>등록일시: <javatime:format value="${board.regdate}" pattern="yyyy년 MM월 dd일 HH시mm분ss초"/></p>
	<p>조회수: ${board.readcnt}</p>
	<p>제목: ${board.title}</p>
	<p>내용: ${board.content}</p>	
</fieldset>
<p>
	<a href="<c:url value='/board/edit/${board.num}'/>"><button>수정</button></a>
	<a href="<c:url value='/board/remove/${board.num}'/>"><button>삭제</button></a>
</p>
</body>
</html>