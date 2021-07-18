/**
 * 
 */
package com.pco.crud.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ParkChano
 *
 * 2021. 7. 18.
 */
@Embeddable
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderNote extends BaseEntity{
	
	@Column(name="note_1")
	private String note1;
	
	@Column(name="note_2")
	private String note2;
	
	@Column(name="note_3")
	private String note3;
	
	@Column(name="note_4")
	private String note4;
	
}
