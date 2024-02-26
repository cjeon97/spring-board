<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<c:if test="${empty authInfo}">
	<h2>홈 화면</h2>
	<p>환영합니다.</p>
	<p>
		<a href="<c:url value='/register/step1'/>"><button>회원가입</button></a>
		<a href="<c:url value='/login'/>"><button>로그인</button></a>
	</p>
	</c:if>
	
	
	<c:if test="${!empty authInfo}">
	<p>${authInfo.nick}님 환영합니다.</p>
		<a href="<c:url value='/edit/changepwd'/>"><button>비밀번호 변경</button></a>
		<a href="<c:url value='/logout'/>"><button>로그아웃</button></a>
	</c:if>
</body>
</html>