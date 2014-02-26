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
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td align="center">用户ID</td>
			<td align="left"><strong>${account.userid}</strong></td>
		</tr>
		<tr>
			<td align="center">Email</td>
			<td align="left"><strong>${account.email}</strong></td>
		</tr>
		<tr>
			<td align="center">用户名</td>
			<td align="left"><strong>${account.name}</strong></td>
		</tr>
	</table>
	<br />
	<a href="<c:url value='/account/getAll.htm'/>">列表</a> &nbsp;&nbsp;
	<a href="<c:url value='/account/modifyForm.htm?userid=${account.userid}'/>">修改</a>  &nbsp;&nbsp;
	<a href="<c:url value='/account/remove.htm?userid=${account.userid}'/>">删除</a>
</body>
</html>