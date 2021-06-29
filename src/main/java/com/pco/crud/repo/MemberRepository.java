/**
 * 
 */
package com.pco.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pco.crud.domain.Member;
import com.pco.crud.dto.MemberDto;
import com.pco.crud.repo.Impl.MemberImplRepositoryDeclared;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
public interface MemberRepository extends JpaRepository <Member, Long> ,MemberImplRepositoryDeclared{
//public interface MemberRepository extends JpaRepository <Member, Long>{

//	public MemberDto findMember(String memberName); 
	/**
	 * @param memberName
	 * @return
	 * 2021. 6. 28.
	 * ParkChano
	 * description : 
	 */
//	@Override
//	public MemberDto findMember(String memberName);
}