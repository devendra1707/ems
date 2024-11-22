package com.ems.zone.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.zone.exception.ZoneNotFoundException;
import com.ems.zone.model.Zone;
import com.ems.zone.repo.ZoneRepo;
import com.ems.zone.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService {
	private ZoneRepo zoneRepo;

	public ZoneServiceImpl(ZoneRepo zoneRepo) {
		this.zoneRepo = zoneRepo;
	}

	@Override
	public Zone createZone(Zone zone) {

		Zone createZone = zoneRepo.save(zone);

		return createZone;
	}

	@Override
	public Zone updateZone(int zoneId, Zone zone) {
		Zone getZone = zoneRepo.findById(zoneId)
				.orElseThrow(() -> new ZoneNotFoundException("Zone Not found"));

		if (getZone != null) {
			getZone.setName(zone.getName());
			zoneRepo.save(getZone);
		}

		return getZone;
	}

	@Override
	public Zone getZoneById(int zoneId) {
		Zone getZone = zoneRepo.findById(zoneId)
				.orElseThrow(() -> new ZoneNotFoundException("Zone Not found"));
		return getZone;
	}

	@Override
	public List<Zone> zoneList() {

		List<Zone> zoneList = zoneRepo.findAll();

		return zoneList;
	}

	@Override
	public void deleteZone(int zoneId) {

		zoneRepo.deleteById(zoneId);

	}
}
