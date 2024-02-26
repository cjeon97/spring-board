<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보</title>
</head>
<body>

	<p>번호: ${member.no }</p>
	<p>아이디: ${member.memberid }</p>
	<p>닉네임: ${member.nick }</p>
	<p>가입일: <fmt:parseDate value="${member.regdate}" var="parsedRegdate"
				pattern="yyyy-MM-dd'T'HH:mm:ss" type="both"/></p>
			<fmt:formatDate value="${parsedRegdate}" pattern="yyyy년 MM월 dd일 HH시"/>
</body>
</html>