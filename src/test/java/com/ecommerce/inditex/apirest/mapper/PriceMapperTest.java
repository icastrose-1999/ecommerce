package com.ecommerce.inditex.apirest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import com.ecommerce.inditex.apirest.dto.PriceDTO;
import com.ecommerce.inditex.domain.entities.PriceEntity;

import java.time.OffsetDateTime;

/**
 * The Class PriceMapperTest.
 */
public class PriceMapperTest {

    /** The price mapper. */
	@Mock
    private PriceMapper priceMapper = new PriceMapperImpl();

    /**
     * Test to DTO when price entity then price DTO.
     */
    @Test
    void testToDTO_whenPriceEntity_thenPriceDTO() {
        
    	// GIVEN
        PriceEntity priceEntity = PriceEntity.builder()
            .productId(1)
            .brandId(2)
            .price(Double.valueOf("99.99"))
            .rateId(3)
            .applicationDate(OffsetDateTime.now())
            .build();

        // WHEN
        PriceDTO priceDTO = priceMapper.toDTO(priceEntity);

        // THEN
        assertEquals(priceEntity.getProductId(), priceDTO.getProductId());
        assertEquals(priceEntity.getBrandId(), priceDTO.getBrandId());
        assertEquals(priceEntity.getPrice(), priceDTO.getPrice());
        assertEquals(priceEntity.getRateId(), priceDTO.getRateId());
        assertEquals(priceEntity.getApplicationDate(), priceDTO.getApplicationDate());
    }
}
