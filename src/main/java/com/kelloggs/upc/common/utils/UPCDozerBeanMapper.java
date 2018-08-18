/**
 * SBDozerBeanMapper.java
 */
package com.kelloggs.upc.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;


public class UPCDozerBeanMapper extends DozerBeanMapper {

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
	// Overridden Methods
	// =================================================
	// =================================================
	// Class Methods
	// =================================================
	// =================================================
	// Instance Methods
	// =================================================
	/**
	 * Maps a collection of objects
	 * 
	 * @param <T>
	 *            Type of the destination class
	 * @param iSourceCollection
	 * @param iDestinationClass
	 * @return List of destination class objects
	 * @throws MappingException
	 */
	public <T> List<T> mapCollection(final Collection<?> iSourceCollection, final Class<T> iDestinationClass) {
		List<T> theDestList = null;
		if (iSourceCollection.isEmpty()) {
			theDestList = Collections.emptyList();
		} else {
			theDestList = new ArrayList<T>(iSourceCollection.size());
			for (Object anObj : iSourceCollection) {
				T theDestObj = super.map(anObj, iDestinationClass);
				theDestList.add(theDestObj);
			}
		}
		return theDestList;
	}

	// =================================================
	// Accessors
	// =================================================
}
