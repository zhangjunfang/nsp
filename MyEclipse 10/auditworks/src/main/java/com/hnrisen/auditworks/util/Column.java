/**
 * 
 */
package com.hnrisen.auditworks.util;

import java.io.Serializable;
import java.util.Comparator;

import org.springframework.util.Assert;

/**
 * @author ： ocean date ：2012-5-10
 */
public class Column implements Serializable, Comparator<Column> {
	
	private static final long serialVersionUID = -1854768383269231973L;
	
	private String columnLabel;
	
	private String columnName;
	
	private String schemaName;
	
	private String tableName;
	
	private String catalogName;
	
	private String columnTypeName;
	
	private String columnClassName;
	
	private int ColumnDisplaySize;
	

	public int getColumnDisplaySize() {
	
		return ColumnDisplaySize;
	}


	public void setColumnDisplaySize(int columnDisplaySize) {
	
		ColumnDisplaySize = columnDisplaySize;
	}

	private int columnCount;
	
	private int nullable;
	
	private int precision;
	
	private int scale;
	
	private int columnType;
	
	private boolean signed;
	
	private boolean autoIncrement;
	
	private boolean caseSensitive;
	
	private boolean searchable;
	
	private boolean currency;
	
	private boolean readOnly;
	
	private boolean writable;
	
	private boolean definitelyWritable;
	
	public String getColumnLabel() {
	
		return columnLabel;
	}
	
	public void setColumnLabel(String columnLabel) {
	
		this.columnLabel = columnLabel;
	}
	
	public String getColumnName() {
	
		return columnName;
	}
	
	public void setColumnName(String columnName) {
	
		this.columnName = columnName;
	}
	
	public String getSchemaName() {
	
		return schemaName;
	}
	
	public void setSchemaName(String schemaName) {
	
		this.schemaName = schemaName;
	}
	
	public String getTableName() {
	
		return tableName;
	}
	
	public void setTableName(String tableName) {
	
		this.tableName = tableName;
	}
	
	public String getCatalogName() {
	
		return catalogName;
	}
	
	public void setCatalogName(String catalogName) {
	
		this.catalogName = catalogName;
	}
	
	public String getColumnTypeName() {
	
		return columnTypeName;
	}
	
	public void setColumnTypeName(String columnTypeName) {
	
		this.columnTypeName = columnTypeName;
	}
	
	public String getColumnClassName() {
	
		return columnClassName;
	}
	
	public void setColumnClassName(String columnClassName) {
	
		this.columnClassName = columnClassName;
	}
	
	public int getColumnCount() {
	
		return columnCount;
	}
	
	public void setColumnCount(int columnCount) {
	
		this.columnCount = columnCount;
	}
	
	public int getNullable() {
	
		return nullable;
	}
	
	public void setNullable(int nullable) {
	
		this.nullable = nullable;
	}
	
	public int getPrecision() {
	
		return precision;
	}
	
	public void setPrecision(int precision) {
	
		this.precision = precision;
	}
	
	public int getScale() {
	
		return scale;
	}
	
	public void setScale(int scale) {
	
		this.scale = scale;
	}
	
	public int getColumnType() {
	
		return columnType;
	}
	
	public void setColumnType(int columnType) {
	
		this.columnType = columnType;
	}
	
	public boolean isSigned() {
	
		return signed;
	}
	
	public void setSigned(boolean signed) {
	
		this.signed = signed;
	}
	
	public boolean isAutoIncrement() {
	
		return autoIncrement;
	}
	
	public void setAutoIncrement(boolean autoIncrement) {
	
		this.autoIncrement = autoIncrement;
	}
	
	public boolean isCaseSensitive() {
	
		return caseSensitive;
	}
	
	public void setCaseSensitive(boolean caseSensitive) {
	
		this.caseSensitive = caseSensitive;
	}
	
	public boolean isSearchable() {
	
		return searchable;
	}
	
	public void setSearchable(boolean searchable) {
	
		this.searchable = searchable;
	}
	
	public boolean isCurrency() {
	
		return currency;
	}
	
	public void setCurrency(boolean currency) {
	
		this.currency = currency;
	}
	
	public boolean isReadOnly() {
	
		return readOnly;
	}
	
	public void setReadOnly(boolean readOnly) {
	
		this.readOnly = readOnly;
	}
	
	public boolean isWritable() {
	
		return writable;
	}
	
	public void setWritable(boolean writable) {
	
		this.writable = writable;
	}
	
	public boolean isDefinitelyWritable() {
	
		return definitelyWritable;
	}
	
	public void setDefinitelyWritable(boolean definitelyWritable) {
	
		this.definitelyWritable = definitelyWritable;
	}
	
	@Override
	public int compare(Column o1, Column o2) {
	
		Assert.notNull(o1);
		
		Assert.notNull(o2);
		
		return o1.getColumnName().compareTo(o2.getColumnName());
		
	}
	
	@Override
	public int hashCode() {
	
		final int prime = 31;
		
		int result = 1;
		
		result = prime * result + ((columnName == null) ? 0 : columnName.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
	
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Column other = (Column) obj;
		if (columnName != other.columnName) {
			return false;
		}
		
		return true;
	}



	@Override
	public String toString() {
	
		return "{columnLabel:" + columnLabel + ", columnName:" + columnName
				+ ", schemaName:" + schemaName + ", tableName:" + tableName + ", catalogName:"
				+ catalogName + ", columnTypeName:" + columnTypeName + ", columnClassName:"
				+ columnClassName + ", ColumnDisplaySize:" + ColumnDisplaySize + ", columnCount:"
				+ columnCount + ", nullable:" + nullable + ", precision:" + precision + ", scale:"
				+ scale + ", columnType:" + columnType + ", signed:" + signed + ", autoIncrement:"
				+ autoIncrement + ", caseSensitive:" + caseSensitive + ", searchable:" + searchable
				+ ", currency:" + currency + ", readOnly:" + readOnly + ", writable:" + writable
				+ ", definitelyWritable:" + definitelyWritable + "}";
	}
	
	
	
}
