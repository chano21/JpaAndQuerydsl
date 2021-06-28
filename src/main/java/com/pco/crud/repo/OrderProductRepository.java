/**
 * 
 */
package com.pco.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pco.crud.domain.OrderProduct;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
public interface OrderProductRepository extends JpaRepository <OrderProduct, Long>{

	
}
