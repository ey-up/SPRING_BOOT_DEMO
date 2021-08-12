package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.mapper.ProductMapper;
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
public class ProductService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;


    public List<ProductDto> getProducts() {
        return ProductMapper.INSTANCE.toDtoList(productRepository.findAll());
    }

    public ProductDto createProduct(ProductDto productDto) {
        return ProductMapper.INSTANCE.toDto(productRepository.save(ProductMapper.INSTANCE.toModel(productDto)));

    }

    @Transactional
    public ProductDto addSellerToProduct(Long productId, Long sellerId) throws NotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = productOptional.orElseThrow(() -> new NotFoundException("Not Found Product " + productId));

        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        Seller seller = sellerOptional.orElseThrow(() -> new NotFoundException("Not Found Seller " + sellerId));

        seller.addProduct(product);
        return ProductMapper.INSTANCE.toDto(productRepository.save(product));
    }
}
