<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
<p><a href="<c:url value='/board/list'/>"><button>List</button></a></p>
<p><b>[No.${command.num}], ${command.title}</b></p>
<form method="post">
Do you want to delete the post? 
<p><button type="submit">Yes</button>
<a href="<c:url value='/board/detail/${command.num}'/>"><button type="button">No</button></a>
</p>
</form>
</body>
</html>
