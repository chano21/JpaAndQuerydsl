/**
 * 
 */
package com.pco.crud.repo.service;

import static com.pco.crud.domain.QOrderProduct.orderProduct;
import static com.pco.crud.domain.QOrders.orders;
//import static com.pco.crud.domain.QOrders.order;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.pco.crud.domain.OrderProduct;
import com.pco.crud.dto.OrderProductDto;
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
	public List<OrderProductDto> findqueryDslOrderProduct(String orderName) {
		// TODO Auto-generated method stub
//		List<OrderProductDto> dto= queryFactory.from(orderProduct)
//				.innerJoin(orders.orderProduct)
//				.innerJoin(product.orderProduct)
//				.select(new QOrderProductDto(orderProduct.orderProductId,orders.orderName,product.productName,orderProduct.createdDate,orderProduct.modifiedDate))
//				.where(orders.orderName.eq(productName)).fetch();
				
System.out.println("나아라!!");
			List<?> ob = queryFactory.from(orderProduct)
		//	.select(orders.orderName)
			.innerJoin(orderProduct.orders,orders)
				//.select(new QOrderProductDto(orderProduct.orderProductId,orders.orderName,product.productName,orderProduct.createdDate,orderProduct.modifiedDate))
				.where(orders.orderName.eq(orderName)).fetch();
			
			System.out.println();

		//.select(new QOrderProductDto(orderProduct.orderProductId, orders.orderName, product.productName, orderProduct.createdDate, orderProduct.modifiedDate)
						
				//.select(new QOrderProductDto(orderProduct.orderProductId, QOrders.orders.orderName, product.productName, orderProduct.createdDate, orderProduct.modifiedDate)
						
				
//				queryFactory.from(orderProduct)
//				.select(new QOrderProductDto(orderProduct.orderProductId, QOrders.orders.orderName, product.productName, orderProduct.createdDate, orderProduct.modifiedDate))
//				.innerJoin(orders.orderProduct,orderProduct)
//				.innerJoin(product.orderProduct,orderProduct)
//				.where(product.productName.eq(productName)).fetch();
	//			.fetch(); 
		
		//.select(new QOrderProductDto(orderProduct.orderProductId, QOrders.orders.orderName, product.productName, orderProduct.createdDate, orderProduct.modifiedDate))
		
		//queryFactory.select(new QOrderProductDto(orderProduct.orderProductId,"d","d",orderProduct.createdDate,orderProduct.modifiedDate))
		//List<OrderProductDto> dto = queryFactory.select(new QOrderProductDto(orderProduct.orderProductId,order.orderName,product.productName)).from(orderProduct);
//		System.out.println("나왓다 : " + dto.toString());
		return null;
	}

 
}
