package com.ecommerce.inditex.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * PriceEntity represents the domain entity for prices.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceEntity {

    /** The id. */
    private Integer id;
    
    /** The product id. */
    private Integer productId;
    
    /** The brand id. */
    private Integer brandId;
    
    /** The rate id. */
    private Integer rateId;
    
    /** The price. */
    private Double price;
    
    /** The priority. */
    private Integer priority;
    
    /** The application date. */
    private OffsetDateTime applicationDate;

}
