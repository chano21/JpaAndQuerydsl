/**
 * 
 */
package com.pco.crud.repo.Impl;

import com.pco.crud.dto.MemberDto;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

public interface MemberImplRepositoryDeclared{
	MemberDto findMember(String memberName);
}