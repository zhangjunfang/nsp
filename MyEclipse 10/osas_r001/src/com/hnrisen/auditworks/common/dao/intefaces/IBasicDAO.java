/**
 * 
 */
package com.hnrisen.auditworks.common.dao.intefaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hnrisen.auditworks.common.domain.BasicDomain;

/**
 * @author ocean date ： 2012-4-12
 */
public interface IBasicDAO<T extends BasicDomain> extends Serializable {
	/**
	 * 通过唯一标示符，返回对象T【领域对象或者模型对象】
	 * 
	 * @param domain
	 *            对象唯一标示符
	 * @return T 唯一标示符对应的对象T【领域对象或者模型对象】
	 * @throws DataAccessException
	 *             数据访问异常【借助spring对数据库访问的异常信息的包装类】： 1.数据源配置的问题 2.数据库连接对象的问题
	 *             3.sql或者JPQL的问题 4.数据提供的问题
	 */
	T selectOne(T domain) throws DataAccessException;

	/**
	 * 查询出来所有的对象T【领域对象或者模型对象】的集合
	 * 
	 * @return 返回对象T【领域对象或者模型对象】的集合
	 * @throws DataAccessException
	 *             数据访问异常【借助spring对数据库访问的异常信息的包装类】： 1.数据源配置的问题 2.数据库连接对象的问题
	 *             3.sql或者JPQL的问题 4.数据提供的问题
	 */
	List<T> selectAll() throws DataAccessException;
	
	
	/**
	 * 查询出来符合条件的对象T【领域对象或者模型对象】的集合
	 * @param start
	 *        从指定的位置开始查询
	 * @param size
	 *        一次加载数据的大小
	 * @return 返回对象T【领域对象或者模型对象】的集合
	 * @throws DataAccessException
	 *             数据访问异常【借助spring对数据库访问的异常信息的包装类】： 1.数据源配置的问题 2.数据库连接对象的问题
	 *             3.sql或者JPQL的问题 4.数据提供的问题
	 */
	List<T> selectAll(int start,int size) throws DataAccessException;
	
	

	/**
	 * 插入一个新建对象T【领域对象或者模型对象】或者对象T【领域对象或者模型对象】 已经存在，则选择更新对象T【领域对象或者模型对象】
	 * 参见方法：void update(T domain) throws DataAccessException;
	 * 
	 * @param domain
	 *            新建对象T【领域对象或者模型对象】
	 * @throws DataAccessException
	 *             数据访问异常【借助spring对数据库访问的异常信息的包装类】： 1.数据源配置的问题 2.数据库连接对象的问题
	 *             3.sql或者JPQL的问题 4.数据提供的问题
	 */
	void insert(T domain) throws DataAccessException;

	/**
	 * 更新一个已经存在的对象T【领域对象或者模型对象】
	 * 
	 * @param domain
	 *            已经存在的对象T【领域对象或者模型对象】
	 * @throws DataAccessException
	 *             数据访问异常【借助spring对数据库访问的异常信息的包装类】： 1.数据源配置的问题 2.数据库连接对象的问题
	 *             3.sql或者JPQL的问题 4.数据提供的问题
	 */
	void update(T domain) throws DataAccessException;
	/**
	 * 更新一个已经存在的对象T【领域对象或者模型对象】的集合
	 * 
	 * @param domain
	 *            已经存在的对象T【领域对象或者模型对象】
	 * @throws DataAccessException
	 *             数据访问异常【借助spring对数据库访问的异常信息的包装类】： 1.数据源配置的问题 2.数据库连接对象的问题
	 *             3.sql或者JPQL的问题 4.数据提供的问题
	 */
	void update(List<T> domain) throws DataAccessException;

	/**
	 * 删除一个已经存在的对象T【领域对象或者模型对象】
	 * 
	 * @param domain
	 *            已经存在的对象T【领域对象或者模型对象】
	 * @throws DataAccessException
	 *             数据访问异常【借助spring对数据库访问的异常信息的包装类】： 1.数据源配置的问题 2.数据库连接对象的问题
	 *             3.sql或者JPQL的问题 4.数据提供的问题
	 */
	void delete(T domain) throws DataAccessException;

	/**
	 * 删除所有对象T【领域对象或者模型对象】
	 * 
	 * @throws DataAccessException
	 *             数据访问异常【借助spring对数据库访问的异常信息的包装类】： 1.数据源配置的问题 2.数据库连接对象的问题
	 *             3.sql或者JPQL的问题 4.数据提供的问题
	 */
	void delete() throws DataAccessException;
	
	/**
	 * 删除对象T的集合【领域对象或者模型对象】
	 * 
	 * @param domain
	 *            已经存在的对象T【领域对象或者模型对象】
	 * @throws DataAccessException
	 *             数据访问异常【借助spring对数据库访问的异常信息的包装类】： 1.数据源配置的问题 2.数据库连接对象的问题
	 *             3.sql或者JPQL的问题 4.数据提供的问题
	 */
	void delete(List<T> domain) throws DataAccessException;

}
