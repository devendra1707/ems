package com.ems.station.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.state.exception.StateNotFoundException;
import com.ems.state.model.State;
import com.ems.state.repo.StateRepo;
import com.ems.station.exception.StationNotFoundException;
import com.ems.station.model.Station;
import com.ems.station.payload.StationDto;
import com.ems.station.repo.StationRepo;
import com.ems.station.service.StationService;

@Service
public class StationServiceImpl implements StationService {
	private StationRepo stationRepo;
	private ModelMapper modelMapper;
	private StateRepo stateRepo;

	public StationServiceImpl(StationRepo stationRepo, ModelMapper modelMapper, StateRepo stateRepo) {
		this.stationRepo = stationRepo;
		this.modelMapper = modelMapper;
		this.stateRepo = stateRepo;
	}

	@Override
	public StationDto createStation(StationDto stationDto, int stateId) {

		State state = stateRepo.findById(stateId).orElseThrow(() -> new StateNotFoundException("State Not Found"));

		Station station = modelMapper.map(stationDto, Station.class);
		station.setState(state);
		Station saveStation = stationRepo.save(station);
		return modelMapper.map(saveStation, StationDto.class);
	}

	@Override
	public StationDto updateStation(int stationId, StationDto stationDto, int stateId) {
		Station station = stationRepo.findById(stationId)
				.orElseThrow(() -> new StationNotFoundException("Station Not found"));

		State state = stateRepo.findById(stateId).orElseThrow(() -> new StateNotFoundException("State Not Found"));

		station.setName(stationDto.getName());
		station.setState(state);
		Station updateStation = stationRepo.save(station);

		return modelMapper.map(updateStation, StationDto.class);
	}

	@Override
	public StationDto getStationById(int stationId) {
		Station station = stationRepo.findById(stationId)
				.orElseThrow(() -> new StationNotFoundException("Station Not found"));
		return modelMapper.map(station, StationDto.class);
	}

	@Override
	public List<StationDto> stationList() {

		List<Station> stations = stationRepo.findAll();
		List<StationDto> stationDtos = stations.stream().map((station) -> modelMapper.map(station, StationDto.class))
				.collect(Collectors.toList());
		return stationDtos;
	}

	@Override
	public void deleteStation(int stationId) {

		stationRepo.deleteById(stationId);

	}

}
