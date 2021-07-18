/**
 * 
 */
package com.pco.crud.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

@Entity
@Table(name="order_product")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderProductId;
	
	@Builder.Default
	@OneToMany(mappedBy = "orderProduct",fetch = FetchType.LAZY)
	private List<Orders> orders = new ArrayList<>();

	@Builder.Default
	@OneToMany(mappedBy = "orderProduct",fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<>();

	@Builder.Default
	@OneToMany(mappedBy = "orderProduct",fetch = FetchType.LAZY)
	private List<Box> boxs = new ArrayList<>();

	
	
	public void changeOrder(Orders order){
		orders.add(order);
		order.orderProduct=this;		
	}
		
	public void changeProduct(Product product){
		products.add(product);
		product.orderProduct=this;		
	}
	
	public void changeBoxs(Box box){
		boxs.add(box);
		box.orderProduct=this;		
	}

	public void bulkChangeBox(List<Box> box){
		boxs=box;
		box.forEach(o -> o.orderProduct=this);
	}
	
	
	public void bulkChangeOrder(List<Orders> order){
		orders=order;
		order.forEach(o -> o.orderProduct=this);
	}
	
	public void bulkChangeProduct(List<Product> product){
		products=product;
		product.forEach(o -> o.orderProduct=this);
	}
	
}
