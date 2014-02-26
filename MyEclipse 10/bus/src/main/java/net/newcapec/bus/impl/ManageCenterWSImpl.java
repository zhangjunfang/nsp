package net.newcapec.bus.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import net.newcapec.bus.ManageCenterWS;
import net.newcapec.bus.Pagination;
import net.newcapec.bus.ResultMapper;
import net.newcapec.bus.dao.emp.AbstractEmp;
import net.newcapec.bus.service.EmpService;
import net.newcapec.bus.service.RoleService;
import net.newcapec.bus.service.UserService;
import net.newcapec.bus.service.bo.Emp;
import net.newcapec.bus.service.bo.Role;
import net.newcapec.bus.service.bo.User;
import net.newcapec.bus.service.bo.search.EmpSearch;
import net.newcapec.bus.service.bo.search.Login;
import net.newcapec.bus.service.bo.search.RoleSearch;

import org.apache.log4j.Logger;

/**
 *
 * @author 黄鑫
 *
 */
@WebService(endpointInterface = "net.newcapec.bus.ManageCenterWS", serviceName = "ManageCenterWS")
public class ManageCenterWSImpl implements ManageCenterWS {

	static final Logger _log = Logger.getLogger(ManageCenterWSImpl.class);

	@Resource(name = "userServiceImpl")
	UserService userService;

	@Resource(name = "userServiceImpl2")
	UserService userService2;

	@Resource(name = "roleServiceImpl")
	RoleService roleService;

	@Resource(name = "empServiceImpl")
	EmpService empService;

	@Override
	public Role insertRole(Role role) {
		Role __role = role;
		__role.setRoleName("SUPER");

		return __role;
	}

	@Override
	public int deleteRole() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> findRoleList(Pagination page, RoleSearch search) {
		List<Role> __list = this.roleService.findRoleList(page, search);
		return __list;
	}

	@Override
	public User userLogin(Login login) {
		System.out.println(this.userService2);
		User __user = this.userService.login(login);
		return __user;
	}

	@Override
	public ResultMapper<Emp> empLogin(Login login) {
		ResultMapper<Emp> __mapper = null;
		try {
			__mapper = this.empService.login(login);
		} catch (Exception e) {
			__mapper = new ResultMapper<Emp>();
			__mapper.setMsg(e.getMessage());
			_log.error(e.getMessage());
		}
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> findEmpList(Pagination page, EmpSearch search) {
		ResultMapper<Emp> __mapper = null;
		try {
			__mapper = this.empService.findEmpList(page, search);
		} catch (Exception e) {
			__mapper = new ResultMapper<Emp>();
			__mapper.setMsg(e.getMessage());
			_log.error(e.getMessage());
		}
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> findEmpById(String empCode, String customerUnitCode) {
		ResultMapper<Emp> __mapper = null;
		try {
			__mapper = this.empService.findEmpById(empCode, customerUnitCode);
		} catch (Exception e) {
			__mapper = new ResultMapper<Emp>();
			__mapper.setMsg(e.getMessage());
			_log.error(e.getMessage());
		}
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> changePwd(Login login, String newPwd) {
		ResultMapper<Emp> __mapper = null;
		try {
			__mapper = this.empService.changePwd(login, newPwd);
		} catch (Exception e) {
			__mapper = new ResultMapper<Emp>();
			__mapper.setMsg(e.getMessage());
			_log.error(e.getMessage());
		}
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> addEmp(AbstractEmp emp) {
		ResultMapper<Emp> __mapper = null;
		try {
			__mapper = this.empService.addEmp(emp);
		} catch (Exception e) {
			__mapper = new ResultMapper<Emp>();
			__mapper.setMsg(e.getMessage());
			_log.error(e.getMessage());
		}
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> delEmpByIds(String ids, String customerUnitCode) {
		ResultMapper<Emp> __mapper = null;
		try {
			__mapper = this.empService.delEmpByIds(ids, customerUnitCode);
		} catch (Exception e) {
			__mapper = new ResultMapper<Emp>();
			__mapper.setMsg(e.getMessage());
			_log.error(e.getMessage());
		}
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> editEmp(AbstractEmp emp, EmpSearch search) {
		ResultMapper<Emp> __mapper = null;
		try {
			__mapper = this.empService.editEmp(emp, search);
		} catch (Exception e) {
			__mapper = new ResultMapper<Emp>();
			__mapper.setMsg(e.getMessage());
			_log.error(e.getMessage());
		}
		return __mapper;
	}

}
