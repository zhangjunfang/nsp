package com.hnrisen.auditworks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class MasterController.
 */
@Controller
public class MasterController {
	
	@RequestMapping(value = "/master/getAll", method = RequestMethod.GET)
	public final void getAll() {
	
	}
}
