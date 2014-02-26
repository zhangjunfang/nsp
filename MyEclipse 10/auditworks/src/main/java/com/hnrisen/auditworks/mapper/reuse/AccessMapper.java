package com.hnrisen.auditworks.mapper.reuse;

import java.io.Serializable;

import com.hnrisen.auditworks.basic.interfaces.CRUDMapper;

/**
 * The Interface AccessMapper.
 * 
 * @param <T>
 *            the generic type
 */
public interface AccessMapper<T extends Serializable> extends CRUDMapper<T> {
}
