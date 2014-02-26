package net.newcapec.bus.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.newcapec.bus.Pagination;
import net.newcapec.bus.service.RoleService;
import net.newcapec.bus.service.bo.Role;
import net.newcapec.bus.service.bo.search.RoleSearch;

import org.springframework.stereotype.Service;

/**
 *
 * @author 黄鑫
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public List<Role> findRoleList(Pagination page, RoleSearch search) {
		List<Role> __roles = new ArrayList<Role>();

		Role __r1 = new Role();
		__r1.setRoleName("超级管理员");
		__roles.add(__r1);

		__r1 = new Role();
		__r1.setRoleName("游客");
		__roles.add(__r1);

		return __roles;
	}

}
