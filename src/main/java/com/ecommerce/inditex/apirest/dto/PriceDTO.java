package com.ecommerce.inditex.apirest.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
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
	private LocalDate applicationDate;
}
