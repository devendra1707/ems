package com.ems.zone.service;

import java.util.List;

import com.ems.zone.payload.ZoneDto;

public interface ZoneService {
	public ZoneDto createZone(ZoneDto zoneDto, int adgId);

	public ZoneDto updateZone(int zoneId, ZoneDto zoneDto, int adgId);

	public ZoneDto getZoneById(int zoneId);

	public List<ZoneDto> zoneList();

	public void deleteZone(int zoneId);
}
