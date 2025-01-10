package com.ecommerce.inditex.domain.valueobjects;

import lombok.Value;

/**
 * Instantiates a new price value object.
 */
@Value
public class PriceValueObject {

    /** The amount. */
    double amount;
    
    /** The currency. */
    String currency;

}
