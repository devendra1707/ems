package com.ems.station.service;

import java.util.List;

import com.ems.station.model.Station;

public interface StationService {
	public Station createStation(Station station);

	public Station updateStation(int stationId, Station station);

	public Station getStationById(int stationId);

	public List<Station> stationList();

	public void deleteStation(int stationId);
}
