package com.hnrisen.auditworks.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hnrisen.auditworks.domain.Subnavigation;
import com.hnrisen.auditworks.service.subnavigation.SubnavigationService;

@Controller
public class SubnavigationController implements Serializable{
	
	
	private static final long serialVersionUID = -5365033130399129870L;
	
	@Autowired
	private SubnavigationService<Subnavigation> subnavigationService;
	
	@RequestMapping(value = "/subnavigation/getsubnavigationbyscene", method = RequestMethod.GET)
	public final void getByScene(final ModelMap map, final HttpServletRequest request) throws Exception {
		
		List<Subnavigation> subnavigations = this.subnavigationService.getAll(new Subnavigation());
		map.put("subnavigations", subnavigations);
	}	
	
	

}