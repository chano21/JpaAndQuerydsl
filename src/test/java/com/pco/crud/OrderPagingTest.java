/**
 * 
 */
package com.pco.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pco.crud.domain.Member;
import com.pco.crud.domain.OrderProduct;
import com.pco.crud.domain.Orders;
import com.pco.crud.domain.Product;
import com.pco.crud.dto.OrderDto;
import com.pco.crud.dto.OrderProductDto;
import com.pco.crud.repo.MemberRepository;
import com.pco.crud.repo.OrderProductRepository;
import com.pco.crud.repo.ProductRepository;
import com.pco.crud.repo.service.QuerydslMemberRepositoryImpl;
import com.pco.crud.repo.service.QuerydslOrderProductRepositoryImpl;
import com.pco.crud.repo.service.QuerydslOrderRepositoryImpl;
import com.pco.crud.repo.service.QuerydslProductRepositoryImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * @author ParkChano
 *
 * 2021. 7. 2.
 */
@DataJpaTest
public class OrderPagingTest {


	@Autowired
	EntityManager em;

	JPAQueryFactory queryFactory;

	QuerydslOrderRepositoryImpl or;

	
	
	@Autowired
	MemberRepository memberRepo;

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	OrderProductRepository orderRepo;

	
	
	
	@BeforeEach
	public void init() {
		queryFactory = new JPAQueryFactory(em);
		or = new QuerydslOrderRepositoryImpl(queryFactory);
	}

	
	@DisplayName(value = "OrderPaging Test")
	@Test
	@Transactional
	void pagingTest() {
		
		Member member1 = Member.builder().memberName("박찬오").build();// .build();

		Member member2 = Member.builder().memberName("하아앙").build();// .build();

		
		em.persist(member1);
		em.persist(member2);
		Orders order = null;
		for (int i = 0; i < 100; i++) {
			order = Orders.builder().orderName("하이" + i).build();
			em.persist(order);
			member1.changeOrder(order);
		}
		//	em.detach(entity);
		//		
		for (int i = 0; i < 100; i++) {
			order = Orders.builder().orderName("호이" + i).build();
			em.persist(order);
			member2.changeOrder(order);
		}
		em.flush();
		
	//	em.clear();
		//System.out.println(member1.getClass());
		
		em.detach(member1); // 영속해제
//		member1 = em.find(Member.class,Long.parseLong("1"));
//		System.out.println(member1.getMemberName());
//		System.out.println(member1.getOrders().size());
		
//		for (Orders o : member1.getOrders()) {
//			System.out.println(o.getOrderName());
//		}

		
		List<OrderDto> dto1 =or.findOrderInMember(0,30,"호이");
		System.out.println(dto1.size());
		
		List<OrderDto> dto2 =or.findOrderInOrder(0,30,"호이");
		System.out.println(dto2.size());
		
		
		
//		Product product1 = Product.builder().productName("상품1").build();
//		Product product2 = Product.builder().productName("상품2").build();
//		
//		em.persist(product1);
//		em.persist(product2);
//
//		
//		List<Product> productList = new ArrayList<Product>();
//
//		productList.add(product1);
//		productList.add(product2);
//		Orders order3=em.find(Orders.class, Long.parseLong("3"));
//		
//		OrderProduct op = OrderProduct.builder().build();
//		op.bulkChangeProduct(productList);
//		op.changeOrder(order3);
//
//		em.flush();
//		
//		System.out.println(or.findOrderInMember(0, 30, "호이").toString());

	}
}
