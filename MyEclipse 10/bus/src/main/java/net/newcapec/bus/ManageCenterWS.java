package net.newcapec.bus;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import net.newcapec.bus.dao.emp.AbstractEmp;
import net.newcapec.bus.service.bo.Emp;
import net.newcapec.bus.service.bo.Role;
import net.newcapec.bus.service.bo.User;
import net.newcapec.bus.service.bo.search.EmpSearch;
import net.newcapec.bus.service.bo.search.Login;
import net.newcapec.bus.service.bo.search.RoleSearch;

/**
 *
 * @author 黄鑫
 *
 */
@WebService
// @SOAPBinding(style = Style.RPC)
public interface ManageCenterWS {

	/**
	 * 用户登陆
	 *
	 * @param login
	 * @return 用户信息
	 */
	@WebMethod(operationName = "UserLogin")
	User userLogin(@WebParam(name = "login") Login login);

	/****************************************************************************************************************/

	/**
	 * 客户登陆
	 *
	 * @param login
	 * @return 用户信息
	 */
	@WebMethod(operationName = "EmpLogin")
	ResultMapper<Emp> empLogin(@WebParam(name = "login") Login login);

	/**
	 * 查找客户信息列表
	 *
	 * @param page
	 * @param search
	 * @return 客户信息列表
	 */
	@WebMethod(operationName = "FindEmpList")
	ResultMapper<Emp> findEmpList(@WebParam(name = "page") Pagination page, @WebParam(name = "search") EmpSearch search);

	/**
	 * 通过主键查找单条客户信息
	 *
	 * @param empCode
	 * @param customerUnitCode
	 * @return
	 */
	@WebMethod(operationName = "FindEmpById")
	ResultMapper<Emp> findEmpById(@WebParam(name = "empCode") String empCode, @WebParam(name = "customerUnitCode") String customerUnitCode);

	/**
	 * 修改客户密码
	 *
	 * @param login
	 * @param newPwd
	 * @return
	 */
	@WebMethod(operationName = "ChangePwd")
	ResultMapper<Emp> changePwd(@WebParam(name = "login") Login login, @WebParam(name = "newPwd") String newPwd);

	/**
	 * 新增客户
	 *
	 * @param emp
	 * @return
	 */
	@WebMethod(operationName = "AddEmp")
	ResultMapper<Emp> addEmp(@WebParam(name = "emp") AbstractEmp emp);

	/**
	 * 删除客户ByIds
	 *
	 * @param ids
	 *            逗号分割的字符串id
	 * @param customerUnitCode
	 * @return
	 */
	@WebMethod(operationName = "DelEmpByIds")
	public ResultMapper<Emp> delEmpByIds(@WebParam(name = "ids") String ids, @WebParam(name = "customerUnitCode") String customerUnitCode);

	/**
	 * 更新客户信息
	 *
	 * @param emp
	 * @param search
	 * @return
	 */
	@WebMethod(operationName = "EditEmp")
	public ResultMapper<Emp> editEmp(@WebParam(name = "emp") AbstractEmp emp, @WebParam(name = "search") EmpSearch search);

	/****************************************************************************************************************/

	/**
	 * 添加角色
	 *
	 * @return
	 */
	@WebMethod(operationName = "InsertRole")
	Role insertRole(@WebParam(name = "role") Role role);

	@WebMethod(operationName = "DeleteRole")
	int deleteRole();

	@WebMethod(operationName = "FindRoleList")
	List<Role> findRoleList(@WebParam(name = "page") Pagination page, @WebParam(name = "search") RoleSearch search);

	/****************************************************************************************************************/
}
