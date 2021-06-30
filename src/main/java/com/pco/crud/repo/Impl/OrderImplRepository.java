/**
 * 
 */
package com.pco.crud.repo.Impl;

import com.pco.crud.dto.OrderDto;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

public interface OrderImplRepository{
	OrderDto findqueryDslMember(String memberName);
}