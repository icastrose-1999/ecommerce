package com.ecommerce.inditex.apirest.mapper;

import org.mapstruct.Mapper;

import com.ecommerce.inditex.apirest.dto.PriceDTO;
import com.ecommerce.inditex.domain.entities.PriceEntity;



/**
 * The Interface PriceMapper.
 */
@Mapper(componentModel = "spring")
public interface PriceMapper {

    /**
     * To DTO.
     *
     * @param priceEntity the price entity
     * @return the price DTO
     */
    PriceDTO toDTO(PriceEntity priceEntity);
}
