package com.hnrisen.auditworks.mapper.reuse;

import java.io.Serializable;

import com.hnrisen.auditworks.basic.interfaces.CRUDMapper;

/**
 * The Interface AccountMapper.
 * 
 * @param <T>
 *            the generic type
 */
public interface AccountMapper<T extends Serializable> extends CRUDMapper<T> {
}
