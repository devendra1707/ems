package com.ems.state.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.state.exception.StateNotFoundException;
import com.ems.state.model.State;
import com.ems.state.payload.StateDto;
import com.ems.state.repo.StateRepo;
import com.ems.state.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	private StateRepo stateRepo;
	private ModelMapper modelMapper;

	public StateServiceImpl(StateRepo stateRepo, ModelMapper modelMapper) {
		this.stateRepo = stateRepo;
		this.modelMapper = modelMapper;

	}

	@Override
	public StateDto createState(StateDto stateDto) {

		State state = modelMapper.map(stateDto, State.class);
		State saveState = stateRepo.save(state);
		return modelMapper.map(saveState, StateDto.class);
	}

	@Override
	public StateDto updateState(int stateId, StateDto stateDto) {
		State state = stateRepo.findById(stateId).orElseThrow(() -> new StateNotFoundException("State Not found"));

		state.setName(stateDto.getName());
		state.setAboutState(stateDto.getAboutState());
		state.setPath(stateDto.getPath());
		state.setTotalOffices(stateDto.getTotalOffices());
		state.setTotalProjects(stateDto.getTotalProjects());
		state.setTotalProjectsCompleted(stateDto.getTotalProjectsCompleted());
		state.setStateCode(stateDto.getStateCode());
		State updateState = stateRepo.save(state);

		return modelMapper.map(updateState, StateDto.class);
	}

	@Override
	public StateDto getStateById(int stateId) {
		State state = stateRepo.findById(stateId).orElseThrow(() -> new StateNotFoundException("State Not found"));
		return modelMapper.map(state, StateDto.class);
	}

	@Override
	public List<StateDto> stateList() {

		List<State> states = stateRepo.findAll();
		List<StateDto> stateDtos = states.stream().map((state) -> modelMapper.map(state, StateDto.class))
				.collect(Collectors.toList());
		return stateDtos;
	}

	@Override
	public void deleteState(int stateId) {

		stateRepo.deleteById(stateId);

	}
}
