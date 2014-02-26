package net.newcapec.bus.service.impl;

import net.newcapec.bus.service.UserService;
import net.newcapec.bus.service.bo.User;
import net.newcapec.bus.service.bo.search.Login;

import org.springframework.stereotype.Service;

/**
 *
 * @author 黄鑫
 *
 */
@Service
public class UserServiceImpl implements UserService {

	public User login(Login login) {
		User __user = new User();
		__user.setUsername("hx");
		__user.setRealname("黄鑫21");
		return __user;
	}

}
