package com.ecommerce.inditex.apirest.mapper;

import org.mapstruct.Mapper;

import com.ecommerce.inditex.apirest.dto.PriceDTO;
import com.ecommerce.inditex.domain.entities.PriceEntity;
import com.ecommerce.inditex.domain.valueobjects.PriceValueObject;



/**
 * The Interface PriceMapper.
 */
@Mapper(componentModel = "spring")
public interface PriceMapper {

    /**
     * To entity.
     *
     * @param priceDTO the price DTO
     * @return the price entity
     */
    PriceEntity toEntity(PriceDTO priceDTO);


    /**
     * To DTO.
     *
     * @param priceEntity the price entity
     * @return the price DTO
     */
    PriceDTO toDTO(PriceEntity priceEntity);


    /**
     * To value object.
     *
     * @param priceDTO the price entity
     * @return the price value object
     */
    PriceValueObject toValueObject(PriceDTO priceDTO);


    /**
     * To entity.
     *
     * @param priceValueObject the price value object
     * @return the price entity
     */
    PriceEntity toEntity(PriceValueObject priceValueObject);
}
