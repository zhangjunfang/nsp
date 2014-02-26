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
<title>修改账户</title>
</head>
<body>
	<form id="createForm" method="post"
		action="<c:url value='/account/modify.htm'/>">
		<input type="hidden" name="userid" value="${account.userid}" />
		<table>
			<tr>
				<td align="center">用户ID <font color="red">*</font>
				</td>
				<td align="left">${account.userid}
				</td>
			</tr>
			<tr>
				<td align="center">Email <font color="red">*</font>
				</td>
				<td align="left"><input type="text" style="width: 200px;"
					name="email" value="${account.email}" />
				</td>
			</tr>
			<tr>
				<td align="center">用户名<font color="red">*</font>
				</td>
				<td align="left"><input type="text" style="width: 200px;"
					name="name" value="${account.name}" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="修改" />
	</form>
	<br />
</body>
</html>