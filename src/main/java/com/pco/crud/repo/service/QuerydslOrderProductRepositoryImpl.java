/**
 * 
 */
package com.pco.crud.repo.service;

//import com.pco.crud.domain.QMember.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.pco.crud.domain.Member;
import com.pco.crud.domain.OrderProduct;

import static com.pco.crud.domain.QOrderProduct.orderProduct;
import static com.pco.crud.domain.QProduct.product;
import static com.pco.crud.domain.QOrder.order;


import java.util.List;

import com.pco.crud.dto.BaseDto;
import com.pco.crud.dto.MemberDto;
import com.pco.crud.dto.OrderProductDto;
import com.pco.crud.dto.QMemberDto;
import com.pco.crud.dto.QOrderProductDto;
import com.pco.crud.repo.Impl.MemberImplRepository;
import com.pco.crud.repo.Impl.OrderProductImplRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Repository
//@Service
public class QuerydslOrderProductRepositoryImpl extends QuerydslRepositorySupport implements OrderProductImplRepository {

//	@Autowired
//	private final JPAQueryFactory queryFactory;

    
	private final JPAQueryFactory queryFactory;
//
    public QuerydslOrderProductRepositoryImpl(JPAQueryFactory queryFactory) {
        super(OrderProduct.class);
        this.queryFactory = queryFactory;
    }

	/**
	 * @param memberName
	 * @return
	 * 2021. 6. 28.
	 * ParkChano
	 * description : 
	 */
//    @Override
//	public MemberDto findqueryDslMember(String memberName) {
//   		MemberDto dto=	queryFactory.select(new QMemberDto(member.memberId, member.memberName, member.createdDate, member.modifiedDate)).from(member).fetchOne();
//		return dto;
//	}

	/**
	 * @param orderId
	 * @return
	 * 2021. 6. 30.
	 * ParkChano
	 * description : 
	 */
	@Override
	public List<OrderProductDto> findqueryDslOrderProduct(Long orderId) {
		// TODO Auto-generated method stub
		System.out.println("나오냐 : " + orderId);
		List<OrderProductDto> dto=queryFactory
				.selectFrom(orderProduct)
				.select(new QOrderProductDto(orderProduct.orderProductId, order.orderName, product.productName, orderProduct.createdDate, orderProduct.modifiedDate))
				.innerJoin(order)
				.innerJoin(product)
				.where(orderProduct.orderProductId.eq(orderId))
				.fetch(); 
		//queryFactory.select(new QOrderProductDto(orderProduct.orderProductId,"d","d",orderProduct.createdDate,orderProduct.modifiedDate))
		//List<OrderProductDto> dto = queryFactory.select(new QOrderProductDto(orderProduct.orderProductId,order.orderName,product.productName)).from(orderProduct);
		System.out.println("나왓다 : " + dto.toString());
		return dto;
	}
 
}
