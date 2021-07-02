/**
 * 
 */
package com.pco.crud.repo.Impl;

import java.util.List;

import com.pco.crud.dto.OrderDto;
import com.pco.crud.dto.OrderProductDto;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

public interface OrderImplRepository{
	List<OrderProductDto> findOrderAndProduct(Long orderId);

	List<OrderDto> findOrderInMember(int offset ,int limit ,String orderName);
	List<OrderDto> findOrderInOrder(int offset ,int limit ,String orderName);

}