package com.hnrisen.auditworks.service.subnavigation;

import java.io.Serializable;
import java.util.List;

import com.hnrisen.auditworks.basic.interfaces.CRUDService;

public interface SubnavigationService<T extends Serializable> extends CRUDService<T>{

	List<T> getByScene(T domain) throws Exception;
}

