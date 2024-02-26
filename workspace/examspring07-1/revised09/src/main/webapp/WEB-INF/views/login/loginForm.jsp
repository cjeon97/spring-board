<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>
<form:form>
<form:errors/>
<p>
	<label>
		<spring:message code="memberid" />:
		<form:input path="memberid" />
		<form:errors path="memberid" />
	</label>
</p>
<p>
	<label>
		<spring:message code="memberpw" />:
		<form:password path="memberpw" />
		<form:errors path="memberpw"/>
	</label>
</p>
<p>
	<label>
		<spring:message code="rememberId" />
		<form:checkbox path="rememberId" />
	</label>
</p>
<input type="submit" value="<spring:message code="login.btn"/>">
</form:form>
</body>
</html>