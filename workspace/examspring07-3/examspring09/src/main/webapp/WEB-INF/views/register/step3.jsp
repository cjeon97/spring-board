<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
</head>
<body>

	<!-- 복수의 arguments 패스를 위해서는 
	arguments="${command.nick}, ${command.memberid}"로 표현한다 -->
	<p><spring:message code="register.done" arguments="${command.nick}"/></p>
	<p>
		<a href="<c:url value='/main'/>">
		<button><spring:message code="go.home"/></button>
		</a>
	</p>

</body>
</html>