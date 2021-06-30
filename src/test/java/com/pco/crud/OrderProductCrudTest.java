package com.pco.crud;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//import com.pco.crud.config.QuerydslConfig;
import com.pco.crud.domain.Member;
import com.pco.crud.domain.Order;
import com.pco.crud.domain.OrderProduct;
import com.pco.crud.domain.Product;
import com.pco.crud.repo.MemberRepository;
import com.pco.crud.repo.OrderProductRepository;
import com.pco.crud.repo.ProductRepository;
import com.pco.crud.repo.service.QuerydslMemberRepositoryImpl;
import com.pco.crud.repo.service.QuerydslOrderProductRepositoryImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;

@DataJpaTest
//@SpringBootTest
//@DirtiesContext
class OrderProductCrudTest {

	@Autowired
	EntityManager em;

	JPAQueryFactory queryFactory;

	QuerydslMemberRepositoryImpl qmr;
	
	QuerydslOrderProductRepositoryImpl qopr;
	
	@Autowired
	MemberRepository memberRepo;

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	OrderProductRepository orderRepo;

	
	
	@BeforeEach
	public void init() {
		System.out.println("하위");
		System.out.println("ㅎㅇㅎㅇ" + em);
		queryFactory = new JPAQueryFactory(em);
		qmr = new QuerydslMemberRepositoryImpl(queryFactory);
		qopr = new QuerydslOrderProductRepositoryImpl(queryFactory);

	}

	@DisplayName(value = "OrderProduct M X M insert Test")
	@Test
	@Transactional
	void insertTest() {

		//Order
		
		Member member = Member.builder().memberName("하이").build();// .build();

		
		em.persist(member);
		Order order = null;
		for (int i = 0; i < 4; i++) {
			order = Order.builder().orderName("하이" + i).build();
			member.changeOrder(order);
			em.persist(order);
		}
		em.flush();
		for (Order o : member.getOrders()) {
			System.out.println(o.getOrderName());
		}

		System.out.println(qmr.findqueryDslMember("하이1"));
		
		
		//Member and Order 관계형성완료.
		
		Product product1 = Product.builder().productName("상품1").build();
		Product product2 = Product.builder().productName("상품2").build();
		
		em.persist(product1);
		em.persist(product2);
		// 상품 2개 생성
		Order order3=em.find(Order.class, Long.parseLong("3"));
		
		
		
		List<Product> productList = new ArrayList<Product>();

		productList.add(product1);
		productList.add(product2);

		OrderProduct op = OrderProduct.builder().build();
		op.bulkChangeProduct(productList);
		op.changeOrder(order3);
		
		em.persist(op);
		em.flush();
		System.out.println(op.getOrders().toString());
		
		em.clear();
		op=em.find(OrderProduct.class, Long.parseLong("1"));
		
		assertNotNull(op);
		System.out.println(op.getOrderProductId());
		for(Product p : op.getProducts()) {
			System.out.println(p.getProductName());
		}
		
		for(Order o : op.getOrders()) {
			System.out.println(o.getOrderName());
		}
		
		System.out.println(qopr.findqueryDslOrderProduct(Long.parseLong("1")).toString());
		
	//	em.persist(product);
		
		
	}

}
