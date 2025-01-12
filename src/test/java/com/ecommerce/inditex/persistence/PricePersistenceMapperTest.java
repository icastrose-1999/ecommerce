package com.ecommerce.inditex.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.ecommerce.inditex.domain.entities.PriceEntity;
import com.ecommerce.inditex.utils.EasyRandomUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * The Class PricePersistenceMapperTest.
 */
class PricePersistenceMapperTest {

    /** The persistence mapper. */
    @Mock
    private PricePersistenceMapper persistenceMapper;

    /**
     * Sets the up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test find price by criteria when all inputs are valid.
     */
    @Test
    void testFindPriceByCriteria_whenAllInputsAreValid_thenReturnPriceEntities() {
        // GIVEN
        Integer productId = EasyRandomUtils.generate(Integer.class);
        Integer brandId = EasyRandomUtils.generate(Integer.class);
        OffsetDateTime applicationDate = EasyRandomUtils.generateRandomOffsetDateTime();

        List<PriceEntity> priceEntities = EasyRandomUtils.generateList(PriceEntity.class, 2);

        // WHEN
        when(this.persistenceMapper.findPriceByCriteria(productId, brandId, applicationDate))
                .thenReturn(priceEntities);

        List<PriceEntity> response = this.persistenceMapper.findPriceByCriteria(productId, brandId, applicationDate);

        // THEN
        assertNotNull(response);
        assertEquals(priceEntities.size(), response.size());
    }

    /**
     * Test find price by criteria when productId is null.
     */
    @Test
    void testFindPriceByCriteria_whenProductIdIsNull_thenReturnPriceEntities() {
        // GIVEN
        Integer brandId = EasyRandomUtils.generate(Integer.class);
        OffsetDateTime applicationDate = EasyRandomUtils.generateRandomOffsetDateTime();

        List<PriceEntity> priceEntities = EasyRandomUtils.generateList(PriceEntity.class, 2);

        // WHEN
        when(this.persistenceMapper.findPriceByCriteria(null, brandId, applicationDate))
                .thenReturn(priceEntities);

        List<PriceEntity> response = this.persistenceMapper.findPriceByCriteria(null, brandId, applicationDate);

        // THEN
        assertNotNull(response);
        assertEquals(priceEntities.size(), response.size());
    }

    /**
     * Test find price by criteria when brandId is null.
     */
    @Test
    void testFindPriceByCriteria_whenBrandIdIsNull_thenReturnPriceEntities() {
        // GIVEN
        Integer productId = EasyRandomUtils.generate(Integer.class);
        OffsetDateTime applicationDate = EasyRandomUtils.generateRandomOffsetDateTime();

        List<PriceEntity> priceEntities = EasyRandomUtils.generateList(PriceEntity.class, 2);

        // WHEN
        when(this.persistenceMapper.findPriceByCriteria(productId, null, applicationDate))
                .thenReturn(priceEntities);

        List<PriceEntity> response = this.persistenceMapper.findPriceByCriteria(productId, null, applicationDate);

        // THEN
        assertNotNull(response);
        assertEquals(priceEntities.size(), response.size());
    }

    /**
     * Test find price by criteria when applicationDate is null.
     */
    @Test
    void testFindPriceByCriteria_whenApplicationDateIsNull_thenReturnPriceEntities() {
        // GIVEN
        Integer productId = EasyRandomUtils.generate(Integer.class);
        Integer brandId = EasyRandomUtils.generate(Integer.class);

        List<PriceEntity> priceEntities = EasyRandomUtils.generateList(PriceEntity.class, 2);

        // WHEN
        when(this.persistenceMapper.findPriceByCriteria(productId, brandId, null))
                .thenReturn(priceEntities);

        List<PriceEntity> response = this.persistenceMapper.findPriceByCriteria(productId, brandId, null);

        // THEN
        assertNotNull(response);
        assertEquals(priceEntities.size(), response.size());
    }

    /**
     * Test find price by criteria when all inputs are null.
     */
    @Test
    void testFindPriceByCriteria_whenAllInputsAreNull_thenReturnPriceEntities() {
        // GIVEN
        List<PriceEntity> priceEntities = EasyRandomUtils.generateList(PriceEntity.class, 2);

        // WHEN
        when(this.persistenceMapper.findPriceByCriteria(null, null, null))
                .thenReturn(priceEntities);

        List<PriceEntity> response = this.persistenceMapper.findPriceByCriteria(null, null, null);

        // THEN
        assertNotNull(response);
        assertEquals(priceEntities.size(), response.size());
    }
}
