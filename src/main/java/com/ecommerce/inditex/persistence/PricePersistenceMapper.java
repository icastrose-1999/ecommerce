package com.ecommerce.inditex.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ecommerce.inditex.domain.entities.PriceEntity;
import com.ecommerce.inditex.domain.repository.PriceDomainRepository;

import java.time.LocalDate;
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
            id,
            productId,
            brandId,
            rateId,
            price,
            priority
        FROM prices
        WHERE (product_id = #{productId} OR #{productId} IS NULL)
          AND (brand_id = #{brandId} OR #{brandId} IS NULL)
          AND #{applicationDate} IS NULL
          AND start_date <= #{applicationDate}
          AND end_date >= #{applicationDate}
    """)
    List<PriceEntity> findPriceByCriteria(
        @Param("productId") Integer productId,
        @Param("brandId") Integer brandId,
        @Param("applicationDate") OffsetDateTime applicationDate
    );
}
