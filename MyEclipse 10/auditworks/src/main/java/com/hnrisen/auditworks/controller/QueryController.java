package com.hnrisen.auditworks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QueryController {
	
	@RequestMapping(value = "/query/ztree", method = RequestMethod.GET)
	public String ztree() {
	
		return "/query/ztree";
	}
	
	@RequestMapping(value = "/query/jstree", method = RequestMethod.GET)
	public String jstree() {
	
		return "/query/jstree";
	}
	
	
}
