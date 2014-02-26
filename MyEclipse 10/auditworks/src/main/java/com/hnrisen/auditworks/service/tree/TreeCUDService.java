/**
 * 
 */
package com.hnrisen.auditworks.service.tree;

import java.io.Serializable;


/**
 * @author ： ocean
 *  date ：2012-5-14
 */
public interface TreeCUDService<T> extends Serializable {
	
	  void 	insertTree(T t);
	  void 	updateTree(T t);
	  void 	deleteTree(T t);
	
}
