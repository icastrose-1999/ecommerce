package com.ecommerce.inditex.apirest.controllers;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.GetPricesApi;
import com.ecommerce.inditex.apirest.dto.PriceDTO;
import com.ecommerce.inditex.domain.services.PriceDomainService;
import com.ecommerce.model.GetPricesResponseDTO;

import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
public class PriceController implements GetPricesApi {

	@Autowired
	private final PriceDomainService priceService;
	
	@Override
	public ResponseEntity<GetPricesResponseDTO> getFinalPrices(Integer productId, Integer brandId, OffsetDateTime applicationDate){

			PriceDTO priceDTO = priceService.findFinalPrice(productId, brandId, applicationDate);
            
            new GetPricesResponseDTO();
			GetPricesResponseDTO priceResponse = GetPricesResponseDTO.builder()
                    .productId(priceDTO.getProductId())
                    .brandId(priceDTO.getBrandId())
                    .price(priceDTO.getPrice())
                    .rateId(priceDTO.getRateId())
                    .applicationDate(priceDTO.getApplicationDate())
                    .build();
            
            return new ResponseEntity<>(priceResponse, HttpStatus.OK);
	}
}
