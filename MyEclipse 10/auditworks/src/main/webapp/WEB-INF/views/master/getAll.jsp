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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/auditworks/static/css/themes/cupertino/jquery.ui.all.css">
<link rel="stylesheet" type="text/css" href="/auditworks/static/css/jqgrid/ui.jqgrid.css">
<script type="text/javascript" src="/auditworks/static/js/jquery-latest.js"></script>
<script type="text/javascript" src="/auditworks/static/js/jquery-ui-latest.js"></script>
<script type="text/javascript" src="/auditworks/static/js/grid.locale-en.js"></script>
<script type="text/javascript">
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;
</script>
<script type="text/javascript" src="/auditworks/static/js/jquery.jqGrid.src.js"></script>
</head>
<body>
	<table id="list2"></table>
	<div id="pager2"></div>
	<!-- http://www.trirand.com/blog/jqgrid/server.php?q=2 -->
	<script type="text/javascript">
	jQuery("#list2").jqGrid({
	   	url:'/auditworks/jqjson2',
		datatype: "json",
	   	colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
	   	colModel:[
	   		{name:'id',index:'id', width:55},
	   		{name:'invdate',index:'invdate', width:90},
	   		{name:'name',index:'name asc, invdate', width:100},
	   		{name:'amount',index:'amount', width:80, align:"right"},
	   		{name:'tax',index:'tax', width:80, align:"right"},		
	   		{name:'total',index:'total', width:80,align:"right"},		
	   		{name:'note',index:'note', width:150, sortable:false}		
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager2',
	   	sortname: 'id',
	    viewrecords: true,
	    sortorder: "desc",
	    caption:"JSON Example"
	});
	jQuery("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});

	</script>
</body>
</html>