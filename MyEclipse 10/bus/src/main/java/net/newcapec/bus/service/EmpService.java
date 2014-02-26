package net.newcapec.bus.service;

import java.util.List;

import net.newcapec.bus.Pagination;
import net.newcapec.bus.ResultMapper;
import net.newcapec.bus.dao.emp.AbstractEmp;
import net.newcapec.bus.service.bo.Emp;
import net.newcapec.bus.service.bo.search.EmpSearch;
import net.newcapec.bus.service.bo.search.Login;

import org.springframework.stereotype.Service;

/**
 * 客户服务接口
 *
 * @author 黄鑫
 *
 */
@Service
public interface EmpService extends IService {

	/**
	 * 客户登陆
	 *
	 * @param login
	 *            用户登陆对象
	 * @return 客户对象
	 */
	ResultMapper<Emp> login(Login login);

	/**
	 * 客户查询
	 *
	 * @param page
	 *            分页
	 * @param search
	 *            查询参数
	 * @return 客户列表
	 */
	ResultMapper<Emp> findEmpList(Pagination page, EmpSearch search);

	/**
	 * 通过主键查找客户
	 *
	 * @param empCode
	 * @param customerUnitCode
	 * @return
	 */
	ResultMapper<Emp> findEmpById(String empCode, String customerUnitCode);

	/**
	 * 修改用户密码 1、验证参数格式 2、验证原始用户密码是否正确 3、更新用户新密码
	 *
	 * @param login
	 * @param newPwd
	 * @return
	 */
	ResultMapper<Emp> changePwd(Login login, String newPwd);

	/**
	 * 添加客户
	 *
	 * @param emp
	 * @return
	 */
	ResultMapper<Emp> addEmp(AbstractEmp emp);

	/**
	 * 批量添加用户
	 *
	 * @param list
	 * @return
	 */
	ResultMapper<Emp> batchAddEmp(List<Emp> list);

	/**
	 * 删除客户
	 *
	 * @param ids
	 * @param customerUnitCode
	 * @return
	 */
	ResultMapper<Emp> delEmpByIds(String ids, String customerUnitCode);

	/**
	 * 修改客户
	 *
	 * @param emp
	 * @param search
	 * @return
	 */
	ResultMapper<Emp> editEmp(AbstractEmp emp, EmpSearch search);
}
