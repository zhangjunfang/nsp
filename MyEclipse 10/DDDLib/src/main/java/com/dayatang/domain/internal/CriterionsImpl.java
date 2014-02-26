package com.dayatang.domain.internal;

import com.dayatang.domain.Criterions;
import com.dayatang.domain.QueryCriterion;

import java.util.Collection;


/**
 * 一个工具类，作为各种查询条件的工厂
 * @author yyang (<a href="mailto:gdyangyu@gmail.com">gdyangyu@gmail.com</a>)
 *
 */
public class CriterionsImpl extends Criterions {

	public CriterionsImpl() {
	}

	@Override
	public QueryCriterion eq(String propName, Object value) {
		return new EqCriterion(propName, value);
	}
	
	@Override
	public QueryCriterion notEq(String propName, Object value) {
		return new NotEqCriterion(propName, value);
	}
	
	@Override
	public QueryCriterion ge(String propName, Comparable<?> value) {
		return new GeCriterion(propName, value);
	}
	
	@Override
	public QueryCriterion gt(String propName, Comparable<?> value) {
		return new GtCriterion(propName, value);
	}
	
	@Override
	public QueryCriterion le(String propName, Comparable<?> value) {
		return new LeCriterion(propName, value);
	}
	
	@Override
	public QueryCriterion lt(String propName, Comparable<?> value) {
		return new LtCriterion(propName, value);
	}
	
	@Override
	public QueryCriterion eqProp(String propName1, String propName2) {
		return new EqPropCriterion(propName1, propName2);
	}
	
	@Override
	public QueryCriterion notEqProp(String propName1, String propName2) {
		return new NotEqPropCriterion(propName1, propName2);
	}
	
	@Override
	public QueryCriterion gtProp(String propName1, String propName2) {
		return new GtPropCriterion(propName1, propName2);
	}
	
	@Override
	public QueryCriterion geProp(String propName1, String propName2) {
		return new GePropCriterion(propName1, propName2);
	}
	
	@Override
	public QueryCriterion ltProp(String propName1, String propName2) {
		return new LtPropCriterion(propName1, propName2);
	}
	
	@Override
	public QueryCriterion leProp(String propName1, String propName2) {
		return new LePropCriterion(propName1, propName2);
	}
	
	@Override
	public QueryCriterion sizeEq(String propName, int size) {
		return new SizeEqCriterion(propName, size);
	}
	
	@Override
	public QueryCriterion sizeNotEq(String propName, int size) {
		return new SizeNotEqCriterion(propName, size);
	}
	
	@Override
	public QueryCriterion sizeGt(String propName, int size) {
		return new SizeGtCriterion(propName, size);
	}
	
	@Override
	public QueryCriterion sizeGe(String propName, int size) {
		return new SizeGeCriterion(propName, size);
	}
	
	@Override
	public QueryCriterion sizeLt(String propName, int size) {
		return new SizeLtCriterion(propName, size);
	}
	
	@Override
	public QueryCriterion sizeLe(String propName, int size) {
		return new SizeLeCriterion(propName, size);
	}

	@Override
	public QueryCriterion containsText(String propName, String value) {
		return new ContainsTextCriterion(propName, value);
	}

	@Override
	public QueryCriterion startsWithText(String propName, String value) {
		return new StartsWithTextCriterion(propName, value);
	}

	@Override
	public QueryCriterion in(String propName, Collection<?> value) {
		return new InCriterion(propName, value);
	}

	@Override
	public QueryCriterion in(String propName, Object[] value) {
		return new InCriterion(propName, value);
	}

	@Override
	public QueryCriterion notIn(String propName, Collection<?> value) {
		return new NotInCriterion(propName, value);
	}

	@Override
	public QueryCriterion notIn(String propName, Object[] value) {
		return new NotInCriterion(propName, value);
	}

	@Override
	public QueryCriterion between(String propName, Comparable<?> from, Comparable<?> to) {
		return new BetweenCriterion(propName, from, to);
	}
	
	@Override
	public QueryCriterion isNull(String propName) {
		return new IsNullCriterion(propName);
	}
	
	@Override
	public QueryCriterion notNull(String propName) {
		return new NotNullCriterion(propName);
	}
	
	@Override
	public QueryCriterion isEmpty(String propName) {
		return new IsEmptyCriterion(propName);
	}
	
	@Override
	public QueryCriterion notEmpty(String propName) {
		return new NotEmptyCriterion(propName);
	}
	
	@Override
	public QueryCriterion not(QueryCriterion criterion) {
		return new NotCriterion(criterion);
	}
	
	@Override
	public QueryCriterion and(QueryCriterion... criterions) {
		return new AndCriterion(criterions);
	}
	
	@Override
	public QueryCriterion or(QueryCriterion... criterions) {
		return new OrCriterion(criterions);
	}
	
}
