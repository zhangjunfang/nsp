package com.hnrisen.auditworks.jotm.web.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hnrisen.auditworks.jotm.domain.TabA;
import com.hnrisen.auditworks.jotm.domain.TabB;
import com.hnrisen.auditworks.jotm.service.StuJotmService;

/**
 * @author ocean
 * 
 *         方法都可以接受的参数(参数数量和顺序没有限制)：
 *         HttpServletRequest,HttpServletResponse,HttpSession(session必须是可用的)
 *         ,PrintWriter,Map,Model,@PathVariable(任意多个)， @RequestParam（任意多个）， @CookieValue
 *         （任意多个），@RequestHeader，Object（pojo对象） ,BindingResult等等
 * 
 *         返回值可以是：String(视图名)，void（用于直接response），ModelAndView，Map
 *         ，Model，任意其它任意类型的对象（默认放入model中，名称即类型的首字母改成小写），视图名默认是请求路径
 */
@Controller
public class JOTMController implements Serializable {
	private Log log = LogFactory.getLog(JOTMController.class);

	private static final long serialVersionUID = 1032762946516611797L;

	@Autowired
	private StuJotmService jotmService;

	/**
	 * 方法都可以接受的参数(参数数量和顺序没有限制)：
	 * HttpServletRequest,HttpServletResponse,HttpSession(session必须是可用的)
	 * ,PrintWriter,Map,Model,@PathVariable(任意多个)， @RequestParam（任意多个）， @CookieValue
	 * （任意多个），@RequestHeader，Object（pojo对象） ,BindingResult等等
	 * 
	 * 返回值可以是：String(视图名)，void（用于直接response），ModelAndView，Map
	 * ，Model，任意其它任意类型的对象（默认放入model中，名称即类型的首字母改成小写），视图名默认是请求路径
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/login/{user}" })
	public ModelAndView addRoleContoller(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("user") String user,
			ModelMap modelMap) {
		// 用来接收 视图对象 和 以及请求接收的参数或者响应客户端的数据
		ModelAndView modelAndView = new ModelAndView();

		// 放置请求变量的值 ModelMap本质上是一个java.util.LinkedHashMap<String, Object>的子类
		modelMap.put("loginUser", user);

		modelAndView.setViewName("/login/hello");

		modelAndView.addObject(modelMap);

		TabA a = null;
		TabB b = null;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 999; i++) {
			
			a = new TabA();
			
			a.setId(Long.parseLong(i + ""));
			
			a.setName("aaa");
			
			a.setAddress("address a");

			b = new TabB();
			
			b.setId(Long.parseLong(i + ""));
			
			b.setName("bbb");
			
			b.setAddress("address b");

			Assert.assertNotNull(jotmService);
			
			jotmService.saveAB(a, b);

		}
		log.info("出入 数据 所用时间 ：++++++++++++++++++++++========================"
				+ (System.currentTimeMillis() - startTime));
		return modelAndView;

	}

	@RequestMapping(value = { "/welcome" }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public String redirect() {

		return "/welcome";
	}

}
