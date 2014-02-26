/**
 * 
 */
package com.hnrisen.auditworks.mapper.jotm.B;

import java.io.Serializable;

import javax.annotation.Resource;

import com.hnrisen.auditworks.jotm.domain.TabB;

/**
 * @author ocean
 *
 */
@Resource
public interface TabBMapper {

    void insert(TabB tabB);  
	void update(TabB tabB);
	void deleteById(Serializable id);
	TabB findById(Serializable id);
	
	
}
