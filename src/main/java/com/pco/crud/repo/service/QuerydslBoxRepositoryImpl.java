package com.pco.crud.repo.service;

import static com.pco.crud.domain.QMember.member;
import static com.pco.crud.domain.QOrders.orders;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.pco.crud.domain.Box;
import com.pco.crud.dto.OrderDto;
import com.pco.crud.dto.OrderProductDto;
import com.pco.crud.dto.QOrderDto;
import com.pco.crud.repo.Impl.BoxImplRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Repository
public class QuerydslBoxRepositoryImpl extends QuerydslRepositorySupport implements BoxImplRepository {

    
	private final JPAQueryFactory queryFactory;
//
    public QuerydslBoxRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Box.class);
        this.queryFactory = queryFactory;
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

 
}
