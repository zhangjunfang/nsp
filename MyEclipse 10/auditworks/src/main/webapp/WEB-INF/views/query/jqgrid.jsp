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
<title>非现场审计系统</title>
<link rel="stylesheet" type="text/css"
	href="/auditworks/static/css/themes/cupertino/jquery.ui.all.css">
	<link rel="stylesheet" type="text/css" href="/auditworks/static/css/themes/cupertino/jquery.ui.all.css">
<link rel="stylesheet" type="text/css" href="/auditworks/static/css/jqgrid/ui.jqgrid.css">

<script type="text/javascript"	src="/auditworks/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/auditworks/static/js/jquery-ui-latest.js"></script>
<script type="text/javascript" src="/auditworks/static/js/grid.locale-en.js"></script>
<script type="text/javascript" src="/auditworks/static/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	jQuery("#list").jqGrid({
		jsonReader: {
			repeatitems: false
		},
	   	url:'getRows.htm',
		datatype: "json",
	   	colNames:['开户机构号','利息积数', '余额', '交易机构号','授权人','增减标志','交易代码'],
	   	colModel:[
	   		{name:'开户机构号', index:'开户机构号', width:55},
	   		{name:'利息积数', index:'利息积数', width:90},
	   		{name:'余额', index:'余额', width:100},
	   		{name:'交易机构号',index:'交易机构号', width:80, align:"right"},
	   		{name:'授权人', index:'授权人', width:80, align:"right"},		
	   		{name:'增减标志', index:'增减标志', width:80, align:"right"},		
	   		{name:'交易代码', index:'交易代码', width:150, sortable:false}
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager',
	   	sortname: '开户机构号',
	    viewrecords: true,
	    sortorder: "desc",
	    caption:"JSON Example"
	});
	jQuery("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false});
});
</script>
</head>
<body>
	<div>
		<table id='list'></table>
		<div id='pager'></div>
	</div>
</body>
</html>
