package com.ecommerce.inditex.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * Instantiates a new price value object.
 */
@Value
public class PriceValueObject {

    /** The amount. */
    Double amount;
    
    /** The currency. */
    String currency;

}
