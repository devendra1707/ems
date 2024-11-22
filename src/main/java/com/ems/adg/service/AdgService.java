package com.ems.adg.service;

import java.util.List;

import com.ems.adg.model.Adg;

public interface AdgService {

	public Adg createAdg(Adg adg);

	public Adg updateAdg(int adgId, Adg adg);

	public Adg getAdgById(int adgId);

	public List<Adg> adgList();

	public void deleteAdg(int adgId);

}
