package com.pco.crud;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.pco.crud.domain.Member;
import com.pco.crud.domain.Order;

@DataJpaTest
@DirtiesContext
class CrudTest {

	@Autowired
	EntityManager em;
	@Test
	void contextLoads() {
		
		Member member = Member.builder().memberName("멤버1").build();//.build();
		em.persist(member);			
		Order order = null;
		for (int i = 0; i < 1000; i++) {
			order = Order.builder().orderName("주문"+i).build();
			member.changeOrder(order);		
			em.persist(order);
		}
	
		for(Order o : member.getOrders()) {
			System.out.println(o.getOrderName());
		}
		
	}

}
