/**
 * 
 */
package com.pco.crud.repo.service;

//import com.pco.crud.domain.QMember.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.pco.crud.domain.Member;
import static com.pco.crud.domain.QMember.member;

import com.pco.crud.dto.BaseDto;
import com.pco.crud.dto.MemberDto;
import com.pco.crud.dto.QMemberDto;
import com.pco.crud.repo.Impl.MemberImplRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Repository
//@Service
public class QuerydslMemberRepositoryImpl extends QuerydslRepositorySupport implements MemberImplRepository {

//	@Autowired
//	private final JPAQueryFactory queryFactory;

    
	private final JPAQueryFactory queryFactory;
//
    public QuerydslMemberRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Member.class);
        this.queryFactory = queryFactory;
    }

	/**
	 * @param memberName
	 * @return
	 * 2021. 6. 28.
	 * ParkChano
	 * description : 
	 */
    @Override
	public MemberDto findqueryDslMember(String memberName) {
   		MemberDto dto=	queryFactory.select(new QMemberDto(member.memberId, member.memberName, member.createdDate, member.modifiedDate)).where(member.memberName.like(memberName)).from(member).fetchOne();
		return dto;
	}
 
}
