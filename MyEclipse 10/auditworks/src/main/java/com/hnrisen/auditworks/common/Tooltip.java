/**
 * 
 */
package com.hnrisen.auditworks.common;

import java.io.Serializable;

import com.hnrisen.auditworks.util.Constant;

/**
 * @author ： ocean date ：2012-4-20
 */
public interface Tooltip extends Serializable {
	
	String DATA_ACCESS_TABLESTRUCTURE_EXCEPTION = Constant.LINE_BREAK
			+ "数据库访问出错了，查询问题途径--详细信息参见MasterMapper.java";
	
}
