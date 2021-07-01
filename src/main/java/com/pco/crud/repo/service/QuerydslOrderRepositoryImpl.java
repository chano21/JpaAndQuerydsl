package com.pco.crud.repo.service;

import static com.pco.crud.domain.QOrderProduct.orderProduct;
import static com.pco.crud.domain.QOrders.orders;
import static com.pco.crud.domain.QProduct.product;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.pco.crud.domain.Orders;
import com.pco.crud.domain.QOrders;
import com.pco.crud.dto.OrderProductDto;
import com.pco.crud.dto.QOrderProductDto;
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
		
		// TODO Auto-generated method stub
//		System.out.println("나오냐 : " + orderId);
//		List<OrderProductDto> dto=queryFactory.from(o)
//				.innerJoin(orders.orderProduct,orderProduct)
//				.where(orderProduct.orderProductId.eq(orderId)).fet
	//			.fetch(); 
		
		//.select(new QOrderProductDto(orderProduct.orderProductId, QOrders.orders.orderName, product.productName, orderProduct.createdDate, orderProduct.modifiedDate))
		
		//queryFactory.select(new QOrderProductDto(orderProduct.orderProductId,"d","d",orderProduct.createdDate,orderProduct.modifiedDate))
		//List<OrderProductDto> dto = queryFactory.select(new QOrderProductDto(orderProduct.orderProductId,order.orderName,product.productName)).from(orderProduct);

		
//		List<OrderProductDto> dto=queryFactory.from(orders)
//		.select(new QOrderProductDto(orderProduct.orderProductId, orders.orderName, product.productName, orderProduct.createdDate, orderProduct.modifiedDate))
//		.from()
		//		.innerJoin(orders.orderProduct,orderProduct)
//		.where(orderProduct.orderProductId.eq(orderId))
//		.fetch();

//		System.out.println("나왓다 : " + dto.toString());

		return null;
	}
 
}
