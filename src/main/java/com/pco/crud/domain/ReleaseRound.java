/**
 * 
 */
package com.pco.crud.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "release_round")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseRound extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long releaseRoundId;

	@Column(nullable = false)
	private String releaseWatingBoxs;
	
	@Builder.Default
	@OneToMany(mappedBy = "releaseRound",fetch = FetchType.LAZY)
	private List<Box> boxs = new ArrayList<>();

	public void changeBox(Box box){
		boxs.add(box);
		box.releaseRound=this;		
	}

}
