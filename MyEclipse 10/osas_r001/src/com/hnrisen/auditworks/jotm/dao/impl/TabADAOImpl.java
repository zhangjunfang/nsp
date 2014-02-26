package com.hnrisen.auditworks.jotm.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hnrisen.auditworks.jotm.dao.TabADAO;
import com.hnrisen.auditworks.jotm.domain.TabA;
import com.hnrisen.auditworks.mapper.jotm.A.TabAMapper;

/**
 * 
 */

/**
 * @author ocean
 * 
 */
@Repository
public class TabADAOImpl implements TabADAO {

	@Resource(name="tabAMapper")
	private TabAMapper mapper;

	/**
	 * 保存一个TabA对象
	 * 
	 * @param tabA
	 *            TabA对象
	 * @return 返回保存后的对象
	 */
	public TabA saveTabA(TabA tabA) {
		mapper.insert(tabA);
		tabA.setId(tabA.getId());
		return tabA;
	}

	/**
	 * 更新一个TabA
	 * 
	 * @param tabA
	 *            TabA对象
	 * @return 返回更新后的对象
	 */
	public TabA updateTabA(TabA tabA) {
		mapper.update(tabA);
		return tabA;
	}

	/**
	 * 删除指定标识的一个TabA
	 * 
	 * @param id
	 *            TabA标识
	 */
	public void deleteTabAById(Long id) {
		mapper.deleteById(id);
	}

	/**
	 * 获取指定标识的TabA
	 * 
	 * @param id
	 *            TabA标识
	 * @return 所查询到的TabA
	 */
	public TabA findTabAById(Long id) {
		return mapper.findById(id);
	}
}