/**
 * 
 */
package com.kelloggs.upc.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kelloggs.upc.common.dto.BrandDTO;
import com.kelloggs.upc.common.dto.ResponseDTO;

/**
 * @author brout
 *
 */
@Repository
public interface BrandDAO extends BaseDao {
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
	 * Fetch list of all brands
	 * 
	 * @param
	 * @return A List of BrandDTO's
	 */

	public List<BrandDTO> getBrands(int iCountryId);
	
	public List<BrandDTO> getBrandsDetailsByPromotion(int iPromotionId);


	 public ResponseDTO updateBrand(int iBrandId, String iBrandName, String iBrandCode, int iCountryId, boolean isActive, int iUserId);
	 
	 public  List<BrandDTO> searchBrands(int iCountryId, String iBrandName);
	
}
