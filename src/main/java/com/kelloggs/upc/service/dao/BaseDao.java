/**
 * BaseDao.java
 * 
 * This class contains all the common methods used for performing database operations. This class also provides support for Generics, to avoid type castings at the caller side.
 */
package com.kelloggs.upc.service.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;

public interface BaseDao {

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
    /**
     * Save or Update an Entity
     * @param iEntity
     * @see org.hibernate.Session#saveOrUpdate(String, Object)
     */
    public void save(Serializable iEntity);

    /**
     * Save or Update an Entities
     * @param iEntities to Save
     * @see org.hibernate.Session#saveOrUpdate(String, Object)
     */
	public void saveAll(Collection<? extends Serializable> iEntities);
	
	 /**
     * Updates an Entity. saveOrUpdate() when used on detached entity which is also present 
     * in session will throw a nonUniqueKeyException. If service is being annotated with @Transactional
     * and entity is to be updated this method should be used.
     * @param iEntity
     * @see org.hibernate.Session#saveOrUpdate(String, Object)
     */
    public Serializable merge(Serializable iEntity);

    /**
     * Updates the given entities. saveOrUpdate() when used on detached entity which is also present 
     * in session will throw a nonUniqueKeyException. If service is being annotated with @Transactional
     * and entity is to be updated this method should be used.
     * @param iEntities to update
     * @see org.hibernate.Session#merge(String, Object)
     */
	public void mergeAll(Collection<? extends Serializable> iEntities);

    /**
     * Save or Update an Entity and flush to the database. This method will also get the version
     * updated in the entity.
     * @param iEntity
     * @see org.hibernate.Session#saveOrUpdate(String, Object)
     * @see org.hibernate.Session#flush()
     */
    public void saveAndFlush(Serializable iEntity);

    /**
     * Fetches all the entities for a given class
     * @param <T>  Type of Entity
     * @param iEntityClass
     * @return List of entities
     */
    public <T extends Serializable> List<T> fetchAll(Class<T> iEntityClass);

	/**
	 * Fetches all the entities for a given class and applies
	 * {@link org.hibernate.Criteria#DISTINCT_ROOT_ENTITY}
	 * @param <T> Type of Entity
	 * @param iEntityClass
	 * @param iAttribute
	 * @param iValue
	 * @return List of distinct entities
	 */
	public <T extends Serializable> List<T> fetchDistinctEntities(Class<T> iEntityClass, String iAttribute, Serializable iValue);

	/**
	 * Fetches all the entities for a given class for the given from and to indexes.
	 * @param <T> Type of Entity
	 * @param iEntityClass
	 * @param iFrom From row number
	 * @param iTo To row number
	 * @return List of entities
	 */
    public <T extends Serializable> List<T> fetch(Class<T> iEntityClass, int iFrom, int iTo);

    /**
     * Fetches all the entities for a given class
     * @param <T> Type of Entity
     * @param iEntityClass
     * @param iAttribute
     * @param iValue
     * @return List of entities
     */
    public <T extends Serializable> List<T> fetchAll(Class<T> iEntityClass, String iAttribute, Serializable iValue);

    /**
     * Fetches all the entities for a given class in cached mode
     * @param <T> Type of Entity
     * @param iEntityClass
     * @param iAttribute
     * @param iValue
     * @return List of entities
     * @see org.hibernate.Criteria#setCacheable(boolean)
     */
    public <T extends Serializable> List<T> fetchAllCached(Class<T> iEntityClass, String iAttribute, Serializable iValue);

    /**
     * Fetches all the entities for a given class in cached mode
     * @param <T> Type of Entity
     * @param iEntityClass
     * @return List of entities
     * @see org.hibernate.Criteria#setCacheable(boolean)
     */
    public <T extends Serializable> List<T> fetchAllCached(Class<T> iEntityClass);

    /**
     * Fetches entity for given primary key
     * @param <T> Type of Entity Class
     * @param iEntityClass
     * @param iId
     * @return Entity with provided Id, null if not present
     * @see org.hibernate.Session#get(Class, Serializable)
     */
    public <T extends Serializable> T fetchEntityById(Class<T> iEntityClass, Serializable iId);

    /**
     * Fetches an entity based for a unique attribute.
     * @param <T> Type of Entity Class
     * @param iEntityClass
     * @param iAttribute
     * @param iValue
     * @return Entity
     */
    public <T extends Serializable> T fetchEntity(Class<T> iEntityClass, String iAttribute, Serializable iValue);

    /**
     * Create criteria for a given class
     * @param iEntityClass Class Name
     * @return Criteria
     * @see org.hibernate.Session#createCriteria(Class)
     */
    public Criteria createCriteria(Class<? extends Serializable> iEntityClass);

	/**
	 * Create criteria for a given class
	 * @param iEntityClass Class Name
	 * @param iAlias
	 * @return Criteria
	 * @see org.hibernate.Session#createCriteria(Class)
	 */
    public Criteria createCriteria(Class<? extends Serializable> iEntityClass, String iAlias);

    /**
     * Delete the entity i.e, set the retired flag
     * @param iEntity
     */
    public void deleteEntity(Serializable iEntity);

    /**
     * Load the entity.This method should be used to set the entities which are typically foreign
     * keys.
     * @param <T> Type of Entity Class
     * @param iEntityClass
     * @param iId
     * @see org.hibernate.Session#load(Class, Serializable)
     */
    public <T extends Serializable> T loadEntity(Class<T> iEntityClass, Serializable iId);
    
    /**
     * This method takes the entity class type and a list of primary keys for deletion (i.e, setting
     * the retired flag).
     * @param iEntityClass The Entity Class
     * @param iIds The primary keys
     */
    public void deleteEntitiesByIds(Class<? extends Serializable> iEntityClass, List<? extends Serializable> iIds);
    
    
	
		
    // =================================================
    // Accessors
    // =================================================
}
