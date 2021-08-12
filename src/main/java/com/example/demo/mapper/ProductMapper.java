package com.example.demo.mapper;


import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    Product toModel(ProductDto productDto);


    @InheritConfiguration
    void updateModel(ProductDto ProductDto, @MappingTarget Product Product);


    ProductDto toDto(Product product);

    List<ProductDto> toDtoList(List<Product> product);
    List<Product> toModelList(List<ProductDto> productDtos);

}


