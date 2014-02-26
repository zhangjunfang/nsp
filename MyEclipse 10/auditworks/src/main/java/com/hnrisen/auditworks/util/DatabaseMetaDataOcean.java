/**
 * 
 */
package com.hnrisen.auditworks.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @author ： ocean date ：2012-5-10
 */
@Component(value="databaseMetaDataOcean")
public class DatabaseMetaDataOcean implements Serializable {
	
	private static final long serialVersionUID = 2614629616368966975L;
	
	private Log log = LogFactory.getLog(getClass());
	
	
	@Resource(name="dataSource")
	private DataSource dataSource ;
	
	public DataSource getDataSource() {
	
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
	
		this.dataSource = dataSource;
	}
	
	/**
	 * 
	 * 
	 * 获取数据库下用户表
	 * 
	 * 
	 * 
	 * ***/
	
	public List<String> getTableOfDatabaseMetaData() {
	
		List<String> list = new ArrayList<String>(30);
		
		try {
			Connection connection = dataSource.getConnection();
			
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			
			/**
			 * 
			 * "%"就是表示*的意思，也就是任意所有的意思。 其中m_TableName就是要获取的数据表的名字， 如果想获取所有的表的名字，
			 * 就可以使用"%"来作为参数了
			 * 
			 * **/
			
			ResultSet resultSet = databaseMetaData.getTables(null, "%", "%", new String[]{
				"TABLE"
			});
			
			while ( resultSet.next() ) {
				/**
				 * Typical types are "TABLE", "VIEW", "SYSTEM TABLE",
				 * "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM"
				 * 
				 * **/
				String tableName = resultSet.getString("TABLE_NAME");
				//String tableType = resultSet.getString("TABLE_TYPE");
				

				
				list.add(tableName);
				
			}
			
		} catch ( SQLException e ) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * 
	 * 获取数据库下的所有函数
	 * 
	 * oracle无法测试通过【现在没有实现此方法】
	 */
	
	public void getFunctions() {
	
		try {
			
			Connection connection = dataSource.getConnection();
			
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			
			ResultSet resultSet = databaseMetaData.getFunctions(null, "%", "%");
			
			while ( resultSet.next() ) {
				
				String functionName = resultSet.getString("FUNCTION_NAME");
				
				String remarks = resultSet.getString("REMARKS");
				
				short functionType = resultSet.getShort("FUNCTION_TYPE");
				
				log.info("functionName========" + functionName + "====remarks====" + remarks
						+ "====functionType====" + functionType);
				
			}
			
		} catch ( SQLException e ) {
			
			e.printStackTrace();
		}
		
	}
}
