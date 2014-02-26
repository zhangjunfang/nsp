/**
 * 
 */
package com.dayatang.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


/**
 * 抽象实体类，可作为所有领域实体的基类，提供ID和版本属性。
 * 
 * @author yang
 * 
 */
@MappedSuperclass
public abstract class AbstractEntity implements Entity {

	private static final long serialVersionUID = 8882145540383345037L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Version
	@Column(name = "VERSION")
	private int version;


	/**
	 * 获得实体的标识
	 * 
	 * @return 实体的标识
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * 设置实体的标识
	 * 
	 * @param id
	 *            要设置的实体标识
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获得实体的版本号。持久化框架以此实现乐观锁。
	 * 
	 * @return 实体的版本号
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * 设置实体的版本号。持久化框架以此实现乐观锁。
	 * 
	 * @param version
	 *            要设置的版本号
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public boolean isNew() {
		return id == null || id.intValue() == 0;
	}

	@Override
	public boolean existed() {
		if (isNew()) {
			return false;
		}
		return getRepository().exists(getClass(), id);
	}

	@Override
	public boolean notExisted() {
		return ! existed();
	}
	
	@Override
	public boolean existed(String propertyName, Object propertyValue) {
		List<?> entities = getRepository().find(QuerySettings.create(getClass()).eq(propertyName, propertyValue)); 
		return !(entities.isEmpty());
	}

	private static EntityRepository repository;

	public static EntityRepository getRepository() {
		if (repository == null) {
			repository = InstanceFactory.getInstance(EntityRepository.class);
		}
		return repository;
	}

	public static void setRepository(EntityRepository repository) {
		AbstractEntity.repository = repository;
	}

	public void save() {
		getRepository().save(this);
	}

	public void remove() {
		getRepository().remove(this);
	}

	/**
	 * 请改用每个实体对象的实例方法的existed()方法。
	 * @param clazz
	 * @param id
	 * @return
	 */
	@Deprecated
	public static <T extends Entity> boolean exists(Class<T> clazz, Serializable id) {
		return getRepository().exists(clazz, id);
	}

	public static <T extends Entity> T get(Class<T> clazz, Serializable id) {
		return getRepository().get(clazz, id);
	}

	public static <T extends Entity> T getUnmodified(Class<T> clazz, T entity) {
		return getRepository().getUnmodified(clazz, entity);
	}

	public static <T extends Entity> T load(Class<T> clazz, Serializable id) {
		return getRepository().load(clazz, id);
	}

	public static <T extends Entity> List<T> findAll(Class<T> clazz) {
		return getRepository().find(QuerySettings.create(clazz));
	}

	public static <T extends Entity> List<T> findByProperty(Class<T> clazz, String propName, Object value) {
		return getRepository().find(QuerySettings.create(clazz).eq(propName, value));
	}

	public static <T extends Entity> List<T> findByProperties(Class<T> clazz, Map<String, Object> propValues) {
		QuerySettings<T> querySettings = QuerySettings.create(clazz);
		for (Map.Entry<String, Object> each : propValues.entrySet()) {
			querySettings.eq(each.getKey(), each.getValue());
		}
		return getRepository().find(querySettings);
	}
	

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object other);

	@Override
	public abstract String toString();
}
