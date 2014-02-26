/**
 * 
 */
package com.hnrisen.auditworks.service.tree.constant;

import java.io.Serializable;


/**
 * @author ： ocean
 *  date ：2012-4-29
 */
public interface TreeConstant extends Serializable {
	
	String DEPARTMENT_SQL=" select cap_department.DEPARTMENT_ID,cap_department.PARENT_ID,cap_department.DEPARTMENT_NAME  from cap_department   ";
	
}
