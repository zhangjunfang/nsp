package net.newcapec.bus.service;

import java.util.List;

import net.newcapec.bus.Pagination;
import net.newcapec.bus.service.bo.Role;
import net.newcapec.bus.service.bo.search.RoleSearch;

import org.springframework.stereotype.Service;

/**
 *
 * @author 黄鑫
 *
 */
@Service
public interface RoleService extends IService {

	public List<Role> findRoleList(Pagination page, RoleSearch search);
}
