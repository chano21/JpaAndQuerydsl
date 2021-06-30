package com.pco.crud;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

//import com.pco.crud.config.QuerydslConfig;
import com.pco.crud.domain.Member;
import com.pco.crud.domain.Order;
import com.pco.crud.repo.MemberRepository;
import com.pco.crud.repo.service.QuerydslMemberRepositoryImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;

@DataJpaTest
//@SpringBootTest
//@DirtiesContext
class MemerOrderCrudTest {

	@Autowired
	EntityManager em;

	JPAQueryFactory queryFactory;

	QuerydslMemberRepositoryImpl qmr;

	@Autowired
	MemberRepository repo;

	@BeforeEach
	public void init() {
		System.out.println("하위");
		System.out.println("ㅎㅇㅎㅇ" + em);
		queryFactory = new JPAQueryFactory(em);
		qmr = new QuerydslMemberRepositoryImpl(queryFactory);
	}

	@DisplayName(value = "Order , Member join insert Test")
	@Test
	@Transactional
	void insertTest() {

		Member member = Member.builder().memberName("하이").build();// .build();
		em.persist(member);
		Order order = null;
		for (int i = 0; i < 1; i++) {
			order = Order.builder().orderName("하이" + i).build();
			member.changeOrder(order);
			em.persist(order);
		}
		em.flush();
		for (Order o : member.getOrders()) {
			System.out.println(o.getOrderName());
		}

		System.out.println(qmr.findqueryDslMember("하이1"));

	}

}
