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
<link rel="stylesheet" type="text/css" href="/auditworks/static/css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css" href="/auditworks/static/css/zTreeStyle/demo.css" >
<style type="text/css">
	.ztree li button.add {
		margin-left:2px; 
		margin-right: -1px; 
		background-position:-144px 0; 
		vertical-align:top; 
		*vertical-align:middle
	}
</style>	

<script type="text/javascript"	src="/auditworks/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript"	src="/auditworks/static/js/jquery.ztree.core-3.1.js"></script>
<script type="text/javascript" src="/auditworks/static/js/jquery.ztree.excheck-3.1.js"></script>
<script type="text/javascript" src="/auditworks/static/js/jquery.ztree.exedit-3.1.js"></script>


	<SCRIPT type="text/javascript">
		<!--
		var setting = {
			view: {
				selectedMulti: false
			},
			async: {
				enable: true,
				url:"../asyncData/node.jsp",
				autoParam:["id", "name=n", "level=lv"],
				otherParam:{"otherParam":"zTreeAsyncTest"},
				dataFilter: filter
			},
			callback: {
				beforeClick: beforeClick,
				beforeAsync: beforeAsync,
				onAsyncError: onAsyncError,
				onAsyncSuccess: onAsyncSuccess
			}
		};
 
		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		function beforeClick(treeId, treeNode) {
			if (!treeNode.isParent) {
				alert("请选择父节点");
				return false;
			} else {
				return true;
			}
		}
		var log, className = "dark";
		function beforeAsync(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeAsync ]&nbsp;&nbsp;&nbsp;&nbsp;" + ((!!treeNode && !!treeNode.name) ? treeNode.name : "root") );
			return true;
		}
		function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
			showLog("[ "+getTime()+" onAsyncError ]&nbsp;&nbsp;&nbsp;&nbsp;" + ((!!treeNode && !!treeNode.name) ? treeNode.name : "root") );
		}
		function onAsyncSuccess(event, treeId, treeNode, msg) {
			showLog("[ "+getTime()+" onAsyncSuccess ]&nbsp;&nbsp;&nbsp;&nbsp;" + ((!!treeNode && !!treeNode.name) ? treeNode.name : "root") );
		}
		
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}
 
		function refreshNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			type = e.data.type,
			silent = e.data.silent,
			nodes = zTree.getSelectedNodes();
			if (nodes.length == 0) {
				alert("请先选择一个父节点");
			}
			for (var i=0, l=nodes.length; i<l; i++) {
				zTree.reAsyncChildNodes(nodes[i], type, silent);
				if (!silent) zTree.selectNode(nodes[i]);
			}
		}
 
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting);
			$("#refreshNode").bind("click", {type:"refresh", silent:false}, refreshNode);
			$("#refreshNodeSilent").bind("click", {type:"refresh", silent:true}, refreshNode);
			$("#addNode").bind("click", {type:"add", silent:false}, refreshNode);
			$("#addNodeSilent").bind("click", {type:"add", silent:true}, refreshNode);
		});
		//-->
	</SCRIPT>		
	
	<SCRIPT type="text/javascript">
	
	var setting = {	
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false,
				fontCss: getFontCss
			},
			edit: {
				enable: true,
				editNameSelectAll: true
			},
			data: {
				key: {
					title: "t"
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove,
				onRename: onRename
			}
		};
 
		var zNodes =[
			{ id:1, pId:0, name:"父节点 1",t:"id=1", open:true},
			{ id:11, pId:1, name:"叶子节点 1-1",t:"id=11"},
			{ id:12, pId:1, name:"叶子节点 1-2",t:"id=12"},
			{ id:13, pId:1, name:"叶子节点 1-3",t:"id=13"},
			{ id:2, pId:0, name:"父节点 2",t:"id=1", open:true},
			{ id:21, pId:2, name:"叶子节点 2-1",t:"id=21"},
			{ id:22, pId:2, name:"叶子节点 2-2",t:"id=22"},
			{ id:23, pId:2, name:"叶子节点 2-3",t:"id=23"},
			{ id:3, pId:0, name:"父节点 3",t:"id=3", open:true},
			{ id:31, pId:3, name:"叶子节点 3-1",t:"id=31"},
			{ id:32, pId:3, name:"叶子节点 3-2",t:"id=32"},
			{ id:33, pId:3, name:"叶子节点 3-3",t:"id=33"}
		];
		//[{ "id":"01", "name":"tree01", "icon":"", isParent:false},
		//{ "id":"02", "name":"tree02", "icon":"", isParent:true},
		//{ "id":"03", "name":"tree03", "icon":"", isParent:false},
		//{ "id":"04", "name":"tree04", "icon":"", isParent:true}]
	
 
		function focusKey(e) {
			if (key.hasClass("empty")) {
				key.removeClass("empty");
			}
		}
		function blurKey(e) {
			if (key.get(0).value === "") {
				key.addClass("empty");
			}
		}
		var lastValue = "", nodeList = [], fontCss = {};
		function clickRadio(e) {
			lastValue = "";
			searchNode(e);
		}
		function searchNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var value = $.trim(key.get(0).value);
			var keyType = "";
			if ($("#name").attr("checked")) {
				keyType = "name";
			} else if ($("#id").attr("checked")) {
				keyType = "id";
				value = parseInt(value);
			}
			if (key.hasClass("empty")) {
				value = "";
			}
			if (lastValue === value) return;
 
			updateNodes(false);
			lastValue = value;
			if (value === "") return;
 
			//var result = "";			
			if ($("#getNodesByParamFuzzy").attr("checked")) {
				nodeList = zTree.getNodesByParamFuzzy(keyType, value);
			}
			updateNodes(true);
 
		}
		function updateNodes(highlight) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			for( var i=0, l=nodeList.length; i<l; i++) {
				nodeList[i].highlight = highlight;
				zTree.updateNode(nodeList[i]);
			}
		}
		function getFontCss(treeId, treeNode) {
			return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
		}	
		
		var log, className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function beforeEditName(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？");
		}
		function beforeRemove(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}
		function onRemove(e, treeId, treeNode) {
			showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
		}
		function beforeRename(treeId, treeNode, newName) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				setTimeout(function(){zTree.editName(treeNode);}, 10);
				return false;
			}
			return true;
		}
		function onRename(e, treeId, treeNode) {
			showLog("[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
		}
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}
 
		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<button type='button' class='add' id='addBtn_" + treeNode.id
				+ "' title='add node' onfocus='this.blur();'></button>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.id).unbind().remove();
		};
		function selectAll() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
		}
		var key;
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			$("#selectAll").bind("click", selectAll);
			key = $("#key");
			key.bind("focus", focusKey)
			.bind("blur", blurKey)
			.bind("propertychange", searchNode)
			.bind("input", searchNode);
			$("#name").bind("change", clickRadio);			
			$("#id").bind("change", clickRadio);		
			$("#getNodesByParamFuzzy").bind("change", clickRadio);
		});
		//-->
	</SCRIPT>

	

</head>
<body>
	<div class=" left">
		<div style="text-aglin:left;">
			<table style="width:300">
				<tr>
					<td style="width:80;text-aglin:right">属性值( value ):</td>
					<td>
						<input type="text" id="key" value="" class="empty" />
					</td>
				</tr>
				<tr style="visibility:hidden;">
					<td style="width:80;text-aglin:right">属性( key ):</td>
					<td>
						<input type="radio" id="name" name="keyType" class="radio first" checked /><span>name (string)</span>						
					</td>
				</tr>
				<tr style="visibility:hidden;">
					<td style="width:80;text-aglin:right">方法:</td>
					<td>
						<input type="radio" id="getNodesByParamFuzzy" name="funType" class="radio"	style="margin-left: 36px;" checked /><span>getNodesByParamFuzzy
							(only string)</span>
					</td>
				</tr>
			</table>
		</div>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	
</body>
	
</body>
</html>