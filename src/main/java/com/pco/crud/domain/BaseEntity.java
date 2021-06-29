/**
 * 
 */
package com.pco.crud.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.pco.crud.common.Status;

import lombok.Getter;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@CreatedDate
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	@Column(name = "author")
	private String author;
	@Column(name = "del")
	private Status.Del del;
}
