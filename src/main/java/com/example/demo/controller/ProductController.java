package com.example.demo.controller;


import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.createProduct(productDto));
    }
    @PutMapping
    public ResponseEntity<ProductDto> addSellerToProduct(@RequestParam Long productId, @RequestParam Long sellerId ) throws NotFoundException {
       return  ResponseEntity.ok(productService.addSellerToProduct(productId,sellerId));

    }

}
