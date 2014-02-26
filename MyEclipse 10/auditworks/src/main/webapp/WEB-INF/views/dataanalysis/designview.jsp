<%@page deferredSyntaxAllowedAsLiteral="true"
	contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript">
jQuery(document).ready(function() {
    jQuery('#sub_designview').jcarousel({
    	visible: 10,
   	 	easing: 'BounceEaseOut',
        animation: 1000		
    });
});
</script>

<SCRIPT type="text/javascript"  defer="defer">
	var setting = {
		view : {
			addHoverDom : addHoverDom,
			removeHoverDom : removeHoverDom,
			selectedMulti : true,
			fontCss : getFontCss
		},
		async : {
			enable : true,
			url : "tableTree.htm",
			contentType: "application/json;charset=UTF-8",
			autoParam : [ "id", "name=n", "level=lv" ],
			otherParam : {
				"otherParam" : "zTreeAsyncTest"
			},
			dataFilter : filter
		},
		edit : {
			enable : true,
			editNameSelectAll : true
		},
		data : {
			key : {
				title : "t"
			},
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeDblClick: zTreeBeforeDblClick
		}
	};
	
	
	
	
	//双击事件
	function zTreeBeforeDblClick(treeId, treeNode) {
		
		
		 
		 
		 if (confirm("显示表 -- " + treeNode.name + " 所有列吗？")) {

			 $.post("tableColumn.htm", { name: treeNode.name},
					   function(data) {
					     
					   var arrays=  data.split(":");
					   
					   var td="<tr><td>"+treeNode.name+"</td></tr>";
					     for(var i=0;i<arrays.length;i++){
					    	
					    	 td=td+"<tr><td>"+arrays[i]+"</td></tr>";
					     }
					     
					    //$("#tableOcean").html(treeNode.name);
					    
					    $("#tableCoumnId").html(td);
					   });

			}
		 
		
	   // return false;
	}
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
		
		//alert("===================="+e);
		searchNode(e);
	}
	function filter(treeId, parentNode, childNodes) {
		if (!childNodes){
			
			return null;
			
		}
		
		for ( var i = 0, l = childNodes.length; i < l; i++) {
			
			childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
		}
		return childNodes;
	}
	function searchNode(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var value = $.trim(key.get(0).value);
		
		alert("searchNode(e)====="+value);
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
		if (lastValue === value) {
			return;
		}

		updateNodes(false);
		lastValue = value;
		if (value === "") {
			return;
		}

		if ($("#getNodesByParamFuzzy").attr("checked")) {
			nodeList = zTree.getNodesByParamFuzzy(keyType, value);
		}
		updateNodes(true);

	}
	function updateNodes(highlight) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		for ( var i = 0, l = nodeList.length; i < l; i++) {
			nodeList[i].highlight = highlight;
			zTree.updateNode(nodeList[i]);
		}
	}
	function getFontCss(treeId, treeNode) {
		return (!!treeNode.highlight) ? {
			color : "#A60000",
			"font-weight" : "bold"
		} : {
			color : "#333",
			"font-weight" : "normal"
		};
	}
	var log, className = "dark";
	function beforeEditName(treeId, treeNode) {
		
		if (confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？")) {

			$.funkyUI({

				id : treeId,//弹出窗口的id
				title : '更新节点界面：',//弹出窗口的标题
				// showButtonRow: true,//是否显示按钮   
				showDialog : true,//是否显示框体   
				url : "updateShowTree.htm?pid=" + treeNode.pId + "&id="
						+ treeNode.id,
				css : {
					width : "400",
					height : "300"
				}
			});

		}
	}
	function beforeRemove(treeId, treeNode) {
		className = (className === "dark" ? "" : "dark");
		showLog("[ " + getTime() + " beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; "
				+ treeNode.name);
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);

		if (confirm("确认删除 节点 -- " + treeNode.name + " 吗？")) {
			$.funkyUI({
				id : treeId,//弹出窗口的id
				title : '删除节点界面：',//弹出窗口的标题
				// showButtonRow: true,//是否显示按钮   
				showDialog : true,//是否显示框体   
				url : "deleteShowTree.htm?pid=" + treeNode.pId + "&id="
						+ treeNode.id,
				css : {
					width : "400",
					height : "300"
				}
			});

		}

	}
	function onRemove(e, treeId, treeNode) {
		showLog("[ " + getTime() + " onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; "
				+ treeNode.name);
	}
	function beforeRename(treeId, treeNode, newName) {
		className = (className === "dark" ? "" : "dark");
		showLog("[ " + getTime() + " beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; "
				+ treeNode.name);
		if (newName.length == 0) {
			alert("节点名称不能为空.");
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			setTimeout(function() {
				zTree.editName(treeNode);
			}, 10);
			return false;
		}
		return true;
	}
	function onRename(e, treeId, treeNode) {
		showLog("[ " + getTime() + " onRename ]&nbsp;&nbsp;&nbsp;&nbsp; "
				+ treeNode.name);
	}
	function showLog(str) {
		if (!log)
			log = $("#log");
		log.append("<li class='"+className+"'>" + str + "</li>");
		if (log.children("li").length > 8) {
			log.get(0).removeChild(log.children("li")[0]);
		}
	}
	function getTime() {
		var now = new Date(), h = now.getHours(), m = now.getMinutes(), s = now
				.getSeconds(), ms = now.getMilliseconds();
		return (h + ":" + m + ":" + s + " " + ms);
	}

	var newCount = 1;
	function addHoverDom(treeId, treeNode) {

		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_" + treeNode.id).length > 0) {
			return;
		}
		var addStr = "<button type='button' class='add' id='addBtn_"
				+ treeNode.id
				+ "' title='add node' onfocus='this.blur();  '></button>";
		sObj.append(addStr);
		
		//alert("treeId==="+treeId);
		//alert("treeNode.id==="+treeNode.id);
		var btn = $("#addBtn_" + treeNode.id);
		if (btn)
			btn.on("click", function() {
				$.funkyUI({
					id : treeNode.id,//弹出窗口的id
					title : '添加节点界面：',//弹出窗口的标题
					// showButtonRow: true,//是否显示按钮   
					showDialog : true,//是否显示框体   
					url : "addShowTree.htm?id=" + treeNode.id,
					css : {
						width : "400",
						height : "300"
					}
				});
				return true;
			});
	};
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_" + treeNode.id).unbind().remove();
	};
	function selectAll() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.setting.edit.editNameSelectAll = $("#selectAll").attr("checked");
	}
	var key;
	$(document)
			.ready(
					function() {
						$.fn.zTree.init($("#treeDemo"), setting);
						$("#selectAll").bind("click", selectAll);
						key = $("#key");
						key.bind("focus", focusKey).bind("blur", blurKey).bind(
								"propertychange", searchNode).bind("input",
								searchNode);
						$("#name").bind("click", clickRadio);
						$("#id").bind("change", clickRadio);
						$("#getNodesByParamFuzzy").bind("change", clickRadio);
					});
</SCRIPT>

<DIV id="sub_navigation_designview" class="ui-layout-north ui-widget-content" data-layout_options="tabLayoutOptions">				
	<div id="sub_designview" class="first-and-second-carousel jcarousel-skin-tango">
		<ul>
			<c:forEach var="result" items="${subnavigations}">
				<li><div class="subnavigation">${result.module_name}</div></li>			
			</c:forEach>
		</ul>
	</div>
</DIV> 
<DIV id="s_form_tabs" class="ui-layout-center ui-widget-content">
	<div>
		<table id="tableCoumnId" ></table>
	</div>	
</DIV> 
<DIV id="ztree" class="ui-layout-west ui-widget-content">		
	<div class="left">
		<div style="text-aglin:left;">
			<table style="width:100;height:40;overflow:hidden">
				<tr>
					<td style="width:50;text-aglin:right">属性值:</td>
					<td>
						<input style="width:50" type="text" id="key" value="" class="empty" />
					</td>
				</tr>								
			</table>
			<div style="display:none">
				<table>
					<tr style="visibility:hidden;">
						<td style="width:50;text-aglin:right">属性( key ):</td>
						<td>
							<input type="radio" id="name" name="keyType" class="radio first" checked /><span>name (string)</span>						
						</td>
					</tr>
					<tr style="visibility:hidden;">
						<td style="width:50;text-aglin:right">方法:</td>
						<td>
							<input type="radio" id="getNodesByParamFuzzy" name="funType" class="radio"	style="margin-left: 36px;" checked /><span>getNodesByParamFuzzy
								(only string)</span>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<ul id="treeDemo" class="ztree"></ul>
	</div>				
</DIV>