package com.ecommerce.inditex.domain.repository;

import java.time.LocalDate;
import java.util.List;

import com.ecommerce.inditex.domain.entities.PriceEntity;

/**
 * The Interface PriceRepository.
 */
public interface PriceDomainRepository {


    /**
     * Find price by criteria.
     *
     * @param productId the product id
     * @param brandId the brand id
     * @param applicationDate the application date
     * @return the list
     */
    List<PriceEntity> findPriceByCriteria(Integer productId, Integer brandId, LocalDate applicationDate);

}
