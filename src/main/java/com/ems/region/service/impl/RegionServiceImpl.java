package com.ems.region.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.region.exception.RegionNotFoundException;
import com.ems.region.model.Region;
import com.ems.region.payload.RegionDto;
import com.ems.region.repo.RegionRepo;
import com.ems.region.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
	private RegionRepo regionRepo;
	private ModelMapper modelMapper;

	public RegionServiceImpl(RegionRepo regionRepo, ModelMapper modelMapper) {
		this.regionRepo = regionRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public RegionDto createRegion(RegionDto regionDto) {
		Region region = modelMapper.map(regionDto, Region.class);
		Region saveRegion = regionRepo.save(region);

		return modelMapper.map(saveRegion, RegionDto.class);
	}

	@Override
	public RegionDto updateRegion(int regionId, RegionDto regionDto) {
		Region region = regionRepo.findById(regionId)
				.orElseThrow(() -> new RegionNotFoundException("Region Not found"));

		region.setName(region.getName());

		Region updaRegion = regionRepo.save(region);

		return modelMapper.map(updaRegion, RegionDto.class);
	}

	@Override
	public RegionDto getRegionById(int regionId) {
		Region getRegion = regionRepo.findById(regionId)
				.orElseThrow(() -> new RegionNotFoundException("Region Not found"));
		return modelMapper.map(getRegion, RegionDto.class);
	}

	@Override
	public List<RegionDto> regionList() {

		List<Region> regionList = regionRepo.findAll();
		List<RegionDto> regionDtos = regionList.stream().map((region) -> modelMapper.map(region, RegionDto.class))
				.collect(Collectors.toList());
		return regionDtos;
	}

	@Override
	public void deleteRegion(int regionId) {

		regionRepo.deleteById(regionId);

	}
}
