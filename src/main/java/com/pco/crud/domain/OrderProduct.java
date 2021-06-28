/**
 * 
 */
package com.pco.crud.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

@Entity
@Table(name="order_product")
@Getter
public class OrderProduct extends BaseEntity {
	@Id
	@GeneratedValue
	private Long orderProductId;
	
	@Builder.Default
	@OneToMany(mappedBy = "orderProduct")
	private List<Order> orders = new ArrayList<>();

	@Builder.Default
	@OneToMany(mappedBy = "orderProduct")
	private List<Product> products = new ArrayList<>();

	
	public void changeOrder(Order order){
		orders.add(order);
		order.orderProduct=this;		
	}
	
	public void changeProduct(Product product){
		products.add(product);
		product.orderProduct=this;		
	}
	
}
