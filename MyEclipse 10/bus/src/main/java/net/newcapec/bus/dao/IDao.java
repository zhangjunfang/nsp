package net.newcapec.bus.dao;

import java.util.List;

import net.newcapec.bus.Pagination;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 黄鑫
 *
 */
public interface IDao<T, P, S> {
	public List<T> queryAll(@Param("page") Pagination page, @Param("s") S search);

	public int queryAllCount(@Param("s") S search);

	public T queryById(@Param("s") S search);

	public int update(@Param("p") P p, @Param("s") S search);

	public int insert(@Param("p") P p);

	public int delete(@Param("s") S search);
}
