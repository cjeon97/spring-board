<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body>
<p><a href="<c:url value='/board/list'/>"><button>목록으로</button></a></p>
<p><b>[${command.num}]번, ${command.title}</b></p>
<form method="post">
해당 게시글을 삭제하시겠습니까? 
<p><button type="submit">예</button>
<a href="<c:url value='/board/detail/${command.num}'/>"><button type="button">아니오</button></a>
</p>
</form>
</body>
</html>