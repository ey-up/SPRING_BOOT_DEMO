package com.example.demo.repository;

import com.example.demo.model.MarketPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketPlaceRepository extends JpaRepository<MarketPlace, Long> {
  
}
