package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.MarketPlaceDto;
import com.example.demo.dto.SellerDto;
import com.example.demo.mapper.MarketPlaceMapper;
import com.example.demo.model.MarketPlace;
import com.example.demo.repository.MarketPlaceRepository;

import javassist.NotFoundException;

@Service
public class MarketPlaceService {
	@Autowired
	private MarketPlaceRepository marketPlaceRepository;
	
	@Autowired
	private MarketPlaceMapper marketPlaceMapper;
	
	public List<MarketPlaceDto> getAll() {
		return marketPlaceMapper.toDTOList(marketPlaceRepository.findAll());
	}

	public MarketPlaceDto getMarketPlace(@RequestBody Long id) throws ExecutionException, InterruptedException, NotFoundException {
		Optional<MarketPlace> marketPlaceOptional = marketPlaceRepository.findById(id);
		MarketPlace marketPlace = marketPlaceOptional.orElseThrow(()-> new NotFoundException("MarketPlace not found"));
		return marketPlaceMapper.toDTO(marketPlace);
	}

	public Long createMarketPlace(@RequestBody MarketPlaceDto dto) throws ExecutionException, InterruptedException, NotFoundException {
		MarketPlace marketPlace = marketPlaceMapper.toEntity(dto);
		marketPlaceRepository.save(marketPlace);
		return marketPlace.getId();
	}

	public String updateMarketPlace(@RequestBody MarketPlaceDto dto, Long id) throws ExecutionException, InterruptedException, NotFoundException {
		Optional<MarketPlace> marketPlaceOptional = marketPlaceRepository.findById(id);
		MarketPlace marketPlace = marketPlaceOptional.orElseThrow(()-> new NotFoundException("MarketPlace not found"));
		marketPlaceMapper.updatetoMarketPlace(dto, marketPlace);
		marketPlaceRepository.saveAndFlush(marketPlace);
		return "success";
	}

	public String deleteMarketPlace(@RequestBody Long id) throws ExecutionException, InterruptedException, NotFoundException {
		Optional<MarketPlace> marketPlaceOptional = marketPlaceRepository.findById(id);
		MarketPlace marketPlace = marketPlaceOptional.orElseThrow(()-> new NotFoundException("course not found"));
		marketPlaceRepository.delete(marketPlace);
		return "success";
	}

	/*public List<SellerDto> getSetllersOfMarketPlace(@RequestBody Long id) throws ExecutionException, InterruptedException, NotFoundException {
		Optional<MarketPlace> marketPlaceOptional = marketPlaceRepository.findById(id);
		MarketPlace marketPlace = marketPlaceOptional.orElseThrow(()-> new NotFoundException("MarketPlace not found"));
		return marketPlaceMapper.toDTOSellers(marketPlace);
	}*/

}
