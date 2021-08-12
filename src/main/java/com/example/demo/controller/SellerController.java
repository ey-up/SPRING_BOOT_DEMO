package com.example.demo.controller;


import com.example.demo.dto.SellerDto;
import com.example.demo.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Seller")
public class SellerController {

    private final SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellerDto>> getSellers() {
        return ResponseEntity.ok(sellerService.getSellers());
    }

    @PostMapping
    public ResponseEntity<SellerDto> createSeller(@RequestBody SellerDto SellerDto ) {
        return ResponseEntity.ok(sellerService.createSeller(SellerDto));
    }


}
