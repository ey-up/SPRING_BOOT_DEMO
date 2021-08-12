package com.example.demo.mapper;


import com.example.demo.dto.SellerDto;
import com.example.demo.model.Seller;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);


    Seller toModel(SellerDto sellerDto);


    @InheritConfiguration
    void updateModel(SellerDto SellerDto, @MappingTarget Seller Seller);


    SellerDto toDto(Seller Seller);

    List<SellerDto> toDtoList(List<Seller> Seller);
    List<Seller> toModelList(List<SellerDto> SellerDtos);

}

