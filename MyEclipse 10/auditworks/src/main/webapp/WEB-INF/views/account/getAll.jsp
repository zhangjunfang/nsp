<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1"))
		response.setHeader("Cache-Control", "no-cache");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户查询</title>
</head>
<body>
	<table>
		<tr>
			<td align="center">用户ID</td>
			<td align="center">Email</td>
			<td align="center">用户名</td>
		</tr>
		<c:forEach var="result" items="${accounts}">
		<tr>
			<td><a href="<c:url value='/account/get.htm?userid=${result.userid}'/>">${result.userid}</a></td>
			<td>${result.email}</td>
			<td>${result.name}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/account/createForm.htm'/>">注册</a>
</body>
</html>