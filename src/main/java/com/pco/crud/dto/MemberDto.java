/**
 * 
 */
package com.pco.crud.dto;

import java.time.LocalDateTime;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Getter
@NoArgsConstructor
public class MemberDto extends BaseDto {
	Long id;
	String name;
	/**
	 * @param id
	 * @param name
	 */
	@QueryProjection
	public MemberDto(Long id, String name,LocalDateTime createdDate, LocalDateTime modifiedDate) {
		super(createdDate, modifiedDate);
		this.id=id;
		this.name=name;
	}
	
}
