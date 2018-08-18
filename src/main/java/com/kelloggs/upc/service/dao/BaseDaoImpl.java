/**
 * BaseDaoImpl.java
 * 
 * This class Implements BaseDao.
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
package com.kelloggs.upc.service.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

	// =================================================
	// Class Variables
	// =================================================
	// =================================================
	// Instance Variables
	// =================================================
	// =================================================
	// Constructors
	// =================================================
	// =================================================
	// Class Methods
	// =================================================
	// =================================================
	// Instance Methods
	// =================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#save(java.io.Serializable)
	 */
	public void save(final Serializable iEntity) {
		Session theSession = getSession();
		theSession.saveOrUpdate(iEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#saveAll(java.util.Collection)
	 */
	public void saveAll(final Collection<? extends Serializable> iEntities) {
		Session theSession = getSession();
		Transaction tx = theSession.beginTransaction();
		for (Serializable anEntity : iEntities) {
			theSession.flush();
			try {
				theSession.saveOrUpdate(anEntity);
			} catch (Exception e) {
				tx.rollback();
			}
		}
		theSession.flush();
		tx.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#merge(java.io.Serializable)
	 */
	public Serializable merge(final Serializable iEntity) {
		Session theSession = getSession();
		Serializable anEntity = (Serializable) theSession.merge(iEntity);
		return anEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#mergeAll(java.util.Collection)
	 */
	public void mergeAll(final Collection<? extends Serializable> iEntities) {
		Session theSession = getSession();
		for (Serializable anEntity : iEntities) {
			theSession.flush();
			theSession.merge(anEntity);
		}
		theSession.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kelloggs.upc.service.dao.BaseDao#saveAndFlush(java.io.Serializable)
	 */
	public void saveAndFlush(final Serializable iEntity) {
		Session theSession = getSession();
		theSession.saveOrUpdate(iEntity);
		theSession.flush();
		releaseSession(theSession);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#fetchAll(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> fetchAll(final Class<T> iEntityClass) {
		return createCriteria(iEntityClass).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#fetchAllCached(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> fetchAllCached(
			final Class<T> iEntityClass) {
		return createCriteria(iEntityClass).setCacheable(true).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kelloggs.upc.service.dao.BaseDao#fetchEntityById(java.lang.Class,
	 * java.io.Serializable)
	 */
	public <T extends Serializable> T fetchEntityById(
			final Class<T> iEntityClass, final Serializable iId) {
		Session session = getSession();
		return iEntityClass.cast(session.get(iEntityClass, iId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#fetchEntity(java.lang.Class,
	 * java.lang.String, java.io.Serializable)
	 */
	public <T extends Serializable> T fetchEntity(final Class<T> iEntityClass,
			final String iAttribute, final Serializable iValue) {
		return iEntityClass.cast(createCriteria(iEntityClass).add(
				Restrictions.eq(iAttribute, iValue)).uniqueResult());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#fetchAll(java.lang.Class,
	 * java.lang.String, java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> fetchAll(
			final Class<T> iEntityClass, final String iAttribute,
			final Serializable iValue) {
		return createCriteria(iEntityClass).add(
				Restrictions.eq(iAttribute, iValue)).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kelloggs.upc.service.dao.BaseDao#fetchDistinctEntities(java.lang.
	 * Class, java.lang.String, java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> fetchDistinctEntities(
			final Class<T> iEntityClass, final String iAttribute,
			final Serializable iValue) {
		Criteria theCriteria = createCriteria(iEntityClass).add(
				Restrictions.eq(iAttribute, iValue));
		theCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return theCriteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#fetchAllCached(java.lang.Class,
	 * java.lang.String, java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> fetchAllCached(
			final Class<T> iEntityClass, final String iAttribute,
			final Serializable iValue) {
		return createCriteria(iEntityClass)
				.add(Restrictions.eq(iAttribute, iValue)).setCacheable(true)
				.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#createCriteria(java.lang.Class)
	 */
	public Criteria createCriteria(
			final Class<? extends Serializable> iPersistentClass) {
		return getSession().createCriteria(iPersistentClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#createCriteria(java.lang.Class,
	 * java.lang.String)
	 */
	public Criteria createCriteria(
			final Class<? extends Serializable> iPersistentClass,
			final String iAlias) {
		Session theSession = null;
		Criteria theCriteria = null;
		theSession = getSession();
		theCriteria = theSession.createCriteria(iPersistentClass, iAlias);
		

		return theCriteria;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#fetch(java.lang.Class, int,
	 * int)
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> fetch(final Class<T> iEntityClass,
			final int iFrom, final int iTo) {
		Criteria theCriteria = createCriteria(iEntityClass);
		theCriteria.setFirstResult(iFrom);
		theCriteria.setMaxResults(iFrom + iTo);
		return theCriteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kelloggs.upc.service.dao.BaseDao#deleteEntity(java.io.Serializable)
	 */
	public void deleteEntity(final Serializable iEntity) {
		final String theEntityName = iEntity.getClass().getName();
		final Field theField = getIdField(iEntity);
		theField.setAccessible(true);
		final String theQuery;
		try {
			theQuery = "DELETE FROM " + theEntityName + " where "
					+ theField.getName() + "=" + theField.get(iEntity);
			Query theGuidQuery = getSession().createQuery(theQuery);
			theGuidQuery.executeUpdate();
		} catch (Exception theException) {
			theException.printStackTrace();
		}
	}

	/**
	 * Used for getting the id field of the Entity.
	 * 
	 * @return Field - the Id field Entity value.
	 */
	private Field getIdField(final Serializable iEntity) {
		Field theId = null;
		final Field[] theFieldValues = iEntity.getClass().getDeclaredFields();
		for (Field aField : theFieldValues) {
			if (aField.getAnnotation(Id.class) != null) {
				theId = aField;
				break;
			}
		}
		return theId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kelloggs.upc.service.dao.BaseDao#loadEntity(java.lang.Class,
	 * java.io.Serializable)
	 */
	public <T extends Serializable> T loadEntity(final Class<T> iEntityClass,
			final Serializable iId) {
		return iEntityClass.cast(getSession().load(iEntityClass, iId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kelloggs.upc.service.dao.BaseDao#deleteEntitiesByIds(java.lang.Class,
	 * java.util.List)
	 */
	public void deleteEntitiesByIds(
			final Class<? extends Serializable> iEntityClass,
			final List<? extends Serializable> iIds) {
		for (Serializable theId : iIds) {
			Serializable theEntity = fetchEntityById(iEntityClass, theId);
			deleteEntity(theEntity);
		}
	}

	@SuppressWarnings("deprecation")
	public ResultSet createSql(final String sqlQuery) throws Exception {
		Session theSession = null;
		ResultSet rs = null;
		try {
			theSession = getSession();
			Connection con = theSession.connection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sqlQuery);
		} finally {
			releaseSession(theSession);
		}

		return rs;

	}
	

	@SuppressWarnings("deprecation")
	public Integer createUpdate(final String sqlQuery) throws Exception {
		Session theSession = null;
		Integer isUpdated = null;
		try {
		  theSession = getSession();
		  Connection con = theSession.connection();
		  Statement stmt = con.createStatement();
		  isUpdated = stmt.executeUpdate(sqlQuery);
		} finally {
			releaseSession(theSession);
		}
		  return isUpdated;

	}

	/**
	 * Adds the order by on Modification Date and Create Date for the Criteria
	 * 
	 * @param iCriteria
	 */
	protected void addOrderByDate(final Criteria iCriteria) {
		iCriteria.addOrder(Order.desc("history._modificationDate")).addOrder(
				Order.desc("id"));
	}

	protected boolean executeStoredProcedure(final String iProcedureCall,
			final Map<String, Object> iParamsMap) {

		getSession().createSQLQuery(iProcedureCall).setProperties(iParamsMap)
				.executeUpdate();
		return true;

	}

	// =================================================
	// Accessors
	// =================================================
	/**
	 * @param iSessionFactory
	 */
	@Resource(name = "sessionFactory")
	public void setSessionFactroy(final SessionFactory iSessionFactory) {
		this.setSessionFactory(iSessionFactory);
	}
}
