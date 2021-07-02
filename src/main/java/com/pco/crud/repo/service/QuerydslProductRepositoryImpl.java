/**
 * 
 */
package com.pco.crud.repo.service;

import static com.pco.crud.domain.QProduct.product;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.pco.crud.domain.Product;
import com.pco.crud.domain.QProduct;
import com.pco.crud.dto.MemberDto;
import com.pco.crud.dto.ProductDto;
import com.pco.crud.dto.QMemberDto;
import com.pco.crud.dto.QProductDto;
import com.pco.crud.repo.Impl.ProductImplRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Repository
//@Service
public class QuerydslProductRepositoryImpl extends QuerydslRepositorySupport implements ProductImplRepository {

//	@Autowired
//	private final JPAQueryFactory queryFactory;

    
	private final JPAQueryFactory queryFactory;
//
    public QuerydslProductRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Product.class);
        this.queryFactory = queryFactory;
    }


	/**
	 * @param productName
	 * @return
	 * 2021. 7. 2.
	 * ParkChano
	 * description : 
	 */
	@Override
	public List<ProductDto> findProduct(String productName) {
		
//		Long id;
//		String productName;
//		private LocalDateTime createdDate;
//		private LocalDateTime modifiedDate;

		
		List<ProductDto> pdto = queryFactory.
				from(product).
				select(new QProductDto(product.productId,product.productName,product.createdDate,product.modifiedDate))
				.where(product.productName.contains(productName))
				//.contains(productName)
				.fetch();
		
		// TODO Auto-generated method stub
		return pdto;
	}
 
}
