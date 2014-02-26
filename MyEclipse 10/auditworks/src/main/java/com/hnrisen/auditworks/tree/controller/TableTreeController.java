/**
 * 
 */
package com.hnrisen.auditworks.tree.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.hnrisen.auditworks.domain.tree.Tree;
import com.hnrisen.auditworks.util.Column;
import com.hnrisen.auditworks.util.DatabaseMetaDataOcean;
import com.hnrisen.auditworks.util.TableMeteData;

/**
 * @author ： ocean date ：2012-4-20
 */
@Controller
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TableTreeController implements Serializable {
	
	private Log log = LogFactory.getLog(getClass());
	
	private static final long serialVersionUID = 8566732447804442376L;

	
	@Resource(name = "tableMeteData")
	TableMeteData tableMeteData;
	
	@Resource(name = "databaseMetaDataOcean")
	private DatabaseMetaDataOcean databaseMetaDataOcean;
	
	
	@RequestMapping(value = "/tableTree", method = RequestMethod.POST)
	public @ResponseBody
	Tree [] getTreeList() {
	
		log.info("加载用户表名称以及表对应的元数据");
		
		
		
		List<String> lists = databaseMetaDataOcean.getTableOfDatabaseMetaData();
		
		Tree tree = null;
		
		
		String tableName = null;
		
		Tree [] trees = new Tree[lists.size()];
		
		for ( int i = 0 ; i < lists.size() ; i++ ) {
			
			tableName = lists.get(i);
			
			tree = new Tree();
			
			tree.setId(i + "");
			
			tree.setpId("0001");
			
			tree.setName(tableName);
			
			tree.setT(tableName);
			
			trees[i] = tree;
			
		}
		
		return trees;
		
	}
	
	@RequestMapping(value = "/tableColumn", method = RequestMethod.POST)
	public @ResponseBody String getTableColumn(WebRequest request) {
	
		log.info("加载一个表所有的列");
		
		//List<Column> columns = tableMeteData.getTableMeteData01("  select  * from  "+ request.getParameter("name"));
		List<Column> columns = tableMeteData.getTableMeteData02(request.getParameter("name"));
		StringBuffer stringBuffer=new StringBuffer();
		
		for (Column column :columns ) {
			
			stringBuffer.append(column.getColumnName()+":");
		}
		
		return stringBuffer.toString();
		
	}
	
}
