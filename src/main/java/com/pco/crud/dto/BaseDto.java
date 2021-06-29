/**
 * 
 */
package com.pco.crud.dto;

import java.time.LocalDateTime;

import com.pco.crud.common.Status;

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
public abstract class  BaseDto {

	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	/**
	 * @param createdDate
	 * @param modifiedDate
	 */
	public BaseDto(LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
}
