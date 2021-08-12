package com.example.demo.controller;


import com.example.demo.dto.MarketPlaceDto;
import com.example.demo.service.MarketPlaceService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("market-places")
public class MarketPlaceController {
	@Autowired
	private MarketPlaceService MarketPlaceService;
	
	@GetMapping
	public List<MarketPlaceDto> getAll() throws ExecutionException, InterruptedException {
		return MarketPlaceService.getAll();
	}
	@GetMapping("/{id}")
	public MarketPlaceDto getMarketPlace(@PathVariable Long id) throws ExecutionException, InterruptedException, NotFoundException {
		return MarketPlaceService.getMarketPlace(id);
		
	}
	@PostMapping
	public Long createMarketPlace(@RequestBody MarketPlaceDto dto) throws ExecutionException, InterruptedException, NotFoundException {
		return MarketPlaceService.createMarketPlace(dto);
	}
	@PostMapping("/{id}")
	public String updateMarketPlace(@RequestBody MarketPlaceDto dto, Long id) throws ExecutionException, InterruptedException, NotFoundException {
		return MarketPlaceService.updateMarketPlace(dto, id);
	}
	@DeleteMapping("/{id}")
	public String deleteMarketPlace(@RequestBody Long id) throws ExecutionException, InterruptedException, NotFoundException {
		return MarketPlaceService.deleteMarketPlace(id);
	}
	/* @GetMapping("/{id}")
	public List<SellerDto> getSellersOfMarketPlace(@RequestBody Long id) throws ExecutionException, InterruptedException, NotFoundException{
		return MarketPlaceService.getSetllersOfMarketPlace(id);
	}*/

}