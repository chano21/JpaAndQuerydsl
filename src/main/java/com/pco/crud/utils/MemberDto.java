/**
 * 
 */
package com.pco.crud.utils;

import java.time.LocalDateTime;

import com.pco.crud.domain.Orders;
import com.pco.crud.dto.BaseDto;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
//@Builder
@Getter
@NoArgsConstructor
public class MemberDto extends BaseDto {
	Long id;
	String name;

	public MemberDto(Long id, String name,LocalDateTime createdDate, LocalDateTime modifiedDate) {
		super(createdDate, modifiedDate);
		this.id=id;
		this.name=name;
	}
	
	
	
	public static void main(String args[]) {
		LocalDateTime time1 = LocalDateTime.now();
		LocalDateTime time2 = LocalDateTime.now();
		
		
		
		MemberDto dto = new MemberDto((long)1, "hello",time1,time2);

		System.out.println(dto.getName());
		System.out.println(dto.getId());
		System.out.println(dto.getCreatedDate());
		System.out.println(dto.getModifiedDate());
	
		
		
	}
	/**
	 * @param createdDate
	 * @param modifiedDate
	 */

}
