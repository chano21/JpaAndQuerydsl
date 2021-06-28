/**
 * 
 */
package com.pco.crud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

@Entity
@Getter
@Table(name = "product")
public class Product extends BaseEntity {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue
	private Long productId;
	
	@Column(name = "product_name")
	private String productName;

	@ManyToOne
	@JoinColumn(name="order_product")
	protected OrderProduct orderProduct;


}
