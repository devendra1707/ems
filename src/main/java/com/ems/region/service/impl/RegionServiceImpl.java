package com.ems.region.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.region.exception.RegionNotFoundException;
import com.ems.region.model.Region;
import com.ems.region.repo.RegionRepo;
import com.ems.region.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
	private RegionRepo regionRepo;

	public RegionServiceImpl(RegionRepo regionRepo) {
		this.regionRepo = regionRepo;
	}

	@Override
	public Region createRegion(Region region) {

		Region createRegion = regionRepo.save(region);

		return createRegion;
	}

	@Override
	public Region updateRegion(int regionId, Region region) {
		Region getRegion = regionRepo.findById(regionId)
				.orElseThrow(() -> new RegionNotFoundException("Region Not found"));

		if (getRegion != null) {
			getRegion.setName(region.getName());
			regionRepo.save(getRegion);
		}

		return getRegion;
	}

	@Override
	public Region getRegionById(int regionId) {
		Region getRegion = regionRepo.findById(regionId)
				.orElseThrow(() -> new RegionNotFoundException("Region Not found"));
		return getRegion;
	}

	@Override
	public List<Region> regionList() {

		List<Region> regionList = regionRepo.findAll();

		return regionList;
	}

	@Override
	public void deleteRegion(int regionId) {

		regionRepo.deleteById(regionId);

	}
}
