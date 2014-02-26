/**
 * 
 */
package com.hnrisen.auditworks.common.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hnrisen.auditworks.domain.Navigation;
import com.hnrisen.auditworks.service.navigation.NavigationService;

/**
 * @author ： ocean
 *  date ：2012-4-27
 */
@Controller
public class IndexController implements Serializable {
	
	private static final long serialVersionUID = 3942301130944319561L;
	
	
	
	
	@Resource(name="navigationServiceImpl")
	private NavigationService<Navigation> navigationService;
	@RequestMapping(value="index",method={RequestMethod.GET,RequestMethod.POST})
	public final void index(final ModelMap map, final HttpServletRequest request) throws Exception {		
		
		
		List<Navigation> navigations = this.navigationService.getAll(new Navigation());
		map.put("navigations", navigations);
	}	
}
