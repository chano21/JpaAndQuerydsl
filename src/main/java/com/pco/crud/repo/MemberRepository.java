/**
 * 
 */
package com.pco.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pco.crud.domain.Member;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
public interface MemberRepository extends JpaRepository <Member, Long>{

	
}