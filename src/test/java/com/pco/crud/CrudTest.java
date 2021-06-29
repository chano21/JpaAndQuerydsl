package com.pco.crud;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.pco.crud.domain.Member;
import com.pco.crud.domain.Order;
import com.pco.crud.repo.MemberRepository;
import com.pco.crud.repo.service.QuerydslMemberRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

//@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
//@DirtiesContext
class CrudTest {

	@Autowired
	EntityManager em;

	 JPAQueryFactory queryFactory;

//	 @Autowired
	QuerydslMemberRepository qmr;

	
    @TestConfiguration
    static class TestConfig {

        @PersistenceContext
        private EntityManager entityManager;

        @Bean
        public JPAQueryFactory jpaQueryFactory() {
            return new JPAQueryFactory(entityManager);
        }
    }
    
//	    @BeforeEach
//	    public void init() {
//	        queryFactory = new JPAQueryFactory(em);
//	        
//	    }
	
	    
	@Autowired
	MemberRepository repository;
	
	

	@DisplayName(value = "Order , Member join insert Test")
	@Test
	void insertTest() {
		
		Member member = Member.builder().memberName("멤버1").build();//.build();
		em.persist(member);			
		Order order = null;
		for (int i = 0; i < 1000; i++) {
			order = Order.builder().orderName("주문"+i).build();
			member.changeOrder(order);		
			em.persist(order);
		}
		em.flush();
		for(Order o : member.getOrders()) {
			System.out.println(o.getOrderName());
		}
		
		System.out.println(qmr.findMember("멤버1").toString());
		
		
	}
	
//	@DisplayName(value = "Order , Member join insert Test")
//	@Test
//	void selectTest() {
//		
//		Member member = Member.builder().memberName("멤버1").build();//.build();
//		em.persist(member);			
//		Order order = null;
//		for (int i = 0; i < 1000; i++) {
//			order = Order.builder().orderName("주문"+i).build();
//			member.changeOrder(order);		
//			em.persist(order);
//		}
//	
//		for(Order o : member.getOrders()) {
//			System.out.println(o.getOrderName());
//		}
//		
//	}
	

}
