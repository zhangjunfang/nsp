package com.hnrisen.auditworks.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HomepageController {

	@RequestMapping(value="homepage/mydesktop",method={RequestMethod.GET,RequestMethod.POST})
	public  String  designview(){
		
		return "homepage/mydesktop";
	}	
}
