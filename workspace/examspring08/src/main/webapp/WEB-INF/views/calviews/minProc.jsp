<%@page import="calc.MinCalc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뺄셈 결과</title>
</head>
<body>

	<p>${n1 } - ${n2 } = ${result }입니다.</p>
	<a href="${pageContext.request.contextPath}/calculator">목록으로</a>

</body>
</html>