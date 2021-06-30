/**
 * 
 */
package com.pco.crud.dto;

import java.time.LocalDateTime;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Getter
@NoArgsConstructor
@ToString
public class OrderProductDto  {
	Long id;
	String orderName;
	String productName;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	@QueryProjection
	public OrderProductDto(Long id, String orderName,String productName,LocalDateTime createdDate, LocalDateTime modifiedDate) {
		//super(createdDate, modifiedDate);
		this.id=id;
		this.orderName=orderName;
		this.productName=productName;
		this.createdDate=createdDate;
		this.modifiedDate=modifiedDate;
							
	}
	
}
