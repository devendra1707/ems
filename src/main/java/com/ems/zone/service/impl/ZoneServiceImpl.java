package com.ems.zone.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.adg.exception.AdgNotFoundException;
import com.ems.adg.model.Adg;
import com.ems.adg.repo.AdgRepo;
import com.ems.zone.exception.ZoneNotFoundException;
import com.ems.zone.model.Zone;
import com.ems.zone.payload.ZoneDto;
import com.ems.zone.repo.ZoneRepo;
import com.ems.zone.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService {
	private ZoneRepo zoneRepo;
	private ModelMapper modelMapper;
	private AdgRepo adgRepo;

	public ZoneServiceImpl(ZoneRepo zoneRepo, ModelMapper modelMapper, AdgRepo adgRepo) {
		this.zoneRepo = zoneRepo;
		this.modelMapper = modelMapper;
		this.adgRepo = adgRepo;
	}

	@Override
	public ZoneDto createZone(ZoneDto zoneDto, int adgId) {
		Adg adg = adgRepo.findById(adgId).orElseThrow(() -> new AdgNotFoundException("Adg Not Found"));

		Zone zone = modelMapper.map(zoneDto, Zone.class);
		zone.setAdg(adg);
		Zone saveZone = zoneRepo.save(zone);

		return modelMapper.map(saveZone, ZoneDto.class);
	}

	@Override
	public ZoneDto updateZone(int zoneId, ZoneDto zoneDto, int adgId) {
		Zone zone = zoneRepo.findById(zoneId).orElseThrow(() -> new ZoneNotFoundException("Zone Not found"));
		Adg adg = adgRepo.findById(adgId).orElseThrow(() -> new AdgNotFoundException("Adg Not Found"));

		zone.setName(zoneDto.getName());
		zone.setAdg(adg);
		Zone updateZone = zoneRepo.save(zone);

		return modelMapper.map(updateZone, ZoneDto.class);
	}

	@Override
	public ZoneDto getZoneById(int zoneId) {
		Zone getZone = zoneRepo.findById(zoneId).orElseThrow(() -> new ZoneNotFoundException("Zone Not found"));

		return modelMapper.map(getZone, ZoneDto.class);
	}

	@Override
	public List<ZoneDto> zoneList() {
		List<Zone> zones = zoneRepo.findAll();
		List<ZoneDto> zoneDtos = zones.stream().map((zone) -> modelMapper.map(zone, ZoneDto.class))
				.collect(Collectors.toList());

		return zoneDtos;
	}

	@Override
	public void deleteZone(int zoneId) {

		zoneRepo.deleteById(zoneId);

	}

}
