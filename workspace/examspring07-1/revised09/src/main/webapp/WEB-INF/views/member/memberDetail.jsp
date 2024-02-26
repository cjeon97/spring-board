<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
<p>번호: ${member.no}</p>
<p>아이디: ${member.memberid}</p>
<p>닉네임: ${member.nick}</p>
<p>가입일시: <javatime:format value="${member.regdate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/></p>
</body>
</html>