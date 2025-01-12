package com.ecommerce.inditex.domain.services;

import com.ecommerce.inditex.apirest.dto.PriceDTO;
import com.ecommerce.inditex.apirest.mapper.PriceMapper;
import com.ecommerce.inditex.domain.entities.PriceEntity;
import com.ecommerce.inditex.domain.exceptions.InvalidRequestException;
import com.ecommerce.inditex.domain.repository.PriceDomainRepository;

import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * The Class PriceDomainService.
 */
@RequiredArgsConstructor
@Service
public class PriceDomainService {

    /** The price repository. */
    private final PriceDomainRepository priceRepository;

    /** The mapper. */
    private final PriceMapper mapper;

    /**
     * Find final price.
     *
     * @param productId the product id
     * @param brandId   the brand id
     * @param startDate the start date
     * @return the price DTO
     */
    public PriceDTO findFinalPrice(Integer productId, Integer brandId, OffsetDateTime applicationDate) {
        validateInputs(productId, brandId, applicationDate);
        
        List<PriceEntity> prices = priceRepository.findPriceByCriteria(productId, brandId, applicationDate);
        
        PriceDTO priceDTO = prices.stream()
            .max((p1, p2) -> p1.getPriority().compareTo(p2.getPriority()))
            .map(mapper::toDTO)
            .orElseThrow(() -> new InvalidRequestException("No data found for the provided criteria."));
               
        return new PriceDTO(priceDTO.getProductId(), priceDTO.getBrandId(), 
        		priceDTO.getPrice(), priceDTO.getRateId() , applicationDate);
    }

    /**
     * Validate inputs for null values.
     *
     * @param productId the product id
     * @param brandId   the brand id
     * @param startDate the start date
     */
    private void validateInputs(Integer productId, Integer brandId, OffsetDateTime applicationDate) {
        if (productId == null || brandId == null || applicationDate == null) {
            throw new InvalidRequestException("Product ID, Brand ID, and Application Date cannot be null.");
        }
    }
}
