package com.ems.station.service;

import java.util.List;

import com.ems.station.payload.StationDto;

public interface StationService {
	public StationDto createStation(StationDto stationDto,int stateId);

	public StationDto updateStation(int stationId, StationDto stationDto,int stateId);

	public StationDto getStationById(int stationId);

	public List<StationDto> stationList();

	public void deleteStation(int stationId);
}
