/**
 * 
 */
package com.hnrisen.auditworks.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
@Component(value="tableMeteData")
public class TableMeteData implements Serializable {
	
	private static final long serialVersionUID = -7996245594721611361L;
	
	private Log log = LogFactory.getLog(getClass());
	
	
	
	private Connection connection=null;
	
	
	
	
	
	public Connection getConnection() {
	
		return connection;
	}

	
	public void setConnection(Connection connection) {
	
		this.connection = connection;
	}

	
	
	public DataSource getDataSource() {
	
		return dataSource;
	}

	
	
	public void setDataSource(DataSource dataSource) {
	
		this.dataSource = dataSource;
	}
	@Resource(name="dataSource")
	private DataSource dataSource;
	
	
	/**
	 * 获取具体一个表，对应元数据
	 * 
	 * @throws SQLException
	 * 
	 * **/
	private List<Column>  getColumnMessage(String sql, Connection connection) throws SQLException {
	
		
		
		List<Column> columns=new ArrayList<Column>(40);
		
		
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		
		int columnSize = resultSetMetaData.getColumnCount();
		
		Column column =null;
		
		
		
		for ( int i = 1 ; i <= columnSize ; i++ ) {
			
			column = new Column();
			
			column.setColumnCount(columnSize);
			
			column.setCatalogName(resultSetMetaData.getCatalogName(i));
			
			column.setColumnClassName(resultSetMetaData.getColumnClassName(i));
			
			column.setColumnDisplaySize(resultSetMetaData.getColumnDisplaySize(i));
			
			column.setColumnLabel(resultSetMetaData.getColumnLabel(i));
			
			column.setColumnName(resultSetMetaData.getColumnName(i));
			
			column.setColumnType(resultSetMetaData.getColumnType(i));
			
			column.setColumnTypeName(resultSetMetaData.getColumnTypeName(i));
			
			column.setPrecision(resultSetMetaData.getPrecision(i));
			
			column.setScale(resultSetMetaData.getScale(i));
			
			column.setSchemaName(resultSetMetaData.getSchemaName(i));
			
			column.setTableName(resultSetMetaData.getTableName(i));
			
			column.setAutoIncrement(resultSetMetaData.isAutoIncrement(i));
			
			column.setCaseSensitive(resultSetMetaData.isCaseSensitive(i));
			
			column.setCurrency(resultSetMetaData.isCurrency(i));
			
			column.setDefinitelyWritable(resultSetMetaData.isDefinitelyWritable(i));
			
			column.setNullable(resultSetMetaData.isNullable(i));
			
			column.setReadOnly(resultSetMetaData.isReadOnly(i));
			
			column.setSearchable(resultSetMetaData.isSearchable(i));
			
			column.setSigned(resultSetMetaData.isSigned(i));
			
			column.setWritable(resultSetMetaData.isWritable(i));
			
			log.info("=============" + column + "============================");
			columns.add(column);
		}
		return columns;
	}
	

	/**
	 * 获取具体一个表，对应元数据
	 * 
	 * @throws SQLException
	 * 
	 * **/
	public List<Column>  getTableMeteData01(String sql) {
	
		try {
			
			Connection connection = dataSource.getConnection();
			
			return getColumnMessage(sql, connection);
			
		} catch ( SQLException e ) {
			
			log.error("！！！！！！=====连接数据库表操作出错了！！！！");
			
			e.printStackTrace();
		}
		return null;
		
	}

	/**
	 * 通过DatabaseMetaData 对象获取表的元数据
	 * 
	 * */
	public List<Column> getTableMeteData02(String tablename) {
	
		try {
			Connection connection = dataSource.getConnection();
			
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			
			
			List<Column> columns=new ArrayList<Column>(40);
			
			/**
			 * 
			 * ，"%"表示所有任意的（字段）
			 * 
			 * **/
			
			ResultSet resultSet = databaseMetaData.getColumns(null, "%", tablename, "%");
			
			Column column = null;
			
			while ( resultSet.next() ) {
				
				column = new Column();
				
				column.setColumnName(resultSet.getString("COLUMN_NAME"));
				
				column.setColumnTypeName(resultSet.getString("TYPE_NAME"));
				
				column.setColumnDisplaySize(resultSet.getInt("COLUMN_SIZE"));
				
				column.setScale(resultSet.getInt("DECIMAL_DIGITS"));
				
				column.setNullable(resultSet.getInt("NULLABLE"));
				
				//log.info(column);
				
				columns.add(column);
			}
			
			return columns;
			
		} catch ( SQLException e ) {
			log.error("！！！！！！=====连接数据库表操作出错了！！！！");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	
}
