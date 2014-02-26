package com.hnrisen.auditworks.jotm.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hnrisen.auditworks.jotm.dao.TabBDAO;
import com.hnrisen.auditworks.jotm.domain.TabB;
import com.hnrisen.auditworks.mapper.jotm.B.TabBMapper;

/**
 * 
 */

/**
 * @author ocean
 * 
 */
@Repository
public class TabBDAOImpl implements TabBDAO {

	@Resource(name="tabBMapper")
	private TabBMapper mapper;

	/**
	 * 保存一个TabB对象
	 * 
	 * @param tabA
	 *            TabB对象
	 * @return 返回保存后的对象
	 */
	public TabB saveTabB(TabB tabb) {
		mapper.insert(tabb);
		tabb.setId(tabb.getId());
		return tabb;
	}

	/**
	 * 更新一个TabB
	 * 
	 * @param tabA
	 *            TabB对象
	 * @return 返回更新后的对象
	 */
	public TabB updateTabB(TabB tabb) {
		mapper.update(tabb);
		return tabb;
	}

	/**
	 * 删除指定标识的一个TabB
	 * 
	 * @param id
	 *            TabB标识
	 */
	public void deleteTabBById(Long id) {
		mapper.deleteById(id);
	}

	/**
	 * 获取指定标识的TabB
	 * 
	 * @param id
	 *            TabB标识
	 * @return 所查询到的TabB
	 */
	public TabB findTabBById(Long id) {
		return mapper.findById(id);
	}
}