/**
 * 
 */
package com.pco.crud.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ParkChano
 *
 * 2021. 7. 18.
 */
@Embeddable
//@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddress{
	
	@Column(name="order_address1")
	private String address1;
	
	@Column(name="order_address2")
	private String address2;
	
}
