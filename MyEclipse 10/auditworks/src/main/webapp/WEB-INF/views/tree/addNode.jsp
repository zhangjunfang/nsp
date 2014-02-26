<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>添加节点</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/static/js/jquery.funkyUI.js"></script>
<script type="text/javascript">
	function closeWindow() {
		$.unfunkyUI();
	}
</script>
</head>

<body>
	<c:if test="${addSucess==null}">

		<form:form method="POST" commandName="tree" action="tree/addNode.htm">

			<table>
				<tr>
					<td>id :</td>
					<td><form:input path="id" /></td>
					<td><form:errors path="id" cssClass="error" /></td>
				</tr>
				<tr>
					<td>pid :</td>
					<td><input type="text" value="${param.id}" readonly="readonly"
						name="pId"></td>
					<td><form:errors path="pId" cssClass="error" /></td>
				</tr>
				<tr>
					<td>name :</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>t :</td>
					<td><form:input path="t" /></td>
					<td><form:errors path="t" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<input type="submit" value="提交"> <input type="reset"
								value="重置"> 
						</div></td>
					<td> <input type="button" onclick="closeWindow();"
								value="关闭"></td>
				</tr>
			</table>
		</form:form>
	</c:if>
	<c:if test="${addSucess!=null}">

		<div align="center">
			友情提示：<br>
			<h1 style="color: red">${addSucess}</h1>

			<a href="javascript:closeWindow();">关闭页面</a>
		</div>




	</c:if>


</body>

</html>
