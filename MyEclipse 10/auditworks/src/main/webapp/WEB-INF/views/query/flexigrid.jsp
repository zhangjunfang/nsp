<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1"))
		response.setHeader("Cache-Control", "no-cache");
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>非现场审计系统</title>
<link rel="stylesheet" type="text/css" href="/auditworks/static/css/flexigrid.css">
<script type="text/javascript" src="/auditworks/static/js/jquery-latest.js"></script>
<script type="text/javascript" src="/auditworks/static/js/flexigrid.js"></script>
</head>
<body>
	<div>
		<table id="flex" style="display:none"></table>
	</div>
	<script type="text/javascript">
	var title = "贷款明细000001100c";
	var myFlex = { 
	    dataType           : 'json', 
	    url                : 'getTable.htm', 
   		usepager           : true,
   		title              : title,
   		useRp              : true,
   		rp                 : 30,
   		showTableToggleBtn : true,
   		width              : 'auto',
   		height             : 400
	};
	
	var colModel01 = Array();
	//colModel01 = [{"display":"流水号","name":"TRACE_NO","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"流水笔次","name":"TRACE_CNT","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"开户机构号","name":"OPN_BR_NO","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"交易机构号","name":"TX_BR_NO","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"账户ID","name":"AC_ID","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"账户序号","name":"AC_SEQN","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"交易代码","name":"TX_CODE","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"子交易代码","name":"SUB_TX_CODE","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"贷款交易类型","name":"LN_TX_TYPE","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"增减标志","name":"ADD_IND","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"现转标志","name":"CT_IND","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"交易金额","name":"TX_AMT","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"余额","name":"BAL","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"利息积数","name":"INTST_ACM","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"交易日期","name":"TX_DATE","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"交易时间","name":"TX_TIME","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"凭证种类","name":"NOTE_TYPE","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"凭证号","name":"NOTE_NO","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"明细笔数","name":"HST_CNT","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"摘要","name":"BRF","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"操作员","name":"TEL","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"复核员","name":"CHK","width":GetColumnSize(10),"sortable":true,"align":"left"},{"display":"授权人","name":"AUTH","width":GetColumnSize(10),"sortable":true,"align":"left"}];
	
	// 获取表头
	$.ajax({
		url:"getColumnModel.htm", 
		dataType:'json', 
		async:false, // 一定要使用同步，否则在firefox、chrome无法显示
		success: function(result){
			colModel01 = result;
		}
	});

	$("#flex").flexigrid($.extend({}, myFlex, {
		colModel : colModel01,
		preProcess : formatData
	}));
	
	function formatData(data) {
		var rows = Array();
		$.each(data.rows, function(i, row){
			var myCell = Array();
			for(var p in row) {
				myCell.push(row[p]);
			}
			//id can be mapped to any attribute of the return object in the list
			rows.push({cell : myCell});
		});
		   
		return {
			total:data.total,
			page:data.page,
			rows:rows
		};
	}
	
	function GetColumnSize(percent){
		screen_res = ($(document).width()-221)*0.85;
		col = parseInt((percent*(screen_res/100)));
		if (percent != 100){
		    return col-18;
		}else{
		    return col;
		}
	  } 
</script>
</body>
</html>
