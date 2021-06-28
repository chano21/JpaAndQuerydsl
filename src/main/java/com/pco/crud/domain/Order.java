/**
 * 
 */
package com.pco.crud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

@Entity
@Table(name = "orders")
@Builder
@Getter
public class Order extends BaseEntity{

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue
	private Long orderId;
	
	@Column(name = "order_name")
	private String orderName;

	@ManyToOne
	@JoinColumn(name="member")
	protected Member member;
	
	@ManyToOne
	@JoinColumn(name="order_product")
	protected OrderProduct orderProduct;

	/**
	 * @return
	 * 2021. 6. 28.
	 * ParkChano
	 * description : 
	 */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
	}
}
