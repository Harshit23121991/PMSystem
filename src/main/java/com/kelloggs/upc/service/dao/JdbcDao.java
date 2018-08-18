/**
 * JDBCDao.java
 * 
 * This class contains all the common methods used for performing database operations directly through JDBC. 
 */
package com.kelloggs.upc.service.dao;

public interface JdbcDao {

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
     * Executes the SQL Update Query.
     * @param iSQLQuery SQL Query
     * @return No. of rows updated
     * @param iParamValues
     * @param iParamTypes
     */
    public int executeSQLUpdateQuery(final String iSQLQuery, Object[] iParamValues, final int[] iParamTypes);

    // =================================================
    // Accessors
    // =================================================
}
