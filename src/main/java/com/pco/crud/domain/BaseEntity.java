/**
 * 
 */
package com.pco.crud.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.pco.crud.common.Status;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@MappedSuperclass
@Getter
public abstract class BaseEntity {
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	@Column(name = "author")
	private String author;
	@Column(name = "del")
	private Status.Del del;
}
