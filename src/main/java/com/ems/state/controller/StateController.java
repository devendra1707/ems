package com.ems.state.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.state.payload.StateDto;
import com.ems.state.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {

	private StateService stateService;

	public StateController(StateService stateService) {
		this.stateService = stateService;
	}

	// Create State
	@PostMapping("/create")
	public ResponseEntity<StateDto> createState(@RequestBody StateDto stateDto) {
		StateDto createState = stateService.createState(stateDto);

		return new ResponseEntity<StateDto>(createState, HttpStatus.CREATED);
	}

	// update State
	@PutMapping("/update/{stateId}")
	public ResponseEntity<StateDto> updateState(@PathVariable("stateId") int stateId,
			@RequestBody StateDto stateDto) {
		StateDto updateState = stateService.updateState(stateId, stateDto);
		return new ResponseEntity<StateDto>(updateState, HttpStatus.OK);
	}

	// Get State By Id
	@GetMapping("/get/{stateId}")
	public ResponseEntity<StateDto> getStateById(@PathVariable("stateId") int stateId) {
		StateDto getState = stateService.getStateById(stateId);
		return new ResponseEntity<StateDto>(getState, HttpStatus.OK);
	}

	// Get All State

	@GetMapping("/all")
	public ResponseEntity<List<StateDto>> getAllState() {
		List<StateDto> stateList = stateService.stateList();
		return new ResponseEntity<List<StateDto>>(stateList, HttpStatus.OK);
	}

	// Delete State
	@DeleteMapping("/delete/{stateId}")
	public void deleteState(@PathVariable("stateId") int stateId) {
		stateService.deleteState(stateId);
	}
}
