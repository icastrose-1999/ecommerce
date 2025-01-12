package com.ecommerce.inditex.apirest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.ecommerce.inditex.apirest.controllers.PriceController;
import com.ecommerce.inditex.apirest.dto.PriceDTO;
import com.ecommerce.inditex.domain.services.PriceDomainService;
import com.ecommerce.model.GetPricesResponseDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

/**
 * The Class InditexApplicationIntegrationTests.
 */
class InditexApplicationIntegrationTests {

    /** The price controller. */
    @InjectMocks
    private PriceController priceController;

    /** The price service. */
    @Mock
    private PriceDomainService priceService;

    /**
     * Sets the up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test find price at 10 am 14 th for brand 1.
     */
    @Test
    void testFindPrice_at10am14th_forBrand1() {
        // GIVEN
        Integer productId = 35455;
        Integer brandId = 1;
        OffsetDateTime applicationDate = OffsetDateTime.parse("2020-06-14T10:00:00Z");
        PriceDTO mockPriceDTO = new PriceDTO(productId, brandId, 35.50, 1, applicationDate);

        // WHEN
        when(priceService.findFinalPrice(productId, brandId, applicationDate)).thenReturn(mockPriceDTO);
        ResponseEntity<GetPricesResponseDTO> response = priceController.getFinalPrices(productId, brandId, applicationDate);

        // THEN
        assertEquals(35.50, response.getBody().getPrice());
        assertEquals(productId, response.getBody().getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
    }

    /**
     * Test find price at 4 pm 14 th for brand 1.
     */
    @Test
    void testFindPrice_at4pm14th_forBrand1() {
        // GIVEN
        Integer productId = 35455;
        Integer brandId = 1;
        OffsetDateTime applicationDate = OffsetDateTime.parse("2020-06-14T16:00:00Z");
        PriceDTO mockPriceDTO = new PriceDTO(productId, brandId, 25.45, 2, applicationDate);

        // WHEN
        when(priceService.findFinalPrice(productId, brandId, applicationDate)).thenReturn(mockPriceDTO);
        ResponseEntity<GetPricesResponseDTO> response = priceController.getFinalPrices(productId, brandId, applicationDate);

        // THEN
        assertEquals(25.45, response.getBody().getPrice());
        assertEquals(productId, response.getBody().getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
    }

    /**
     * Test find price at 9 pm 14 th for brand 1.
     */
    @Test
    void testFindPrice_at9pm14th_forBrand1() {
        // GIVEN
        Integer productId = 35455;
        Integer brandId = 1;
        OffsetDateTime applicationDate = OffsetDateTime.parse("2020-06-14T21:00:00Z");
        PriceDTO mockPriceDTO = new PriceDTO(productId, brandId, 20.00, 3, applicationDate);

        // WHEN
        when(priceService.findFinalPrice(productId, brandId, applicationDate)).thenReturn(mockPriceDTO);
        ResponseEntity<GetPricesResponseDTO> response = priceController.getFinalPrices(productId, brandId, applicationDate);

        // THEN
        assertEquals(20.00, response.getBody().getPrice());
        assertEquals(productId, response.getBody().getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
    }

    /**
     * Test find price at 10 am 15 th for brand 1.
     */
    @Test
    void testFindPrice_at10am15th_forBrand1() {
        // GIVEN
        Integer productId = 35455;
        Integer brandId = 1;
        OffsetDateTime applicationDate = OffsetDateTime.parse("2020-06-15T10:00:00Z");
        PriceDTO mockPriceDTO = new PriceDTO(productId, brandId, 30.00, 4, applicationDate);

        // WHEN
        when(priceService.findFinalPrice(productId, brandId, applicationDate)).thenReturn(mockPriceDTO);
        ResponseEntity<GetPricesResponseDTO> response = priceController.getFinalPrices(productId, brandId, applicationDate);

        // THEN
        assertEquals(30.00, response.getBody().getPrice());
        assertEquals(productId, response.getBody().getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
    }

    /**
     * Test find price at 9 pm 16 th for brand 1.
     */
    @Test
    void testFindPrice_at9pm16th_forBrand1() {
        // GIVEN
        Integer productId = 35455;
        Integer brandId = 1;
        OffsetDateTime applicationDate = OffsetDateTime.parse("2020-06-16T21:00:00Z");
        PriceDTO mockPriceDTO = new PriceDTO(productId, brandId, 50.00, 5, applicationDate);

        // WHEN
        when(priceService.findFinalPrice(productId, brandId, applicationDate)).thenReturn(mockPriceDTO);
        ResponseEntity<GetPricesResponseDTO> response = priceController.getFinalPrices(productId, brandId, applicationDate);

        // THEN
        assertEquals(50.00, response.getBody().getPrice());
        assertEquals(productId, response.getBody().getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
    }
}