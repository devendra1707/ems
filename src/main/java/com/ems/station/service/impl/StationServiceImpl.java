package com.ems.station.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.station.service.StationService;
import com.ems.station.exception.StationNotFoundException;
import com.ems.station.model.Station;
import com.ems.station.repo.StationRepo;

@Service
public class StationServiceImpl implements StationService {
	private StationRepo stationRepo;

	public StationServiceImpl(StationRepo stationRepo) {
		this.stationRepo = stationRepo;
	}

	@Override
	public Station createStation(Station station) {

		Station createStation = stationRepo.save(station);

		return createStation;
	}

	@Override
	public Station updateStation(int stationId, Station station) {
		Station getStation = stationRepo.findById(stationId)
				.orElseThrow(() -> new StationNotFoundException("Station Not found"));

		if (getStation != null) {
			getStation.setName(station.getName());
			stationRepo.save(getStation);
		}

		return getStation;
	}

	@Override
	public Station getStationById(int stationId) {
		Station getStation = stationRepo.findById(stationId)
				.orElseThrow(() -> new StationNotFoundException("Station Not found"));
		return getStation;
	}

	@Override
	public List<Station> stationList() {

		List<Station> stationList = stationRepo.findAll();

		return stationList;
	}

	@Override
	public void deleteStation(int stationId) {

		stationRepo.deleteById(stationId);

	}
}
