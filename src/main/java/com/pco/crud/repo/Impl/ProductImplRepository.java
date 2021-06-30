/**
 * 
 */
package com.pco.crud.repo.Impl;

import com.pco.crud.dto.BaseDto;
import com.pco.crud.dto.MemberDto;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

public interface ProductImplRepository{
	MemberDto findqueryDslMember(String memberName);
}