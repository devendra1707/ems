package com.ems.region.service;

import java.util.List;

import com.ems.region.payload.RegionDto;

public interface RegionService {
	public RegionDto createRegion(RegionDto regionDto);

	public RegionDto updateRegion(int regionId, RegionDto regionDto);

	public RegionDto getRegionById(int regionId);

	public List<RegionDto> regionList();

	public void deleteRegion(int regionId);
}
