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
import com.pco.crud.domain.OrderProduct;
import com.pco.crud.domain.Orders;
import com.pco.crud.domain.Product;
import com.pco.crud.repo.MemberRepository;
import com.pco.crud.repo.OrderProductRepository;
import com.pco.crud.repo.ProductRepository;
import com.pco.crud.repo.service.QuerydslMemberRepositoryImpl;
import com.pco.crud.repo.service.QuerydslOrderProductRepositoryImpl;
import com.pco.crud.repo.service.QuerydslOrderRepositoryImpl;
import com.pco.crud.repo.service.QuerydslProductRepositoryImpl;
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
	
	QuerydslOrderRepositoryImpl or;

	QuerydslProductRepositoryImpl pr;

	
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
		or = new QuerydslOrderRepositoryImpl(queryFactory);
		pr = new QuerydslProductRepositoryImpl(queryFactory);
	}

	@DisplayName(value = "OrderProduct M X M insert Test")
	@Test
	@Transactional
	void insertTest() {

		//Order
		
		Member member1 = Member.builder().phoneNumber("010-1111-3333").memberName("박찬오").build();// .build();

		Member member2 = Member.builder().phoneNumber("010-1111-2222").memberName("하아앙").build();// .build();

		
		em.persist(member1);
		//em.flush();
		Orders order = null;
		for (int i = 0; i < 4; i++) {
			order = Orders.builder().orderName("하이" + i).build();
			em.persist(order);
			member1.changeOrder(order);
		}

	//	em.flush();
		order = null;
		for (int i = 0; i < 4; i++) {
			order = Orders.builder().orderName("호이" + i).build();
			em.persist(order);
			member2.changeOrder(order);
		}
		
		em.flush();

		
		for (Orders o : member1.getOrders()) {
			System.out.println(o.getOrderName() + " " +o.getOrderId());
		}
//		em.flush();
		System.out.println(qmr.findqueryDslMember("하이1"));

	//	System.out.println(.findqueryDslMember("하이1"));

		
		
		//Member and Order 관계형성완료.
		
		Product product1 = Product.builder().productName("상품1").build();
		Product product2 = Product.builder().productName("상품2").build();
		
		em.persist(product1);
		em.persist(product2);
		// 상품 2개 생성
		Orders order3=em.find(Orders.class, Long.parseLong("3"));
		
		System.out.println("오더 : " + order3);
		
		List<Product> productList = new ArrayList<Product>();

		productList.add(product1);
		productList.add(product2);

		OrderProduct op = OrderProduct.builder().build();
		op.bulkChangeProduct(productList);
		op.changeOrder(order3);
		
		em.persist(op);
		//em.flush();
		System.out.println(op.getOrders().toString());
		
		em.clear();
		op=em.find(OrderProduct.class, Long.parseLong("1"));
		
		assertNotNull(op);
		System.out.println(op.getOrderProductId());
		for(Product p : op.getProducts()) {
			System.out.println(p.getProductName());
		}
		
		for(Orders o : op.getOrders()) {
			System.out.println(o.getOrderName());
		}
		
		System.out.println(qopr.findqueryDslOrderProduct("하이2"));
	
		
		
		//	em.persist(product);
	//	em.clear();
		
		System.out.println(or.findOrderInMember(0, 30, "호이"));
//		System.out.println(or.findOrderIn(0, 30, "호이"));
		
		
	}

	
	
}
