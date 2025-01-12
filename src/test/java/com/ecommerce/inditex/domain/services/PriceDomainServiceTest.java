package com.ecommerce.inditex.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.ecommerce.inditex.apirest.dto.PriceDTO;
import com.ecommerce.inditex.apirest.mapper.PriceMapper;
import com.ecommerce.inditex.domain.entities.PriceEntity;
import com.ecommerce.inditex.domain.exceptions.InvalidRequestException;
import com.ecommerce.inditex.domain.repository.PriceDomainRepository;
import com.ecommerce.inditex.utils.EasyRandomUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * The Class PriceDomainServiceTest.
 */
class PriceDomainServiceTest {

    /** The price domain service. */
	@InjectMocks
    private PriceDomainService priceDomainService;

    /** The price repository. */
    @Mock
    private PriceDomainRepository priceRepository;

    /** The price mapper. */
    @Mock
    private PriceMapper mapper;

    /**
     * Sets up the test.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceDomainService = new PriceDomainService(priceRepository, mapper);
    }

    /**
     * Test find final price when inputs valid and data exists then return price DTO.
     */
    @Test
    void testFindFinalPrice_whenInputsValidAndDataExists_thenReturnPriceDTO() {
        // GIVEN
        Integer productId = EasyRandomUtils.generate(Integer.class);
        Integer brandId = EasyRandomUtils.generate(Integer.class);
        OffsetDateTime applicationDate = EasyRandomUtils.generateRandomOffsetDateTime();

        List<PriceEntity> priceEntities = EasyRandomUtils.generateList(PriceEntity.class, 2);
        priceEntities.get(0).setPriority(1);
        priceEntities.get(1).setPriority(2);

        PriceDTO expectedPriceDTO = EasyRandomUtils.generate(PriceDTO.class);
        expectedPriceDTO.setApplicationDate(applicationDate); 
        
        when(priceRepository.findPriceByCriteria(productId, brandId, applicationDate)).thenReturn(priceEntities);
        when(mapper.toDTO(priceEntities.get(1))).thenReturn(expectedPriceDTO);

        // WHEN
        PriceDTO result = priceDomainService.findFinalPrice(productId, brandId, applicationDate);

        // THEN
        assertEquals(expectedPriceDTO.getProductId(), result.getProductId());
        assertEquals(expectedPriceDTO.getBrandId(), result.getBrandId());
        assertEquals(expectedPriceDTO.getPrice(), result.getPrice());
        assertEquals(expectedPriceDTO.getRateId(), result.getRateId());
        assertEquals(applicationDate, result.getApplicationDate()); 
    }

    /**
     * Test find final price when inputs are null then throw exception.
     */
    @Test
    void testFindFinalPrice_whenInputsAreNull_thenThrowException() {
        // GIVEN
        Integer productId = null;
        Integer brandId = null;
        OffsetDateTime applicationDate = null;

        // THEN
        assertThrows(InvalidRequestException.class,
                () -> priceDomainService.findFinalPrice(productId, brandId, applicationDate));
    }

    /**
     * Test find final price when productId is null then throw exception.
     */
    @Test
    void testFindFinalPrice_whenProductIdIsNull_thenThrowException() {
        // GIVEN
        Integer productId = null;
        Integer brandId = EasyRandomUtils.generate(Integer.class);
        OffsetDateTime applicationDate = EasyRandomUtils.generateRandomOffsetDateTime();

        // THEN
        assertThrows(InvalidRequestException.class,
                () -> priceDomainService.findFinalPrice(productId, brandId, applicationDate));
    }

    /**
     * Test find final price when brandId is null then throw exception.
     */
    @Test
    void testFindFinalPrice_whenBrandIdIsNull_thenThrowException() {
        // GIVEN
        Integer productId = EasyRandomUtils.generate(Integer.class);
        Integer brandId = null;
        OffsetDateTime applicationDate = EasyRandomUtils.generateRandomOffsetDateTime();

        // THEN
        assertThrows(InvalidRequestException.class,
                () -> priceDomainService.findFinalPrice(productId, brandId, applicationDate));
    }

    /**
     * Test find final price when applicationDate is null then throw exception.
     */
    @Test
    void testFindFinalPrice_whenApplicationDateIsNull_thenThrowException() {
        // GIVEN
        Integer productId = EasyRandomUtils.generate(Integer.class);
        Integer brandId = EasyRandomUtils.generate(Integer.class);
        OffsetDateTime applicationDate = null;

        // THEN
        assertThrows(InvalidRequestException.class,
                () -> priceDomainService.findFinalPrice(productId, brandId, applicationDate));
    }

    /**
     * Test find final price when no data is found then throw exception.
     */
    @Test
    void testFindFinalPrice_whenNoDataFound_thenThrowException() {
        // GIVEN
        Integer productId = EasyRandomUtils.generate(Integer.class);
        Integer brandId = EasyRandomUtils.generate(Integer.class);
        OffsetDateTime applicationDate = EasyRandomUtils.generateRandomOffsetDateTime();

        when(priceRepository.findPriceByCriteria(productId, brandId, applicationDate)).thenReturn(List.of());

        // THEN
        assertThrows(InvalidRequestException.class,
                () -> priceDomainService.findFinalPrice(productId, brandId, applicationDate));
    }
}