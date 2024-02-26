<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="change.pwd.title"/></title>
</head>
<body>
<form:form>
<form:errors/>
<p>
	<label>
		<spring:message code="curpwd" />:
		<form:password path="curpwd" />
		<form:errors path="curpwd" />
	</label>
</p>
<p>
	<label>
		<spring:message code="newpwd" />:
		<form:password path="newpwd" />
		<form:errors path="newpwd"/>
	</label>
</p>
<input type="submit" value="<spring:message code="change.btn"/>">
</form:form>
</body>
</html>