<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content</title>
</head>
<body>
<p><a href="<c:url value='/board/list'/>"><button>Lists</button></a></p>
<fieldset>
<legend>No.${board.num} posts</legend>
	<p>Registerd: <javatime:format value="${board.regdate}" pattern="yyyy/ MM/ dd/ HH:mm:ss"/></p>
	<p>View Count: ${board.readcnt}</p>
	<p>Title: ${board.title}</p>
	<p>Content: ${board.content}</p>	
</fieldset>
<p>
	<a href="<c:url value='/board/edit/${board.num}'/>"><button>Edit</button></a>
	<a href="<c:url value='/board/remove/${board.num}'/>"><button>Delete</button></a>
</p>
</body>
</html>
