package com.ecommerce.inditex.apirest.dto;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceDTO {

	/** The product id. */
	private Integer productId;

	/** The brand id. */
	private Integer brandId;

	/** The price. */
	private Double price;

	/** The rate id. */
	private Integer rateId;

	/** The application date. */
	private OffsetDateTime applicationDate;
}
