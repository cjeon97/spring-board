<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<h2>회원 가입</h2>
	<form action="step3" method="post">
		<p><label>아이디:<input type="text" name="memberid" value="${cmd.memberid}"></label></p>
		<p><label>닉네임:<input type="text" name="nick" value="${cmd.nick}"></label></p>
		<p><label>비밀번호:<input type="password" name="memberpw"></label></p>
		<p><label>비밀번호 확인:<input type="password" name="memberpw2"></label></p>
		<input type="submit" value="가입하기">
	</form>

</body>
</html>