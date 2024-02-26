<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>

	<form:form>
		<p>
			<label>from:<form:input path="from"/></label>
			~
			<label>to:<form:input path="to"/></label>
			<input type="submit" value="조회"/>
		</p>
	</form:form>
	
	<hr>
	<c:if test="${!empty members}">
		<table>
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>닉네임</th>
				<th>가입일자</th>
			</tr>
			<c:forEach var="member" items="${members}">
				<tr>
					<td>${member.no }</td>
					<td><a href="<c:url value='/member/detail/${member.no}'/>">${member.memberid }</a></td>
					<td>${member.nick }</td>
					<td><javatime:format value="${member.regdate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" style="MS" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>