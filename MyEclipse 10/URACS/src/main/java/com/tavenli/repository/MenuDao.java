package com.tavenli.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tavenli.entity.MenuEntity;

@Repository
public class MenuDao extends BaseDao {

	private static Logger logger = LoggerFactory.getLogger(MenuDao.class);
	
	
	public MenuEntity getMenuById(int id){
		try {
			return this.getById(MenuEntity.class, id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public List<MenuEntity> getMenus(int navMenu) {
		List<MenuEntity> list = new ArrayList<MenuEntity>();
		
		String hql = "from MenuEntity where navMenu=?";
		TypedQuery<MenuEntity> query = this.getEntityManager().createQuery(hql, MenuEntity.class);
		query.setParameter(1, navMenu);
		try {
			list = query.getResultList();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return list;
	}
	
	public List<MenuEntity> getMenus() {
		List<MenuEntity> list = new ArrayList<MenuEntity>();
		
		String hql = "from MenuEntity";
		TypedQuery<MenuEntity> query = this.getEntityManager().createQuery(hql, MenuEntity.class);
		try {
			list = query.getResultList();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return list;
	}
	
	public List<MenuEntity> getChildMenus(int parentId) {
		List<MenuEntity> list = new ArrayList<MenuEntity>();
		
		String hql = "from MenuEntity where parentId=?";
		TypedQuery<MenuEntity> query = this.getEntityManager().createQuery(hql, MenuEntity.class);
		query.setParameter(1, parentId);
		try {
			list = query.getResultList();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return list;
	}
	
	public int queryDataCount(Map<String, Object> paramMap){
		StringBuilder hql = new StringBuilder();
		Map<String, Object> params = new HashMap<String, Object>();
		
		hql.append("select count(*) from MenuEntity where 1=1");
		
		if(paramMap.get("id")!=null){
			hql.append(" and id=:id");
			params.put("id", paramMap.get("id"));
		}
		
		if(paramMap.get("menuName")!=null){
			hql.append(" and menuName like:menuName");
			params.put("menuName", "%"+ paramMap.get("menuName") +"%");
			
		}
		
		return super.queryPageTotalCount(hql.toString(),params).intValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<MenuEntity> queryPageData(int start, int maxSize,Map<String, Object> paramMap){
		StringBuilder hql = new StringBuilder();
		Map<String, Object> params = new HashMap<String, Object>();
		
		hql.append("from MenuEntity  where 1=1");
		
		if(paramMap.get("id")!=null){
			hql.append(" and id=:id");
			params.put("id", paramMap.get("id"));
		}
		
		if(paramMap.get("menuName")!=null){
			hql.append(" and menuName like:menuName");
			params.put("menuName", "%"+ paramMap.get("menuName") +"%");
			
		}
		
		hql.append(" order by id desc");
		
		return super.queryPageList(hql.toString(), params, start, maxSize);
	}
	
	public int delMenu(int id){
		
		String hql = "delete MenuEntity t where t.id=?";
		
		Query query = this.getEntityManager().createQuery(hql);
		query.setParameter(1, id);
		try {
			return query.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return -1;
	}
	
}
