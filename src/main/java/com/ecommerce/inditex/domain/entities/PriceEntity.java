package com.ecommerce.inditex.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.ecommerce.inditex.domain.valueobjects.PriceValueObject;

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
    
    /** The price value object. */
    private PriceValueObject priceValueObject;
    
    /** The priority. */
    private Integer priority;
    
    /** The application date. */
    private LocalDate applicationDate;

}
