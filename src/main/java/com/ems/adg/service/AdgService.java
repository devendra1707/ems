package com.ems.adg.service;

import java.util.List;

import com.ems.adg.payload.AdgDto;

public interface AdgService {

	public AdgDto createAdg(AdgDto adgDto, int regionId);

	public AdgDto updateAdg(int adgId, AdgDto adgDto, int regionId);

	public AdgDto getAdgById(int adgId);

	public List<AdgDto> adgList();

	public void deleteAdg(int adgId);

}
