package com.ems.adg.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.adg.exception.AdgNotFoundException;
import com.ems.adg.model.Adg;
import com.ems.adg.payload.AdgDto;
import com.ems.adg.repo.AdgRepo;
import com.ems.adg.service.AdgService;
import com.ems.region.exception.RegionNotFoundException;
import com.ems.region.model.Region;
import com.ems.region.repo.RegionRepo;

@Service
public class AdgServiceImpl implements AdgService {

	private AdgRepo adgRepo;
	private RegionRepo regionRepo;
	private ModelMapper modelMapper;

	public AdgServiceImpl(AdgRepo adgRepo, ModelMapper modelMapper, RegionRepo regionRepo) {
		this.adgRepo = adgRepo;
		this.regionRepo = regionRepo;
		this.modelMapper = modelMapper;

	}

	@Override
	public AdgDto createAdg(AdgDto adgDto, int regionId) {

		Region region = regionRepo.findById(regionId)
				.orElseThrow(() -> new RegionNotFoundException("Region Not Found"));

		Adg adg = modelMapper.map(adgDto, Adg.class);
		adg.setRegion(region);
		Adg saveAdg = adgRepo.save(adg);

		return modelMapper.map(saveAdg, AdgDto.class);
	}

	@Override
	public AdgDto updateAdg(int adgId, AdgDto adg, int regionId) {

		Adg existingAdg = adgRepo.findById(adgId).orElseThrow(() -> new AdgNotFoundException("Adg Not found"));
		Region region = regionRepo.findById(regionId)
				.orElseThrow(() -> new RegionNotFoundException("Region Not Found"));

		existingAdg.setName(adg.getName());
		existingAdg.setRegion(region);
		Adg updateAdg = adgRepo.save(existingAdg);
		return modelMapper.map(updateAdg, AdgDto.class);
	}

	@Override
	public AdgDto getAdgById(int adgId) {
		Adg adg = adgRepo.findById(adgId).orElseThrow(() -> new AdgNotFoundException("Adg Not found"));
		return modelMapper.map(adg, AdgDto.class);
	}

	@Override
	public List<AdgDto> adgList() {

		List<Adg> adgList = adgRepo.findAll();
		List<AdgDto> adgDtos = adgList.stream().map(adg -> modelMapper.map(adg, AdgDto.class))
				.collect(Collectors.toList());

		return adgDtos;
	}

	@Override
	public void deleteAdg(int adgId) {

		if (!adgRepo.existsById(adgId)) {
			throw new AdgNotFoundException("Adg Not found");
		}
		adgRepo.deleteById(adgId);

	}

}
