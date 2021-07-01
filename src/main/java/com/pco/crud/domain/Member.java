/**
 * 
 */
package com.pco.crud.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "member")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	
	private String memberName;
	
	@Builder.Default
	@OneToMany(mappedBy = "member")
	private List<Orders> orders = new ArrayList<>();

	
	public void changeOrder(Orders order){
		orders.add(order);
		order.member=this;		
	}

	public void bulkChangeOrder(List<Orders> order){
		orders=order;
		order.forEach(o -> o.member=this);
	}

	
	/**
	 * @return
	 * 2021. 6. 28.
	 * ParkChano
	 * description : 
	 */
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}

}
