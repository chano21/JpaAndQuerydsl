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

import lombok.Builder;
import lombok.Getter;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Entity
@Table(name = "member")
@Builder
@Getter
public class Member extends BaseEntity{
	
	@Id
	@GeneratedValue
	private Long memberId;
	
	private String memberName;
	
	@Builder.Default
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();

	public void changeOrder(Order order){
		orders.add(order);
		order.member=this;		
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
