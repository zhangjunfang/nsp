package net.newcapec.bus.dao.emp;

import net.newcapec.bus.dao.IDao;
import net.newcapec.bus.service.bo.Emp;
import net.newcapec.bus.service.bo.search.EmpSearch;

import org.springframework.stereotype.Component;

/**
 *
 * @author 黄鑫
 *
 */
@Component
public interface EmpDao extends IDao<Emp, AbstractEmp, EmpSearch> {

}
