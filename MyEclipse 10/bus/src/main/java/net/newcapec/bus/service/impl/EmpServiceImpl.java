package net.newcapec.bus.service.impl;

import java.security.MessageDigest;
import java.util.List;

import javax.annotation.Resource;

import net.newcapec.bus.Pagination;
import net.newcapec.bus.ResultMapper;
import net.newcapec.bus.dao.emp.AbstractEmp;
import net.newcapec.bus.dao.emp.EmpDao;
import net.newcapec.bus.dao.sequence.SequenceDao;
import net.newcapec.bus.service.AbstractService;
import net.newcapec.bus.service.EmpService;
import net.newcapec.bus.service.bo.Emp;
import net.newcapec.bus.service.bo.Sequence;
import net.newcapec.bus.service.bo.search.EmpSearch;
import net.newcapec.bus.service.bo.search.Login;
import net.newcapec.bus.service.bo.search.SequenceSearch;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户服务实现
 *
 * @author 黄鑫
 *
 */
@SuppressWarnings("restriction")
@Service
public class EmpServiceImpl extends AbstractService implements EmpService {

	static final Logger _log = Logger.getLogger(EmpServiceImpl.class);

	@Resource
	EmpDao empDao;

	@Resource
	SequenceDao sequenceDao;

	/**
	 * 新密码输入格式错误
	 */
	final static String EmpServiceImpl_changePwd_1 = "EmpServiceImpl_changePwd_1";
	/**
	 * 找不到该用户或原始密码输入错误
	 */
	final static String EmpServiceImpl_changePwd_2 = "EmpServiceImpl_changePwd_2";

	/**
	 * MD5
	 *
	 * @param $str
	 * @return
	 */
	private static String toMD5(String $str) {
		char[] __hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] __strTemp_3 = $str.getBytes();
			MessageDigest __messageDigest_3 = MessageDigest.getInstance("MD5");
			__messageDigest_3.update(__strTemp_3);
			byte[] __md_3 = __messageDigest_3.digest();
			int __j_3 = __md_3.length;
			char[] __str_3 = new char[__j_3 * 2];
			int __i_4 = 0;
			for (int __k_4 = 0; __i_4 < __j_3; ++__i_4) {
				byte byte0 = __md_3[__i_4];
				__str_3[(__k_4++)] = __hexDigits[(byte0 >>> 4 & 0xF)];
				__str_3[(__k_4++)] = __hexDigits[(byte0 & 0xF)];
			}
			return new String(__str_3);
		} catch (Exception $ex) {
		}
		return null;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public ResultMapper<Emp> login(Login login) {
		_log.info("客户登陆");
		ResultMapper<Emp> __mapper = new ResultMapper<Emp>();
		/* 参数验证 */
		if (login.getLegalPerson() == null) {
			__mapper.setMsg("客户编号不能为空！");
			return __mapper;
		} else {
			login.setLegalPerson(login.getLegalPerson().trim());
			if ("".equals(login.getLegalPerson())) {
				__mapper.setMsg("客户编号不能为空！");
				return __mapper;
			}
		}
		if (login.getUsername() == null) {
			__mapper.setMsg("客户名不能为空！");
			return __mapper;
		} else {
			login.setUsername(login.getUsername().trim());
			if ("".equals(login.getUsername())) {
				__mapper.setMsg("客户名不能为空！");
				return __mapper;
			}
		}
		if (login.getPassword() == null) {
			__mapper.setMsg("密码不能为空！");
			return __mapper;
		} else {
			login.setPassword(login.getPassword().trim());
			if ("".equals(login.getPassword())) {
				__mapper.setMsg("密码不能为空！");
				return __mapper;
			}
		}
		/* 参数验证 */

		/* bo到dao的对象中转 */
		EmpSearch __search = new EmpSearch();
		__search.setEmpCode(login.getUsername());
		__search.setCustomerUnitCode(login.getLegalPerson());

		Emp __emp = this.empDao.queryById(__search);

		/* 找不到一条记录 */
		if (__emp == null) {
			__mapper.setMsg("找不到该客户信息");
			return __mapper;
		}

		/* 判断密码是否正确 */
		if (!__emp.getEmpPwd().equals(toMD5(login.getPassword()))) {
			__mapper.setMsg("输入的密码有误，请重试！");
			return __mapper;
		}

		__emp.setEmpPwd(null);
		__mapper.setT(__emp);

		__mapper.setStatus(ResultMapper.SUCCESS);
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> findEmpList(Pagination page, EmpSearch search) {
		_log.info("查询客户记录byAll");
		ResultMapper<Emp> __mapper = new ResultMapper<Emp>();
		/* 参数验证 */
		if (search.getCustomerUnitCode() == null) {
			__mapper.setMsg("客户单位编号不能为空！");
			return __mapper;
		} else {
			search.setCustomerUnitCode(search.getCustomerUnitCode().trim());
			if ("".equals(search.getCustomerUnitCode())) {
				__mapper.setMsg("客户单位编号不能为空！");
				return __mapper;
			}
		}
		/* 参数验证 */

		int __count = this.empDao.queryAllCount(search);
		List<Emp> __list = this.empDao.queryAll(page, search);

		__mapper.setCount(__count);
		__mapper.setList(__list);

		__mapper.setStatus(ResultMapper.SUCCESS);
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> findEmpById(String empCode, String customerUnitCode) {
		_log.info("查询客户记录by主键");
		ResultMapper<Emp> __mapper = new ResultMapper<Emp>();

		/* 参数验证 */
		String __empCode = null;
		if (empCode == null) {
			__mapper.setMsg("客户编号不能为空！");
			return __mapper;
		} else {
			__empCode = empCode.trim();
			if ("".equals(__empCode)) {
				__mapper.setMsg("客户编号不能为空！");
				return __mapper;
			}
		}
		String __customerUnitCode = null;
		if (customerUnitCode == null) {
			__mapper.setMsg("客户单位编号不能为空！");
			return __mapper;
		} else {
			__customerUnitCode = customerUnitCode.trim();
			if ("".equals(__customerUnitCode)) {
				__mapper.setMsg("客户单位编号不能为空！");
				return __mapper;
			}
		}
		/* 参数验证 */

		EmpSearch __search = new EmpSearch();
		__search.setEmpCode(__empCode);
		__search.setCustomerUnitCode(__customerUnitCode);

		Emp __emp = this.empDao.queryById(__search);

		/* 找不到一条记录 */
		if (__emp == null) {
			__mapper.setMsg("找不到该客户信息");
			return __mapper;
		}
		__mapper.setT(__emp);

		__mapper.setStatus(ResultMapper.SUCCESS);
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> changePwd(Login login, String newPwd) {
		_log.info("客户密码修改");
		ResultMapper<Emp> __mapper = new ResultMapper<Emp>();
		/* 参数验证 */
		String __newPwd = null;
		if (newPwd == null) {
			__mapper.setMsg("新密码不能为空！");
			return __mapper;
		} else {
			__newPwd = newPwd.trim();
			/* 验证密码长度等等 */
			if ("".equals(__newPwd)) {
				__mapper.setMsg(getMessage(EmpServiceImpl_changePwd_1));
				return __mapper;
			}
		}
		if (login.getLegalPerson() == null) {
			__mapper.setMsg("客户编号不能为空！");
			return __mapper;
		} else {
			login.setLegalPerson(login.getLegalPerson().trim());
			if ("".equals(login.getLegalPerson())) {
				__mapper.setMsg("客户编号不能为空！");
				return __mapper;
			}
		}
		if (login.getUsername() == null) {
			__mapper.setMsg("客户名不能为空！");
			return __mapper;
		} else {
			login.setUsername(login.getUsername().trim());
			if ("".equals(login.getUsername())) {
				__mapper.setMsg("客户名不能为空！");
				return __mapper;
			}
		}
		if (login.getPassword() == null) {
			__mapper.setMsg("密码不能为空！");
			return __mapper;
		} else {
			login.setPassword(login.getPassword().trim());
			if ("".equals(login.getPassword())) {
				__mapper.setMsg("密码不能为空！");
				return __mapper;
			}
		}
		/* 参数验证 */

		/* 验证原始密码是否正确 */
		EmpSearch __search = new EmpSearch();
		__search.setEmpCode(login.getUsername());
		__search.setCustomerUnitCode(login.getLegalPerson());

		Emp __emp = this.empDao.queryById(__search);
		if (__emp == null) {
			__mapper.setMsg("找不到该客户信息");
			return __mapper;
		}
		if (!__emp.getEmpPwd().equals(toMD5(login.getPassword()))) {
			__mapper.setMsg("输入的原始密码有误，请重试！");
			return __mapper;
		}
		/* 验证原始密码是否正确 */

		/* 更新密码操作 */
		AbstractEmp __empPo = new AbstractEmp();
		__empPo.setEmpPwd(toMD5(__newPwd));
		__search = new EmpSearch();
		__search.setId(__emp.getId());
		this.empDao.update(__empPo, __search);
		/* 更新密码操作 */

		__mapper.setStatus(ResultMapper.SUCCESS);
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> addEmp(AbstractEmp emp) {
		_log.info("添加客户");
		ResultMapper<Emp> __mapper = new ResultMapper<Emp>();
		/* 参数验证 */
		if (emp.getCustomerUnitCode() == null) {
			__mapper.setMsg("客户编号不能为空！");
			return __mapper;
		} else {
			emp.setCustomerUnitCode(emp.getCustomerUnitCode().trim());
			if ("".equals(emp.getCustomerUnitCode())) {
				__mapper.setMsg("客户编号不能为空！");
				return __mapper;
			}
		}
		if (emp.getEmpCode() == null) {
			__mapper.setMsg("客户编号不能为空！");
			return __mapper;
		} else {
			emp.setEmpCode(emp.getEmpCode().trim());
			if ("".equals(emp.getEmpCode())) {
				__mapper.setMsg("客户编号不能为空！");
				return __mapper;
			}
		}
		if (emp.getUserId() == null) {
			__mapper.setMsg("客户工号不能为空！");
			return __mapper;
		} else {
			emp.setUserId(emp.getUserId().trim());
			if ("".equals(emp.getUserId())) {
				__mapper.setMsg("客户工号不能为空！");
				return __mapper;
			}
		}
		if (emp.getIdCardNo() == null) {
			__mapper.setMsg("证件号码不能为空！");
			return __mapper;
		} else {
			emp.setIdCardNo(emp.getIdCardNo().trim());
			if ("".equals(emp.getIdCardNo())) {
				__mapper.setMsg("证件号码不能为空！");
				return __mapper;
			}
		}
		if (emp.getEmpPwd() == null) {
			__mapper.setMsg("密码不能为空！");
			return __mapper;
		} else {
			emp.setEmpPwd(emp.getEmpPwd().trim());
			if ("".equals(emp.getEmpPwd())) {
				__mapper.setMsg("密码不能为空！");
				return __mapper;
			}
			emp.setEmpPwd(toMD5(emp.getEmpPwd()));
		}
		/* 参数验证 */

		/* 判断客户是否存在 */
		ResultMapper<Emp> __mapper2 = this.checkEmpExist(emp.getEmpCode(), emp.getUserId(), emp.getIdCardNo(), emp.getCustomerUnitCode());
		if (ResultMapper.FAILURE.equals(__mapper2.getStatus())) {
			__mapper.setMsg(__mapper2.getMsg());
			return __mapper;
		}
		/* 判断客户是否存在 */

		/* 添加客户，执行SQL */
		this.empDao.insert(emp);
		/* 添加客户，执行SQL */

		/* 获取序列值 */
		SequenceSearch __search = new SequenceSearch();
		__search.setCode("EmpId");
		__search.setCustomerUnitCode(emp.getCustomerUnitCode());
		Sequence __sequence = this.sequenceDao.queryById(__search);
		/* 获取序列值 */

		/* 最大序列+1 */
		int __max_no = __sequence.getMax_no() + 1;
		/* 更新最大序列 */
		Sequence __sequence2 = new Sequence();
		__sequence2.setMax_no(__max_no);
		SequenceSearch __sequenceSearch = new SequenceSearch();
		__sequenceSearch.setCode("EmpId");
		__sequenceSearch.setCustomerUnitCode(emp.getCustomerUnitCode());
		this.sequenceDao.update(__sequence2, __sequenceSearch);

		/* 更新empId */
		Emp __emp = new Emp();
		__emp.setEmpId(__max_no);
		EmpSearch __empSearch = new EmpSearch();
		__empSearch.setCustomerUnitCode(emp.getCustomerUnitCode());
		__empSearch.setEmpCode(emp.getEmpCode());
		__empSearch.setUserId(emp.getUserId());
		__empSearch.setIdCardNo(emp.getIdCardNo());
		this.empDao.update(__emp, __empSearch);

		__mapper.setStatus(ResultMapper.SUCCESS);
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> batchAddEmp(List<Emp> list) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 判断客户（主键等）信息是否存在，添加客户信息前的验证
	 *
	 * @param empCode
	 * @param userId
	 * @param idCardNo
	 * @param customerUnitCode
	 * @return
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	private ResultMapper<Emp> checkEmpExist(String empCode, String userId, String idCardNo, String customerUnitCode) {
		ResultMapper<Emp> __mapper = new ResultMapper<Emp>();
		EmpSearch __search = new EmpSearch();
		__search.setIsDelete(0);
		__search.setCustomerUnitCode(customerUnitCode);
		__search.setAppendSql("( t.empCode='" + empCode + "' or t.userId='" + userId + "' or t.idCardNo='" + idCardNo + "' )");

		List<Emp> __list = this.empDao.queryAll(new Pagination(), __search);
		int __count = __list.size();

		if (__count == 3) {
			__mapper.setMsg("客户信息已存在，请重新填写！");
			return __mapper;
		} else if (__count == 0) {
			__mapper.setStatus(ResultMapper.SUCCESS);
			return __mapper;
		}

		/* 计算哪个字段无人注册 */
		for (Emp __emp_3 : __list) {
			if (empCode.equals(__emp_3.getEmpCode())) {
				__mapper.setMsg("操作员编号已存在，请重新填写！");
				break;
			}
			if (userId.equals(__emp_3.getUserId())) {
				__mapper.setMsg("客户工号已存在，请重新填写！");
				break;
			}
			if (idCardNo.equals(__emp_3.getIdCardNo())) {
				__mapper.setMsg("证件已存在，请重新填写！");
				break;
			}
		}

		return __mapper;
	}

	@Override
	public ResultMapper<Emp> delEmpByIds(String ids, String customerUnitCode) {
		_log.info("删除客户记录by主键");
		ResultMapper<Emp> __mapper = new ResultMapper<Emp>();
		/* 参数验证 */
		String __ids = null;
		if (ids == null) {
			__mapper.setMsg("客户主键不能为空！");
			return __mapper;
		} else {
			__ids = ids.trim();
			if ("".equals(__ids)) {
				__mapper.setMsg("客户主键不能为空！");
				return __mapper;
			}
		}
		String __customerUnitCode = null;
		if (customerUnitCode == null) {
			__mapper.setMsg("客户编号不能为空！");
			return __mapper;
		} else {
			__customerUnitCode = customerUnitCode.trim();
			if ("".equals(__customerUnitCode)) {
				__mapper.setMsg("客户编号不能为空！");
				return __mapper;
			}
		}
		/* 参数验证 */

		/* 创建参数 */
		String[] __strs = ids.split(",");
		Long[] __longs = new Long[__strs.length];
		for (int __i_3 = 0, __j_3 = __longs.length; __i_3 < __j_3; __i_3++) {
			__longs[__i_3] = Long.valueOf(__strs[__i_3]);
		}
		EmpSearch __search = new EmpSearch();
		__search.setIds(__longs);
		__search.setCustomerUnitCode(__customerUnitCode);
		/* 创建参数 */

		int __count = this.empDao.delete(__search);

		__mapper.setCount(__count);

		__mapper.setStatus(ResultMapper.SUCCESS);
		return __mapper;
	}

	@Override
	public ResultMapper<Emp> editEmp(AbstractEmp emp, EmpSearch search) {
		_log.info("编辑客户记录ById");
		ResultMapper<Emp> __mapper = new ResultMapper<Emp>();

		/* 参数验证 */
		if (search.getId() == null) {
			__mapper.setMsg("客户主键不能为空！");
			return __mapper;
		}
		if (search.getCustomerUnitCode() == null) {
			__mapper.setMsg("客户编号不能为空！");
			return __mapper;
		} else {
			search.setCustomerUnitCode(search.getCustomerUnitCode().trim());
			if ("".equals(search.getCustomerUnitCode())) {
				__mapper.setMsg("客户编号不能为空！");
				return __mapper;
			}
		}

		// this.empDao.update(emp, search);

		__mapper.setStatus(ResultMapper.SUCCESS);
		return __mapper;
	}
}
