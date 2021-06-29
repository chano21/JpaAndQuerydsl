/**
 * 
 */
package com.pco.crud.repo.service;

import static com.pco.crud.domain.QMember.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.pco.crud.domain.Member;
import com.pco.crud.dto.MemberDto;
import com.pco.crud.repo.Impl.MemberImplRepositoryDeclared;
import com.querydsl.jpa.impl.JPAQueryFactory;
/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Repository
//@Service
public class QuerydslMemberRepositoryImpl extends QuerydslRepositorySupport {

//	@Autowired
//	private final JPAQueryFactory queryFactory;

    
	private final JPAQueryFactory queryFactory;
//
    public QuerydslMemberRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Member.class);
        this.queryFactory = queryFactory;
    }
    
//	@Autowired
//	private JPAQueryFactory queryFactory;

	
	//
//    public MemberRepositoryImpl(JPAQueryFactory queryFactory) {
//        this.queryFactory = queryFactory;
//    }

//	/**
//	 * @param memberName
//	 * @return
//	 * 2021. 6. 28.
//	 * ParkChano
//	 * description : 
//	 */
//	@Override
	public MemberDto findMember(String memberName) {
	
		//List<MemberDto> result = queryFactory .select(new QMemberDto(member.username, member.age)) .from(member) .fetch();
	MemberDto dto = (MemberDto) queryFactory.select(member.memberId,member.memberName,member.createdDate,member.modifiedDate).from(member).fetchOne();
		//	MemberDto dto = queryFactory.select(member)
	//			.select(new QMemberDto(member.getMemberId(), member.getMemberName(), member.getCreatedDate(), member.getModifiedDate())).from(member)
	//	queryFactory.select(new QMember(variable))
		// TODO Auto-generated method stub
		return dto;
	}
    
	/**
	 * @return
	 * 2021. 6. 28.
	 * ParkChano
	 * description : 
	 */
}
