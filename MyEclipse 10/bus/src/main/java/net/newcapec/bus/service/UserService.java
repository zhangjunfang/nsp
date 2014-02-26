package net.newcapec.bus.service;

import net.newcapec.bus.service.bo.User;
import net.newcapec.bus.service.bo.search.Login;

import org.springframework.stereotype.Service;

/**
 *
 * @author 黄鑫
 *
 */
@Service
public interface UserService extends IService {

	/**
	 * 用户登陆
	 *
	 * @param login
	 * @return 用户对象
	 */
	User login(Login login);
}
