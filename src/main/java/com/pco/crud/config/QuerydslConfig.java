/**
 * 
 */
package com.pco.crud.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Configuration
public class QuerydslConfig {
	  @PersistenceContext
	    private EntityManager entityManager;

	    @Bean
	    public JPAQueryFactory jpaQueryFactory() {
	        return new JPAQueryFactory(entityManager);
	    }
}
