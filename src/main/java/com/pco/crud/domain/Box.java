/**
 * 
 */
package com.pco.crud.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "box")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Box extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boxId;
	
	@Column(name = "box_num" ,nullable = false)
	private int boxNum;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_product")
	protected OrderProduct orderProduct;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="release_round")
	protected ReleaseRound releaseRound;
	
}
