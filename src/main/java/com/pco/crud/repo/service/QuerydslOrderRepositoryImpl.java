package com.pco.crud.repo.service;

import static com.pco.crud.domain.QOrders.orders;
import static com.pco.crud.domain.QMember.member;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.pco.crud.domain.Orders;
import com.pco.crud.dto.OrderDto;
import com.pco.crud.dto.OrderProductDto;
import com.pco.crud.dto.QOrderDto;
import com.pco.crud.repo.Impl.OrderImplRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Repository
//@Service
public class QuerydslOrderRepositoryImpl extends QuerydslRepositorySupport implements OrderImplRepository {

//	@Autowired
//	private final JPAQueryFactory queryFactory;

    
	private final JPAQueryFactory queryFactory;
//
    public QuerydslOrderRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Orders.class);
        this.queryFactory = queryFactory;
    }
//
//	/**
//	 * @param memberName
//	 * @return
//	 * 2021. 6. 28.
//	 * ParkChano
//	 * description : 
//	 */
//    @Override
//	public MemberDto findqueryDslMember(String memberName) {
//   		MemberDto dto=	queryFactory.select(new QMemberDto(member.memberId, member.memberName, member.createdDate, member.modifiedDate)).from(member).fetchOne();
//		return dto;
//	}

	/**
	 * @param orderId
	 * @return
	 * 2021. 7. 1.
	 * ParkChano
	 * description : 
	 */
	@Override
	public List<OrderProductDto> findOrderAndProduct(Long orderId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	/**
	 * @param orderName
	 * @return
	 * 2021. 7. 2.
	 * ParkChano
	 * description : 
	 */
	@Override
	public List<OrderDto> findOrderInMember(int offset ,int limit ,String orderName) {

		List<OrderDto> pdto = queryFactory.
				from(member).
				select(new QOrderDto(orders.orderId,orders.orderName,orders.createdDate,orders.modifiedDate))
				.innerJoin(member.orders,orders)
				.where(orders.orderName.contains(orderName)).orderBy(orders.orderId.desc())
				.offset(offset).limit(limit)
				.fetch();

		return pdto;
	}

	/**
	 * @param orderName
	 * @return
	 * 2021. 7. 2.
	 * ParkChano
	 * description : 
	 */
	@Override
	public List<OrderDto> findOrderInOrder(int offset ,int limit ,String orderName) {
		// TODO Auto-generated method stub
		
		
		List<OrderDto> pdto = queryFactory.
				from(orders).
				select(new QOrderDto(orders.orderId,orders.orderName,orders.createdDate,orders.modifiedDate))
				.where(orders.orderName.contains(orderName)).orderBy(orders.orderId.desc())
				.offset(offset).limit(limit)
				.fetch();

		return pdto;
	}
 
}
