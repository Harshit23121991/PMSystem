/**
 * JDBCDaoImpl.java
 */
package com.kelloggs.upc.service.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoImpl extends JdbcDaoSupport implements JdbcDao {

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
  
	/* (non-Javadoc)
     * @see com.kelloggs.upc.service.dao.JdbcDao#executeSQLUpdateQuery(java.lang.String, java.lang.Object[], int[])
     */
    public int executeSQLUpdateQuery(final String iSQLQuery, final Object[] iParamValues, final int[] iParamTypes) {
    	return getJdbcTemplate().update(iSQLQuery, iParamValues, iParamTypes);
    }

    // =================================================
    // Accessors
    // =================================================
}
