/**
 * 
 */
package com.hnrisen.auditworks.mapper.batch;

import java.io.Serializable;

import javax.annotation.Resource;



/**
 * @author ： ocean
 *  date ：2012-5-14
 */
@Resource(name="treeMapper")
public interface TreeMapper<T> extends Serializable {
	
  void 	insertTree(T tree);
  void 	updateTree(T tree);
  void 	deleteTree(T tree);
	
}
