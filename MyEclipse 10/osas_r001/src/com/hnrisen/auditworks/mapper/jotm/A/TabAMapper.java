/**
 * 
 */
package com.hnrisen.auditworks.mapper.jotm.A;

import java.io.Serializable;

import javax.annotation.Resource;

import com.hnrisen.auditworks.jotm.domain.TabA;

/**
 * @author ocean
 *
 */
@Resource
public interface TabAMapper {

	void insert(TabA tabA);
	void update(TabA tabA);
	void deleteById(Serializable id);
	TabA findById(Serializable id);
	
}
