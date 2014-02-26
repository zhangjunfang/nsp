package com.hnrisen.auditworks.mapper.reuse;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hnrisen.auditworks.basic.interfaces.CRUDMapper;

public interface SubnavigationMapper<T extends Serializable> extends CRUDMapper<T>{

	List<T> selectByScene(T domain) throws DataAccessException;
}