package com.ems.region.service;

import java.util.List;

import com.ems.region.model.Region;

public interface RegionService {
	public Region createRegion(Region region);

	public Region updateRegion(int regionId, Region region);

	public Region getRegionById(int regionId);

	public List<Region> regionList();

	public void deleteRegion(int regionId);
}
