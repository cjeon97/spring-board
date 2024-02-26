<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
<form:form>
<p>
	<label>form:<form:input path="from"/></label>
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
			<th>비밀번호</th>
			<th>닉네임</th>
			<th>가입일자</th>
		</tr>
		<c:forEach var="member" items="${members}">
			<tr>
				<td>${member.no}</td>
				<td><a href="<c:url value='/member/detail/${member.no}'/>">${member.memberid}</a></td>
				<td>${member.memberpw}</td>
				<td>${member.nick}</td>
				<%-- 
				<td>
					<fmt:parseDate value="${member.regdate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
					<fmt:formatDate value="${parsedDateTime}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/>
				</td> 
				--%>
				<td>
					<javatime:format value="${member.regdate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>








