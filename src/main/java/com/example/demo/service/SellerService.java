package com.example.demo.service;

import com.example.demo.dto.SellerDto;
import com.example.demo.mapper.SellerMapper;
import com.example.demo.model.Product;
import com.example.demo.model.Seller;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SellerRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SellerService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;


    public List<SellerDto> getSellers() {
        return SellerMapper.INSTANCE.toDtoList(sellerRepository.findAll());
    }

    public SellerDto createSeller(SellerDto sellerDto) {
        return SellerMapper.INSTANCE.toDto(sellerRepository.save(SellerMapper.INSTANCE.toModel(sellerDto)));

    }


}
