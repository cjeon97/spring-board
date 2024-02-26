<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>

	<h2><spring:message code="member.register"/></h2>
	<form:form action="step3">
		<p>
			<label>
				<spring:message code="memberid"/>:
				<form:input path="memberid"/>
				<form:errors path="memberid"/>
			</label>
		</p>
		<p>
			<label>
				<spring:message code="nick"/>:
				<form:input path="nick"/>
				<form:errors path="nick"/>
			</label>
		</p>
		<p>
			<label>
				<spring:message code="memberpw"/>:
				<form:password path="memberpw"/>
				<form:errors path="memberpw"/>
			</label>
		</p>
		<p>
			<label>
				<spring:message code="memberpw2"/>:
				<form:password path="memberpw2"/>
				<form:errors path="memberpw2"/>
			</label>
		</p>
		<input type="submit" value="<spring:message code="register.btn"/>">
	</form:form>


</body>
</html>