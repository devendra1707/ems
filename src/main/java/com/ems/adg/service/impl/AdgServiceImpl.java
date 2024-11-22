package com.ems.adg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.adg.exception.AdgNotFoundException;
import com.ems.adg.model.Adg;
import com.ems.adg.repo.AdgRepo;
import com.ems.adg.service.AdgService;

@Service
public class AdgServiceImpl implements AdgService {

	private AdgRepo adgRepo;

	public AdgServiceImpl(AdgRepo adgRepo) {
		this.adgRepo = adgRepo;
	}

	@Override
	public Adg createAdg(Adg adg) {

		Adg createAdg = adgRepo.save(adg);

		return createAdg;
	}

	@Override
	public Adg updateAdg(int adgId, Adg adg) {
		Adg getAdg = adgRepo.findById(adgId).orElseThrow(() -> new AdgNotFoundException("Adg Not found"));

		if (getAdg != null) {
			getAdg.setName(adg.getName());
			adgRepo.save(getAdg);
		}

		return getAdg;
	}

	@Override
	public Adg getAdgById(int adgId) {
		Adg getAdg = adgRepo.findById(adgId).orElseThrow(() -> new AdgNotFoundException("Adg Not found"));
		return getAdg;
	}

	@Override
	public List<Adg> adgList() {

		List<Adg> adgList = adgRepo.findAll();

		return adgList;
	}

	@Override
	public void deleteAdg(int adgId) {

		adgRepo.deleteById(adgId);

	}

}
