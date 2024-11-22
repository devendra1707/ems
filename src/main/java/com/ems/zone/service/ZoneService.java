package com.ems.zone.service;

import java.util.List;

import com.ems.zone.model.Zone;

public interface ZoneService {
	public Zone createZone(Zone zone);

	public Zone updateZone(int zoneId, Zone zone);

	public Zone getZoneById(int zoneId);

	public List<Zone> zoneList();

	public void deleteZone(int zoneId);
}
