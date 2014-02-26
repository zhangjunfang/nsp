package net.newcapec.bus.dao.role;

import net.newcapec.bus.dao.IDao;
import net.newcapec.bus.service.bo.Role;
import net.newcapec.bus.service.bo.search.RoleSearch;

import org.springframework.stereotype.Component;

/**
 *
 * @author 黄鑫
 *
 */
@Component
public interface RoleDao extends IDao<Role, AbstractRole, RoleSearch> {

}
