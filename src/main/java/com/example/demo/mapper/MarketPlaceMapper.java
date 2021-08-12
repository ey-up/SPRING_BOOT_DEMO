package com.example.demo.mapper;

import com.example.demo.dto.MarketPlaceDto;
import com.example.demo.model.MarketPlace;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;



@Mapper(componentModel = "spring")
public interface MarketPlaceMapper {
	
	MarketPlaceMapper INSTANCE = Mappers.getMapper(MarketPlaceMapper.class);
	
	List<MarketPlaceDto> toDTOList(List<MarketPlace> marketPlaces) ;
	

	MarketPlaceDto toDTO(MarketPlace marketPlace);


	MarketPlace toEntity(MarketPlaceDto dto);
	

	void updatetoMarketPlace(@MappingTarget MarketPlaceDto dto, MarketPlace marketPlace);




}
