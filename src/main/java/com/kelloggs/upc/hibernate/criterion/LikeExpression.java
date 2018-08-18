/*
 * Copyright (c) 2014, Cluster India.
 * 
 */
package com.kelloggs.upc.hibernate.criterion;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.TypedValue;


/**
 * The Class LikeExpression.
 */
public class LikeExpression implements Criterion
{

	/** The property name. */
	private final String propertyName;

	/** The value. */
	private final String value;

	/** The escape char. */
	private final Character escapeChar;

	/**
	 * Instantiates a new like expression.
	 * 
	 * @param propertyName
	 *           the property name
	 * @param value
	 *           the value
	 */
	public LikeExpression(final String propertyName, final Object value)
	{
		this(propertyName, value.toString(), (Character) null);
	}

	/**
	 * Instantiates a new like expression.
	 * 
	 * @param propertyName
	 *           the property name
	 * @param value
	 *           the value
	 * @param matchMode
	 *           the match mode
	 */
	public LikeExpression(final String propertyName, final String value, final MatchMode matchMode)
	{
		this(propertyName, matchMode.toMatchString(value.toString().replaceAll("!", "!!").replaceAll("%", "!%")
				.replaceAll("_", "!_")), '!');
	}

	/**
	 * Instantiates a new like expression.
	 * 
	 * @param propertyName
	 *           the property name
	 * @param value
	 *           the value
	 * @param escapeChar
	 *           the escape char
	 */
	public LikeExpression(final String propertyName, final String value, final Character escapeChar)
	{
		this.propertyName = propertyName;
		this.value = value;
		this.escapeChar = escapeChar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.criterion.Criterion#toSqlString(org.hibernate.Criteria, org.hibernate.criterion.CriteriaQuery)
	 */
	public String toSqlString(final Criteria criteria, final CriteriaQuery criteriaQuery) throws HibernateException
	{
		final Dialect dialect = criteriaQuery.getFactory().getDialect();
		final String[] columns = criteriaQuery.getColumnsUsingProjection(criteria, propertyName);
		if (columns.length != 1)
		{
			throw new HibernateException("Like may only be used with single-column properties");
		}
		final String lhs = lhs(dialect, columns[0]);
		return lhs + " like ?" + (escapeChar == null ? "" : " escape ?");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.criterion.Criterion#getTypedValues(org.hibernate.Criteria,
	 * org.hibernate.criterion.CriteriaQuery)
	 */
	public TypedValue[] getTypedValues(final Criteria criteria, final CriteriaQuery criteriaQuery) throws HibernateException
	{
		return new TypedValue[]
		{ criteriaQuery.getTypedValue(criteria, propertyName, typedValue(value)),
				criteriaQuery.getTypedValue(criteria, propertyName, escapeChar.toString()) };
	}

	/**
	 * Lhs.
	 * 
	 * @param dialect
	 *           the dialect
	 * @param column
	 *           the column
	 * @return the string
	 */
	protected String lhs(final Dialect dialect, final String column)
	{
		return column;
	}

	/**
	 * Typed value.
	 * 
	 * @param value
	 *           the value
	 * @return the string
	 */
	protected String typedValue(final String value)
	{
		return value;
	}

}
