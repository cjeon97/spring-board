<%@page import="calc.DivCalc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String n1 = request.getParameter("n1");
	String n2 = request.getParameter("n2");
	
	System.out.println("n1: " + n1);
	System.out.println("n2: " + n2);
	
	int result = new DivCalc().clac(Integer.parseInt(n1), Integer.parseInt(n2));
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나눗셈 결과</title>
</head>
<body>

	<%=n1 %> / <%=n2 %> = <%=result %>입니다.

</body>
</html>