<%@page deferredSyntaxAllowedAsLiteral="true"
	contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-cache");
	}
%>

<script type="text/javascript">
jQuery(document).ready(function() {
    jQuery('#sub_main').jcarousel({
    	visible: 10,
   	 	easing: 'BounceEaseOut',
        animation: 1000
    });
});
</script>

<SCRIPT type="text/javascript">
	var setting = {
		view : {
			addHoverDom : addHoverDom,
			removeHoverDom : removeHoverDom,
			selectedMulti : false,
			fontCss : getFontCss,
			showIcon : true
		},
		async : {
			enable : true,
			url : "tree.htm",
			contentType: "application/json",

			contentType	: "application/json;charset=UTF-8",
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
			beforeDrag : beforeDrag,
			beforeEditName : beforeEditName,
			beforeRemove : beforeRemove,
			beforeRename : beforeRename,
			onRemove : onRemove,
			onRename : onRename
		}
	};	
   
	function focusKey(e) {
		if (key.hasClass("empty")) {
			key.removeClass("empty");
		}
	};
	function blurKey(e) {
		if (key.get(0).value === "") {
			key.addClass("empty");
		}
	};
	var lastValue = "", nodeList = [], fontCss = {};
	function clickRadio(e) {
		lastValue = "";
		searchNode(e);
	};
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

	};
	function updateNodes(highlight) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		for ( var i = 0, l = nodeList.length; i < l; i++) {
			nodeList[i].highlight = highlight;
			zTree.updateNode(nodeList[i]);
		}
	};
	function getFontCss(treeId, treeNode) {
		return (!!treeNode.highlight) ? {
			color : "#A60000",
			"font-weight" : "bold"
		} : {
			color : "#333",
			"font-weight" : "normal"
		};
	};
	var log, className = "dark";
	function beforeDrag(treeId, treeNodes) {
		return false;
	};
	function beforeEditName(treeId, treeNode) {
		className = (className === "dark" ? "" : "dark");
		showLog("[ " + getTime() + " beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; "
				+ treeNode.name);
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);
	};
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
	};
	
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

	};
	function onRemove(e, treeId, treeNode) {
		showLog("[ " + getTime() + " onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; "
				+ treeNode.name);
	};
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
	};
	function onRename(e, treeId, treeNode) {
		showLog("[ " + getTime() + " onRename ]&nbsp;&nbsp;&nbsp;&nbsp; "
				+ treeNode.name);
	};
	function showLog(str) {
		if (!log)
			log = $("#log");
		log.append("<li class='"+className+"'>" + str + "</li>");
		if (log.children("li").length > 8) {
			log.get(0).removeChild(log.children("li")[0]);
		}
	};
	function getTime() {
		var now = new Date(), h = now.getHours(), m = now.getMinutes(), s = now
				.getSeconds(), ms = now.getMilliseconds();
		return (h + ":" + m + ":" + s + " " + ms);
	};
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
	};
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
						$("#name").bind("change", clickRadio);
						$("#id").bind("change", clickRadio);
						$("#getNodesByParamFuzzy").bind("change", clickRadio);						
					});
</SCRIPT>

<script type='text/javascript' defer="defer">
	var title = "贷款明细000001100c";
	var myFlex = {
		dataType : 'json',
		url : 'query/getTable.htm',
		usepager : true,
		title : title,
		useRp : true,
		rp : 10,
		showTableToggleBtn : true,
		width : 'auto',
		height : 200
	};
	var colModel01 = Array();
	// 获取表头
	$.ajax({
		url : "query/getColumnModel.htm",
		dataType : 'json',
		async : false, // 一定要使用同步，否则在firefox、chrome无法显示
		success : function(result) {
			colModel01 = result;
		}
	});
	$("#OrdersGrid").flexigrid($.extend({}, myFlex, {
		colModel : colModel01,
		preProcess : formatData
	}));
	function formatData(data) {
		var rows = Array();
		$.each(data.rows, function(i, row) {
			var myCell = Array();
			for ( var p in row) {
				myCell.push(row[p]);
			}
			rows.push({
				cell : myCell
			});
		});

		
		
		return {
			total : data.total,
			page : data.page,
			rows : rows
		};
	}
	function GetColumnSize(percent) {
		screen_res = ($(document).width() - 221) * 0.85;
		col = parseInt((percent * (screen_res / 100)));
		if (percent != 100) {
			return col - 18;
		} else {
			return col;
		}
	}
</script>

<SCRIPT type="text/javascript">
	// global vars for layouts and tabs - for convenience
	var innertabsLayout, $InnerTabs;
	var newInnerTabCounter = 1;

	// global vars for layouts and tabs - for convenience
	var $InnerTabs;	

	var innerpageLayoutOptions = {
		resizable:				false
		,	closable:				false
		,	north__size:			50		
		,	spacing_open:			0
		,	north__paneSelector:	"#inner_tab_buttons"	// tab-buttons
		,	center__paneSelector:	"#inner_tab_panels"	// tab-panels-wrapper
		,	center__onresize:		$.layout.callbacks.resizeTabLayout // resize 'visible tab layout' if pane resizes	
		,	center__childOptions:	innertabLayoutOptions
	};
	
	// options for the layout generated _inside_ the tab(s)
	var innertabLayoutOptions = {
		name:						'innertabLayoutOptions' // only for debugging
		,	showErrorMessages:		false	// some panes do not have an inner layout
		,	resizeWhileDragging:	true
		,   north__size:			"30%"	
		,	sourth__size:			"30%"
		,	minSize:				100
		,	center__minHeight:		100
		,	spacing_open:			0		
		,	resizeWithWindow : false // *** IMPORTANT *** tab-layouts must NOT resize with the window
		,	center__contentSelector : ".ui-widget-content"
		
	};

	// onClick event of the Add New Tab button
	function add_inner_tab() {
		$InnerTabs.tabs("add", "tab.html", "Tab " + (++newInnerTabCounter));

	};

	// bound to 'X' icon inside NEW tab-buttons
	function remove_inner_tab(evt) {
		if (confirm("Close this tab?")) {
			var idx = $(this).closest("li").index();			
			$InnerTabs.tabs("remove", idx-1);
		}
	};

	$(document).ready(function(){		
		//init the Tabs-Wrapper layout inside the center-pane of the outerpageLayout
		innertabsLayout = $("#s_form_tab").layout(innerpageLayoutOptions);
		$InnerTabs = $("#s_form_tab").tabs({
			
				//	load Ajax tabs only once - when it is created
				cache : true

				//	use a tab-button template so we can add a close (X) button/icon
				,
				tabTemplate : '<LI><A href="#{href}">#{label}  <SPAN class="ui-icon ui-icon-close"></SPAN></A></LI>'
				//	use a tab-template template so we can add our own class, and hide it temporarily
				,	panelTemplate : '<DIV class="tab-panel"></DIV>'
				,	idPrefix : "inner_tab_panel_" // prefix for auto-generated ID for panel - eg: "tab_panel_3"

				//	show() runs after a tab is made visible - but before Ajax content is loaded
				//	this will also run when the tabs widget initializes - and the first tab-panel is shown
				//,	show: $.layout.callbacks.resizeTabLayout // resize the layout inside tab - if one exists

				//,	show_ALTERNATE: function (evt, ui) {
				// resize inner tab-layout(s), if are any
				//		$.layout.callbacks.resizeTabLayout(evt, ui);

				// resize Accordion(s), if are any
				// REQUIRES the jquery.layout.resizePaneAccordions.xx.js callback loaded
				//$.layout.callbacks.resizePaneAccordions(evt, ui);
				//	}

				//	add() runs after widget generates a new tab-button and tab-panel
				,	add : function(evt, ui) {
					var $panel = $(ui.panel), 
					$tab = $(ui.tab);

					// MOVE the auto-generated panel inside the panels-wrapper DIV
					// *** NO LONGER NEEDED WITH UI 1.8/1.9 - here for reference only ***
					//$panel.appendTo( "#outer_tab_panels" );

					// UI 1.8 BUG FIX
					// Until fix available in UI 1.9, must manually remove 'extra' ui-panel created
					// these phantoms are always appended as siblings of the tab-buttons UL element
					// *** NOT NEEDED WITH UI 1.9 ***
					$tab.closest("ul").siblings("div.ui-tabs-panel").remove();

					// resize tabs-layout in case tabs now wrap to another line
					$InnerTabs.layout().resizeAll();

					// bind the ui-icon-close in the tab (see template above) so it is functional
					$tab.find(".ui-icon-close").click(remove_inner_tab).attr("title","Close This Tab");

					// automatically select the newly added tab
					// this will trigger the the ajax content to 'load'
					$InnerTabs.tabs("select",ui.index);
				}

				,	load: function (evt, ui ) { 
					var $panel	= $( ui.panel )
					,	$tab	= $( ui.tab )
					//	get 'first element' of the injected content - used to store 'data'
					,	$child	= $panel.children(":first");
		
					//	look for layout-options data on the *first element* of the injected content
					//	this trick could also be used to trigger initialization of other widgets, like tabs or accordions
					var options	= $child.data("layout_options"); // eg: "tabLayoutOptions"
					if ($.type(options) === "string") options = window[ options ];
					// if layout options found, then init the layout with these options
					if (options) $panel.layout( options );
		
					/* if a tab-ID is set as data on the remote content, use it for the tab/panel
					 * disabled in this demo because we reuse the same sample page repeatedly!
					var tabId = $child.data("tab_id");
					if (tabId) {
						ui.panel.id = tabId;
						if ($tab.attr("aria-controls")) // UI 1.9 attribute
							$tab.attr("aria-controls", tabId)
						else // UI 1.8 and below
							ui.tab.href = "#"+ tabId;
					}
					*/
				}
		
			//	remove() runs after widget removes a tab
			,	remove: function (evt, ui ) { 
					// resize tabs-layout in case tabs no longer wrapped to another line
				 	$InnerTabs.layout().resizeAll();
				}
		
			//	create() runs after widget is created and the first tab is shown
			,	create: function (evt, ui) { 
					// create the layout inside the first tab
					$("#inner_first_panel").layout( innertabLayoutOptions );
				}
		
			});	
			
			// resize the outertabsLayout after creating the tabs to fit the tabs precisely
			innertabsLayout.resizeAll();
		
		});				
</SCRIPT>

<div id="sub_navigation_main" class="middle-north" data-layout_options="tabLayoutOptions">					
	<div id="sub_main" class="subnavigation first-and-second-carousel jcarousel-skin-tango">
		<ul>
			<c:forEach var="result" items="${subnavigations}">
				<li><div class="subnavigation_img">${result.module_name}</div></li>			
			</c:forEach>
		</ul>
	</div>	
</div>
<div id="ztree" class="middle-west">
	<div class="left">
		<div style="text-aglin: left;">
			<table style="width: 100; height: 40; overflow: hidden">
				<tr>
					<td style="width: 50; text-aglin: right">属性值:</td>
					<td><input style="width: 50" type="text" id="key"
						value="" class="empty" /></td>
				</tr>
			</table>
			<div style="display: none">
				<table>
					<tr style="visibility: hidden;">
						<td style="width: 50; text-aglin: right">属性( key ):</td>
						<td><input type="radio" id="name" name="keyType"
							class="radio first" checked /><span>name (string)</span>
						</td>
					</tr>
					<tr style="visibility: hidden;">
						<td style="width: 50; text-aglin: right">方法:</td>
						<td><input type="radio" id="getNodesByParamFuzzy"
							name="funType" class="radio" style="margin-left: 36px;"
							checked /><span>getNodesByParamFuzzy (only string)</span>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<ul id="treeDemo" class="ztree"></ul>
	</div>	
</div>
<div id="s_form_tab" class="middle-center">
	<div id="inner_tab_buttons">
		<ul>
			<li><a href="#inner_first_panel">查询页面1</a></li>
			<li style="float:right">
				<div style="height:20px;width:40px;" onclick="add_inner_tab()">
					Add
				</div>
			</li>
		</ul>
	</div>
	<div id="inner_tab_panels">
		<div id="inner_first_panel" class="tab-panel">			
			<div style="width: 100%; height: 200px;">		
			<p>select trace_no, trace_cnt, opn_br_no, tx_br_no, ac_id, ac_seqn, tx_code, sub_tx_code, ln_tx_type, add_ind, ct_ind, tx_amt, bal, intst_acm, tx_date, tx_time, note_type, note_no, hst_cnt, brf, tel, chk, auth from ln_mst_hst100y  where rownum &lt; 100 
			</p>			
			</div>			
			<div class="ui-widget-content">
				<table id='OrdersGrid'></table>
				<div id='OrdersGrid_pager'></div>
			</div>							
		</div>
	</div>
</div>
