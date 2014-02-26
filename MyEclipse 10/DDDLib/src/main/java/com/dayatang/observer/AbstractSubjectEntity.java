package com.dayatang.observer;

import java.util.List;

import javax.persistence.MappedSuperclass;

import com.dayatang.domain.AbstractEntity;

@MappedSuperclass
public abstract class AbstractSubjectEntity extends AbstractEntity implements
		Subject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8696877724719553088L;

	@Override
	public abstract String getSubjectKey();

	@SuppressWarnings("rawtypes")
	@Override
	public List<Observer> getObservers() {
		// 每次查找最新的观察者，将来考虑加入缓存机制
		return Observer.findBySubject(this);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void notifyObservers() {
		List<Observer> observers = getObservers();
		for (Observer observer : observers) {
			observer.process(this);
		}
	}

}
