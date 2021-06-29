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
public class MemberDto  {
	Long id;
	String name;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	/**
	 * @param id
	 * @param name
	 */
	@QueryProjection
	public MemberDto(Long id, String name,LocalDateTime createdDate, LocalDateTime modifiedDate) {
		//super(createdDate, modifiedDate);
		this.id=id;
		this.name=name;
		this.createdDate=createdDate;
				this.modifiedDate=modifiedDate;
							
	}
	
}
