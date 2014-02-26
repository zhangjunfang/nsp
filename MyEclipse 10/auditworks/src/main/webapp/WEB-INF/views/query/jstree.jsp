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
	
<link rel="stylesheet" type="text/css" href="/auditworks/static/css/jstree/layout.css" />
<link rel="stylesheet" type="text/css" href="/auditworks/static/css/jstree/style1.css"/>
<link rel="stylesheet" type="text/css" href="/auditworks/static/css/jstree/style2.css"/>
<script type="text/javascript"	src="/auditworks/static/js/script.js"></script>
<script type="text/javascript"	src="/auditworks/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript"	src="/auditworks/static/js/jquery.cookie.js"></script>
<script type="text/javascript"	src="/auditworks/static/js/jquery.hotkeys.js"></script>
<script type="text/javascript"	src="/auditworks/static/js/jquery.jstree.js"></script>
	
<style type="text/css"> 
#demo, #demo input, .jstree-dnd-helper, #vakata-contextmenu { font-size:10px; font-family:Verdana; }
#container { position:relative; }
#container .demo { width:740px; border:1px solid gray; padding:0; margin:10px 0; }
#container .code { width:738px; }
#container #demo { width:778px; float:none; height:400px; overflow:auto; border:1px solid gray; }
#menub { height:30px; overflow:auto; }
#text { margin-top:1px; }
#alog { font-size:9px !important; margin:5px; border:1px solid silver; }
#dhead { display:none; }
#content.demo { width:780px; border:0; }
</style>

<style type="text/css" > 
#demo5 li { min-height:22px; line-height:22px; }
#demo5 a { line-height:20px; height:20px; font-size:10px; }
#demo5 a ins { height:20px; width:20px; background-position:-56px -17px; } 
</style>

</head>
<body>
<div id="container">
	<div id="description">
		<div id="demo1" class="demo" style="height:100px;">
			<ul>
				<li id="phtml_1">
					<a href="#">Root node 1</a>
					<ul>
						<li id="phtml_2">
							<a href="#">Child node 1</a>
						</li>
						<li id="phtml_3">
							<a href="#">Child node 2</a>
						</li>
					</ul>
				</li>
				<li id="phtml_4">
					<a href="#">Root node 2</a>
				</li>
			</ul>
		</div>
		<script type="text/javascript" class="source below"> 
		$(function () {
			// TO CREATE AN INSTANCE
			// select the tree container using jQuery
			$("#demo1")
				// call `.jstree` with the options object
				.jstree({
					// the `plugins` array allows you to configure the active plugins on this instance
					"plugins" : ["themes","html_data","ui","crrm","hotkeys"],
					// each plugin you have included can have its own config object
					"core" : { "initially_open" : [ "phtml_1" ] }
					// it makes sense to configure a plugin only if overriding the defaults
				})
				// EVENTS
				// each instance triggers its own events - to process those listen on the container
				// all events are in the `.jstree` namespace
				// so listen for `function_name`.`jstree` - you can function names from the docs
				.bind("loaded.jstree", function (event, data) {
					// you get two params - event & data - check the core docs for a detailed description
				});
			// INSTANCES
			// 1) you can call most functions just by selecting the container and calling `.jstree("func",`
			setTimeout(function () { $("#demo1").jstree("set_focus"); }, 500);
			// with the methods below you can call even private functions (prefixed with `_`)
			// 2) you can get the focused instance using `$.jstree._focused()`. 
			setTimeout(function () { $.jstree._focused().select_node("#phtml_1"); }, 1000);
			// 3) you can use $.jstree._reference - just pass the container, a node inside it, or a selector
			setTimeout(function () { $.jstree._reference("#phtml_1").close_node("#phtml_1"); }, 1500);
			// 4) when you are working with an event you can use a shortcut
			$("#demo1").bind("open_node.jstree", function (e, data) {
				// data.inst is the instance which triggered this event
				data.inst.select_node("#phtml_2", true);
			});
			setTimeout(function () { $.jstree._reference("#phtml_1").open_node("#phtml_1"); }, 2500);
		});
		</script>
	</div>	
	<div id="description">
		<div id="demo5" class="demo" style="height:120px;">
			<ul>
				<li class="jstree-open">
					<a href="#">Root node 1</a>
					<ul>
						<li>
							<a href="#">Child node 1 with a long text which would normally just cause a scrollbar, but with this line of CSS it will actually wrap, this is not really throughly tested but it works</a>
						</li>
						<li>
							<a href="#">Child node 2</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#">Root node 2</a>
				</li>
			</ul>
		</div>
		
		<script type="text/javascript" class="source below"> 
		
		$(function () {
			$("#demo5")
				.jstree({ "plugins" : ["themes","html_data","ui"] });
		});
		</script>
	</div>
</div>
</body>
</html>