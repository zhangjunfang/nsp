<%@page deferredSyntaxAllowedAsLiteral="true"
	contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算机辅助审计平台</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/themes/cupertino/jquery.ui.all.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/layout-default-latest.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/rcarousel.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/zTree/zTreeStyle.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/jqgrid/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/flexigrid.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/jcarousel/skin.css" />
	
<style type="text/css">
<!--
.subnavigation_img
{
	background:#eee url(<%=basePath%>static/images/custom/button.png) no-repeat 0 0;
	width:97px;
	height:37px;
	line-height:35px;
	text-align:center;
}

.tips_hope
{
	background:#eee url(<%=basePath%>static/images/custom/xx_button.png) no-repeat 0 0;
	width:190px;
	height:150px;
	line-height:35px;
	text-align:center;
}

#navigation
{
	height:400px;
	width:100%;	
	padding: 10px 10px;	
}

#navigation ul li {
	float:left;
    list-style-type:none;	
	padding: 10px 10px;	
}

#navigation button {
	padding: 5px 15px;
	height: 60px;
}

.ztree li button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}
-->
</style>
	
<style type="text/css">
/*
	 *	REQUIRED pane & wrapper styles
	 *	this code removes padding and borders from all elements that need it
	 */
#page_header,
	/* this pane has a header & content-div, so should not have padding or scrolling */
	#page_center, /* wrapper for tabs widget */ 
	#outer_tab_buttons,	/* tab-buttons wrapper (center-north) */ 
	#outer_tab_panels,	/* tab-panels  wrapper (center-center) */ 
	#inner_tab_buttons,	/* tab-buttons wrapper (center-north) */ 
	#inner_tab_panels,	/* tab-panels  wrapper (center-center) */ 
	.tab-panel {
	/* individual tab-panels */
	border: none;
	padding: 0 !important; /* override UI theme for tab-panels */
	overflow: hidden;
}
.tab-panel { /* individual tab-panels */
	/* make ALL tab-panels FILL the #out_tab_panels wrapper */
	width: 100%;
	height: 100%;
}

#outer_tab_buttons span.ui-icon {
	/* (x) close icons/buttons inside the tabs */
	margin-right: -7px;
	vertical-align: middle;
	display: inline-block;
	cursor: pointer;
}

#inner_tab_buttons span.ui-icon {
	/* (x) close icons/buttons inside the tabs */
	margin-right: -7px;
	vertical-align: middle;
	display: inline-block;
	cursor: pointer;
}

#outer_tab_buttons ul {
	height: 100%;
}

#outer_tab_buttons ul li {
	height: 150px;
	width:100%;
	float: none;
	writing-mode : tb-rl;
	text-align : center;		
}
#outer_tab_buttons ul li a {
	height:80%;	
	vertical-align : center;		
}

.middle-west
{
	background: #f0f6e4;	
}

/*#inner_tab_buttons ul {
	height: 80%;
}
*/
#inner_tab_buttons ul li {
	width: 120px;
	float: left;		
	text-align : center;		
}
#inner_tab_buttons ul li a {	
	vertical-align : center;		
}

/*
	 *	COSMETIC styling - not required
	 */
#page_header h3 {
	padding: 5px 15px;
	margin: 0;
}
#page_header
{	
	background: #4fbace url("<%=basePath%>static/images/vista blue.png") no-repeat;
}

/*
	 *	styles for layouts & elements inside tab-panels
	 */
.tab-panel .ui-layout-north {
	border-width: 0 0 1px;
	overflow: hidden;
}

.tab-panel .ui-layout-center {
	border-width: 1px 0 0 1px;
	padding: 0;
	overflow: hidden;
}

.tab-panel .ui-layout-west {
	border-width: 1px 1px 0;	
	overflow: hidden;
}

.tab-panel .ui-layout-center .ui-widget-content {
	padding: 0;
	overflow: auto;
}
</style>

<script type="text/javascript"
	src="<%=basePath%>static/js/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery-ui-latest.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.layout-latest.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.layout.resizeTabLayout-1.2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/grid.locale-en.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/themeswitchertool.js"></script>
<script type="text/javascript" 
	src="<%=basePath%>static/js/debug.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.ui.core.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.ui.widget.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.ui.rcarousel.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.jcarousel.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.ztree.core-3.1.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/static/js/jquery.ztree.excheck-3.1.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/static/js/jquery.ztree.exedit-3.1.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/static/js/jquery.funkyUI.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/static/js/flexigrid.js"></script>

<script type="text/javascript">
//Credits: Robert Penners easing equations (http://www.robertpenner.com/easing/).
jQuery.easing['BounceEaseOut'] = function(p, t, b, c, d) {
	if ((t/=d) < (1/2.75)) {
		return c*(7.5625*t*t) + b;
	} else if (t < (2/2.75)) {
		return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
	} else if (t < (2.5/2.75)) {
		return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
	} else {
		return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
	}
};

jQuery(document).ready(function() {
    jQuery('div.subnavigation').jcarousel({
    	visible: 10,
   	 	easing: 'BounceEaseOut',
        animation: 1000
	});
});

jQuery(document).ready(function() {
    jQuery('#tips_hope').jcarousel({
    	visible: 6
    });
});

</script>

<SCRIPT type="text/javascript">
 
	// global vars for layouts and tabs - for convenience
	var $OuterTabs;
	
	// options for the layout generated _inside_ the tab(s)
	var outerpageLayout = {
		name:					'outerpageLayout' // only for debugging
	,	resizable:				false
	,	closable:				false
	,	north__size:			90		
	,	spacing_open:			0
	,	north__paneSelector:	"#page_header"	// page header
	,	center__paneSelector:	"#page_center"			// tabs-wrapper
	,	center__childOptions:
		{
			resizable:				false
		,	closable:				false
		,	west__size:				60		
		,	spacing_open:			0
		,	west__paneSelector:		"#outer_tab_buttons"	// tab-buttons
		,	center__paneSelector:	"#outer_tab_panels"	// tab-panels-wrapper
		,	center__onresize:		$.layout.callbacks.resizeTabLayout // resize 'visible tab layout' if pane resizes
		}		
	};
 
	//	define sidebar options here because are used for BOTH east & west tab-panes (see below)
	var sidebarLayoutOptions = {
		name:					'sidebarLayout' // only for debugging	
	,	center__paneSelector:	".inner-center"
	,	west__paneSelector:		".inner-west"
	,	east__paneSelector:		".inner-east"
	,	north__paneSelector:	".inner-north"
	,	showErrorMessages:		false	// some panes do not have an inner layout
	,	resizeWhileDragging:	true
	,	contentSelector:		".ui-widget-content"
	};
 
	//	options used for the tab-panel-layout on all 3 tabs
	var tabLayoutOptions = {
		name:					'tabPanelLayout' // only for debugging	
	,	resizeWithWindow:		false	// required because layout is 'nested' inside tabpanels container
	,	resizeWhileDragging:	true	// slow in IE because of the nested layouts
	,	center__paneSelector:	".middle-center"
	,	west__paneSelector:		".middle-west"
	,	east__paneSelector:		".middle-east"
	,	north__paneSelector:  	".middle-north"
	,	south__paneSelector:  	".middle-south"
	,	resizerDragOpacity:		0.5
	,	north__resizable:		false	
	,	north__closable:		false	
	,	north__size:            62
	,	west__minSize:			200
	,	east__minSize:			200
	,	center__minWidth:		400
	,	north__spacing_open:	0
	,	spacing_closed:			6	
	,	spacing_open:			6	
	,	contentSelector:		".ui-widget-content"	
	//,	togglerContent_open:	'<div class="ui-icon"></div>'
	//,	togglerContent_closed:	'<div class="ui-icon"></div>'
	//,	west__togglerLength_open:	0
	//,	west__togglerLength_close:	-1
	,	triggerEventsOnLoad:	true // so center__onresize is triggered when layout inits
	,	center__onresize:		$.layout.callbacks.resizePaneAccordions // resize ALL Accordions nested inside
	,	west__onresize:			$.layout.callbacks.resizePaneAccordions // ditto for west-pane
	/*
	,	center__onresize: function (pane, $Pane) {
			$Pane.find(":ui-accordion").accordion("resize");
		}
	*/
 
	//	add child-layouts for BOTH the east/west panes (sidebars)
	//	sidebarLayoutOptions was created above so they could be used twice here
	,	center__childOptions:	sidebarLayoutOptions	
	};
 
	// onClick event of the Add New Tab button
	function add_outer_tab (module_type_id,module_type_name) {		
		$OuterTabs.tabs( "add", "dataanalysis/main.htm?module_type_id="+module_type_id,module_type_name);
		//$OuterTabs.tabs( "add", "dataanalysis/designview.htm?module_type_id="+module_type_id,module_type_name);
		
	};
 
	// bound to 'X' icon inside NEW tab-buttons
	function remove_outer_tab (evt) {
		if ( confirm("Close this tab?") ) {
			var	idx = $(this).closest("li").index();  
			//alert(idx);
			$OuterTabs.tabs("remove", idx);
		}
	}; 
 
	$(document).ready(function(){
 	
		// init the Page Layout
		var pageLayout = $("body").layout(outerpageLayout);		
		
		$OuterTabs = pageLayout.center.pane.tabs({
		//	load Ajax tabs only once - when it is created
			cache:			true
 
		//	use a tab-button template so we can add a close (X) button/icon
		,	tabTemplate:	'<LI><A href="#{href}">#{label}  <SPAN class="ui-icon ui-icon-close"></SPAN></A></LI>'
		//	use a tab-template template so we can add our own class, and hide it temporarily
		,	panelTemplate:	'<DIV class="tab-panel"></DIV>'
		,	idPrefix:		"tab_panel_" // prefix for auto-generated ID for panel - eg: "tab_panel_3"
 
		//	show() runs after a tab is made visible - but before Ajax content is loaded
		//	this will also run when the tabs widget initializes - and the first tab-panel is shown
		,	show: $.layout.callbacks.resizeTabLayout // resize the layout inside tab - if one exists
 
		,	show_ALTERNATE: function (evt, ui) {
				// resize inner tab-layout(s), if are any
				$.layout.callbacks.resizeTabLayout(evt, ui);
 
				// resize Accordion(s), if are any
				// REQUIRES the jquery.layout.resizePaneAccordions.xx.js callback loaded
				//$.layout.callbacks.resizePaneAccordions(evt, ui);
			}
 
		//	add() runs after widget generates a new tab-button and tab-panel
		,	add: function (evt, ui) {
				var $panel	= $( ui.panel )
				,	$tab	= $( ui.tab );
 
				// MOVE the auto-generated panel inside the panels-wrapper DIV
				// *** NO LONGER NEEDED WITH UI 1.8/1.9 - here for reference only ***
				//$panel.appendTo( "#outer_tab_panels" );
 
				// UI 1.8 BUG FIX
				// Until fix available in UI 1.9, must manually remove 'extra' ui-panel created
				// these phantoms are always appended as siblings of the tab-buttons UL element
				// *** NOT NEEDED WITH UI 1.9 ***
				$tab.closest("ul").siblings("div.ui-tabs-panel").remove();
 
				// resize tabs-layout in case tabs now wrap to another line
			 	pageLayout.center.pane.layout().resizeAll();
 
				// bind the ui-icon-close in the tab (see template above) so it is functional
				$tab.find(".ui-icon-close").click( remove_outer_tab ).attr("title","Close This Tab");
 
				// automatically select the newly added tab
				// this will trigger the the ajax content to 'load'
				pageLayout.center.pane.tabs( "select", ui.index );
			}
 
		//	load() runs after widget finishes loading Ajax content into a tab
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
			 	pageLayout.center.pane.layout().resizeAll();
			}
 
		//	create() runs after widget is created and the first tab is shown
		,	create: function (evt, ui) { 
				// create the layout inside the first tab
				$("#first_panel").layout( tabLayoutOptions );
			}
 
		});
 
		// resize the outertabsLayout after creating the tabs to fit the tabs precisely
		//outertabsLayout.resizeAll();
 
 
		// UI Theme Selector - for development testing only
		addThemeSwitcher('#page_header',{ top: '43px', right: '15px' });
		// if a theme is applied by ThemeSwitch *onLoad*, it may change the height of some content,
		// so we need to call resizeLayout to 'correct' any header/footer heights affected
		// call multiple times so fast browsers update quickly, and slower ones eventually!
		// NOTE: this is only necessary because we are changing CSS *AFTER LOADING* (eg: themeSwitcher)
		setTimeout( pageLayout.resizeAll, 1000 ); /* allow time for browser to re-render for theme */
		setTimeout( pageLayout.resizeAll, 5000 ); /* for really slow browsers */
	});
 
</SCRIPT>

</head>
<body>
<DIV id="page_header">
	<!--<H3 class="ui-state-active"> Page Header </H3>  -->	
</DIV> 
<DIV id="page_center">
	<DIV id="outer_tab_buttons">
		<UL> 
			<LI><A href="#first_panel">我的桌面</A></LI> 
		</UL>
	</DIV>
 	<!-- center-pane with dynamic added tab-panels --> 
	<DIV id="outer_tab_panels"> 
		<DIV id="first_panel" class="tab-panel"> 
			<DIV id="sub_navigation_index" class="middle-north">			
				<div id="sub_index" class="subnavigation first-and-second-carousel jcarousel-skin-tango">
					<!-- <img src="<%=basePath%>static/images/custom/button.png" />	 -->	
					<ul>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
						<li><div class="subnavigation_img"></div></li>
					</ul>
				</div>
			</DIV> 
			<DIV id="navigation_list" class="middle-center">	
				<div id="navigation">					
					<ul>
						<c:forEach var="result" items="${navigations}" >
							<li><BUTTON onClick="add_outer_tab('${result.module_type_id}','${result.module_type_name}')">${result.module_type_name}</BUTTON></li>			
						</c:forEach>
					</ul>					
				</div>
				<div id="tips_hope" class="jcarousel-skin-tango">
				<!-- <img src="<%=basePath%>static/images/custom/xx_button.png" /> -->
					<ul>					
						<li><div class="tips_hope"></div></li>
						<li><div class="tips_hope"></div></li>
						<li><div class="tips_hope"></div></li>
						<li><div class="tips_hope"></div></li>
						<li><div class="tips_hope"></div></li>
						<li><div class="tips_hope"></div></li>
					</ul>												
				</div>
			</DIV> 			
		</DIV>
	</DIV>
</DIV> 
</body>
</html>