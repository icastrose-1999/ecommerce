package com.ecommerce.inditex.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ecommerce.inditex.domain.entities.PriceEntity;
import com.ecommerce.inditex.domain.repository.PriceDomainRepository;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * The Interface PricePersistenceMapper.
 */
@Mapper
public interface PricePersistenceMapper extends PriceDomainRepository {


    /**
     * Gets the price.
     *
     * @param productId the product id
     * @param brandId the brand id
     * @param applicationDate the application date
     * @return the price
     */
    @Select("""
        SELECT 
            product_id,
            brand_id,
            rate_id,
            price,
            priority
        FROM prices
        WHERE (product_id = #{productId})
          AND (brand_id = #{brandId})
          AND start_date <= #{applicationDate}
          AND end_date >= #{applicationDate}
    """)
    List<PriceEntity> findPriceByCriteria(
        @Param("productId") Integer productId,
        @Param("brandId") Integer brandId,
        @Param("applicationDate") OffsetDateTime applicationDate
    );
}
