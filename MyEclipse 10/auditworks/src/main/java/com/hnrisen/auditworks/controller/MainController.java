package com.hnrisen.auditworks.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hnrisen.auditworks.domain.Subnavigation;
import com.hnrisen.auditworks.service.subnavigation.SubnavigationService;

/**
 * The Class AccountController.
 */
@Controller
public class MainController {
	
	@Autowired
	private SubnavigationService<Subnavigation> subnavigationService;
	
	@RequestMapping(value = "dataanalysis/main", method = {RequestMethod.GET,RequestMethod.POST})
	public final void getByScene(final ModelMap map, final HttpServletRequest request) throws Exception {	
		
		Subnavigation objsubnavigation=new Subnavigation();
	    objsubnavigation.setModule_type_id(request.getParameter("module_type_id"));
		List<Subnavigation> subnavigations = this.subnavigationService.getByScene(objsubnavigation);
		map.put("subnavigations", subnavigations);	
		
	}

	
	@RequestMapping(value="dataanalysis/designview",method={RequestMethod.GET,RequestMethod.POST})
	public final void getByScene_designview(final ModelMap map, final HttpServletRequest request) throws Exception {	
		
		Subnavigation objsubnavigation=new Subnavigation();
	    objsubnavigation.setModule_type_id(request.getParameter("module_type_id"));
		List<Subnavigation> subnavigations = this.subnavigationService.getByScene(objsubnavigation);
		map.put("subnavigations", subnavigations);	
		
	}
}
