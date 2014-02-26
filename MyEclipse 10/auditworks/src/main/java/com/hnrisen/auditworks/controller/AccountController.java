package com.hnrisen.auditworks.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hnrisen.auditworks.domain.Account;
import com.hnrisen.auditworks.service.account.AccountService;

/**
 * The Class AccountController.
 */
@Controller
public class AccountController {
	
	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	/** The CRUD service. */
	@Autowired
	private AccountService<Account> accountService;
	
	/**
	 * Gets the all.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 * @return the all
	 */
	@RequestMapping(value = "/account/getAll", method = RequestMethod.GET)
	public final void getAll(final ModelMap map, final HttpServletRequest request) throws Exception {
	
		List<Account> accounts = this.accountService.getAll(new Account());
		map.put("accounts", accounts);
	}
	
	/**
	 * Gets the.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 */
	@RequestMapping(value = "/account/get", method = RequestMethod.GET)
	public final void get(@ModelAttribute final Account reqAccount, final ModelMap map,
			final HttpServletRequest request) throws Exception {
	
		Account account = this.accountService.get(reqAccount);
		map.put("account", account);
	}
	
	/**
	 * Creates the form.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 */
	@RequestMapping(value = "/account/createForm", method = RequestMethod.GET)
	public final void createForm(final ModelMap map, final HttpServletRequest request)
			throws Exception {
	
	}
	
	/**
	 * Creates the.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 */
	@RequestMapping(value = "/account/create", method = RequestMethod.POST)
	public final ModelAndView create(@ModelAttribute final Account account, final ModelMap map,
			final HttpServletRequest request) throws Exception {
	
		ModelAndView mav = new ModelAndView("redirect:/account/getAll.htm");
		this.accountService.create(account);
		return mav;
	}
	
	/**
	 * Modify form.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 */
	@RequestMapping(value = "/account/modifyForm", method = RequestMethod.GET)
	public final void modifyForm(@ModelAttribute final Account reqAccount, final ModelMap map,
			final HttpServletRequest request) throws Exception {
	
		Account account = this.accountService.get(reqAccount);
		map.put("account", account);
	}
	
	/**
	 * Modify.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 */
	@RequestMapping(value = "/account/modify", method = RequestMethod.POST)
	public final ModelAndView modify(@ModelAttribute final Account account, final ModelMap map,
			final HttpServletRequest request) throws Exception {
	
		ModelAndView mav = new ModelAndView("redirect:/account/getAll.htm?" + account.getUserid());
		this.accountService.modify(account);
		return mav;
	}
	
	/**
	 * Removes the.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 */
	@RequestMapping(value = "/account/remove", method = RequestMethod.GET)
	public final ModelAndView remove(@ModelAttribute final Account account, final ModelMap map,
			final HttpServletRequest request) throws Exception {
	
		ModelAndView mav = new ModelAndView("redirect:/account/getAll.htm");
		this.accountService.remove(account);
		return mav;
	}
}
