package com.ems.state.service;

import java.util.List;

import com.ems.state.payload.StateDto;

public interface StateService {

	public StateDto createState(StateDto stateDto);

	public StateDto updateState(int stateId, StateDto stateDto);

	public StateDto getStateById(int stateId);

	public List<StateDto> stateList();

	public void deleteState(int stateId);

}
