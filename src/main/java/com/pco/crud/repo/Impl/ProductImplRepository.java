/**
 * 
 */
package com.pco.crud.repo.Impl;

import java.util.List;

import com.pco.crud.dto.ProductDto;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

public interface ProductImplRepository{
//	MemberDto findqueryDslMember(String memberName);
	
	List<ProductDto> findProduct(String productName);

}