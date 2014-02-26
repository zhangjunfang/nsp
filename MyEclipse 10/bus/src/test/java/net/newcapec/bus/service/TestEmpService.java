package net.newcapec.bus.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import net.newcapec.bus.Pagination;
import net.newcapec.bus.ResultMapper;
import net.newcapec.bus.dao.emp.AbstractEmp;
import net.newcapec.bus.service.bo.Emp;
import net.newcapec.bus.service.bo.search.EmpSearch;
import net.newcapec.bus.service.bo.search.Login;
import net.newcapec.bus.service.impl.EmpServiceImpl;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 黄鑫
 *
 */
public class TestEmpService {
	static final Logger log = Logger.getLogger(TestEmpService.class);
	static EmpService _service = null;
	static final SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		_service = (EmpServiceImpl) ctx.getBean("empServiceImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void init() {
		log.info("--------------------");
	}

	@After
	public void destroy() {
	}

	@Test
	public void findEmpById() {
		String empCode = "admin";
		
		String customerUnitCode = "08600000000";

		ResultMapper<Emp> mapper = _service.findEmpById(empCode, customerUnitCode);
		boolean __bool = mapper.getStatus().equals(ResultMapper.SUCCESS);
		if (!__bool) {
			log.info(mapper.getMsg());
			Assert.assertEquals(__bool, true);
		}

		log.info("客户名称：" + mapper.getT().getEmpName());
	}

	@Test
	public void login() {
		Login __login = new Login();
		__login.setLegalPerson("08600000000");
		__login.setUsername("admin");
		__login.setPassword("888888");

		ResultMapper<Emp> __mapper = _service.login(__login);
		boolean __bool = __mapper.getStatus().equals(ResultMapper.SUCCESS);
		if (!__bool) {
			log.info(__mapper.getMsg());
			Assert.assertEquals(__bool, true);
		}

		log.info("客户名称：" + __mapper.getT().getEmpName());
	}

	@Test
	public void findEmpList() {
		Pagination page = new Pagination();
		page.setCurrent(1);
		page.setPageSize(5);

		EmpSearch search = new EmpSearch();
		search.setCustomerUnitCode("08600000000");

		ResultMapper<Emp> __mapper = _service.findEmpList(page, search);
		boolean __bool = __mapper.getStatus().equals(ResultMapper.SUCCESS);
		if (!__bool) {
			log.info(__mapper.getMsg());
			Assert.assertEquals(__bool, true);
		}

		for (Emp __emp_3 : __mapper.getList()) {
			log.info(__emp_3.getEmpCode() + "		" + __emp_3.getIncomeDate());
		}

		log.info("当前：" + page.getCurrent() + " 本页：" + __mapper.getList().size() + " 总数：" + __mapper.getCount());
	}

	@Test
	public void changePwd() {
		Login login = new Login();
		login.setLegalPerson("08600000000");
		login.setUsername("admin");
		login.setPassword("888888");

		String newPwd = "888888";

		ResultMapper<Emp> __mapper = _service.changePwd(login, newPwd);
		boolean __bool = __mapper.getStatus().equals(ResultMapper.SUCCESS);
		if (!__bool) {
			log.info(__mapper.getMsg());
			Assert.assertEquals(__bool, true);
		}
	}

	@Test
	public void test_crud() {
		log.info("测试CRUD开始++++++++++");
		/* 添加客户 */
		this.addEmp();
		this.findEmpList();
		/* 更新客户 */
		this.editEmp();
		/* 删除客户 */
		this.delEmpByIds();
		this.findEmpList();
		log.info("测试CRUD结束++++++++++");
	}

	private void editEmp() {
		Emp emp = new Emp();

		EmpSearch search = new EmpSearch();
		search.setId(0);
		search.setCustomerUnitCode("test001");

		ResultMapper<Emp> __mapper = _service.editEmp(emp, search);
		boolean __bool = __mapper.getStatus().equals(ResultMapper.SUCCESS);
		if (!__bool) {
			log.info(__mapper.getMsg());
			Assert.assertEquals(__bool, true);
		}
	}

	private void addEmp() {
		AbstractEmp emp = new AbstractEmp();
		emp.setAccountType(1);
		emp.setAddress("河南郑州");
		emp.setAreaId(1);
		emp.setBankCardNo("123");
		emp.setBankCode(456);
		emp.setCashCardType("121");
		emp.setCertificateId(1);
		emp.setCheckBeginDay(_sdf.format(new Date()));
		emp.setCheckEndDay(_sdf.format(new Date()));
		/* 唯一 */
		emp.setCustomerUnitCode("test001");
		emp.setDeleteDate(_sdf.format(new Date()));
		emp.setDptCode("121");
		/* 唯一 */
		emp.setEmpCode("huangxin");
		emp.setEmpEmail("3203317@qq.com");
		/* 唯一 */
		emp.setEmpId(0);
		emp.setEmpName("黄鑫");
		emp.setEmpPos("1");
		emp.setEmpPwd("999999");
		emp.setExceptiveEmp(121);
		/* 唯一 */
		emp.setIdCardNo("410102");
		emp.setIncomeDate(_sdf.format(new Date()));
		emp.setIsDelete(0);
		emp.setIsSystemUser(1);
		emp.setLanguage("zh");
		emp.setLoginSt(1);
		emp.setNation("zh");
		emp.setPostId(1);
		emp.setPrivilegeLogon(1);
		emp.setRoleCode("001");
		emp.setSaleCardType("111222");
		emp.setSex(1);
		emp.setStatus(1);
		emp.setTelPhoneNum("138371");
		emp.setThemes("night");
		/* 唯一 */
		emp.setUserId("hx");
		emp.setVer(110);
		emp.setYearCheck(1);

		/* 添加客户 */
		ResultMapper<Emp> __mapper = _service.addEmp(emp);
		boolean __bool = __mapper.getStatus().equals(ResultMapper.SUCCESS);
		if (!__bool) {
			log.info(__mapper.getMsg());
			Assert.assertEquals(__bool, true);
		}
	}

	/**
	 * 删除客户
	 */
	private void delEmpByIds() {
		String customerUnitCode = "test001";

		ResultMapper<Emp> __mapper2 = _service.findEmpById("huangxin", customerUnitCode);
		String __ids = __mapper2.getT().getId() + ",0";

		ResultMapper<Emp> __mapper = _service.delEmpByIds(__ids, customerUnitCode);
		boolean __bool = __mapper.getStatus().equals(ResultMapper.SUCCESS);
		if (!__bool) {
			log.info(__mapper.getMsg());
			Assert.assertEquals(__bool, true);
		}
	}

	@Test
	public void batchAddEmp() {

	}

}
