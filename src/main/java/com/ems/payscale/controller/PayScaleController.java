package com.ems.payscale.controller;

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

import com.ems.payscale.payload.PayScaleDto;
import com.ems.payscale.service.PayScaleService;

@RestController
@RequestMapping("/payScale")
public class PayScaleController {
	private PayScaleService payScaleService;

	public PayScaleController(PayScaleService payScaleService) {
		this.payScaleService = payScaleService;
	}

	// Create PayScale

	@PostMapping("/create")
	public ResponseEntity<PayScaleDto> createPayScale(@RequestBody PayScaleDto payScale) {
		PayScaleDto createPayScale = payScaleService.createPayScale(payScale);

		return new ResponseEntity<PayScaleDto>(createPayScale, HttpStatus.CREATED);
	}

	// Update PayScale

	@PutMapping("/update/{payScaleId}")
	public ResponseEntity<PayScaleDto> updatePayScale(@PathVariable("payScaleId") int payScaleId,
			@RequestBody PayScaleDto payScale) {
		PayScaleDto updatePayScale = payScaleService.updatePayScale(payScaleId, payScale);
		return new ResponseEntity<PayScaleDto>(updatePayScale, HttpStatus.OK);
	}

	// Get PayScale By Id

	@GetMapping("/{payScaleId}")
	public ResponseEntity<PayScaleDto> getPayScaleById(@PathVariable("payScaleId") int payScaleId) {
		PayScaleDto getPayScale = payScaleService.getPayScale(payScaleId);
		return new ResponseEntity<PayScaleDto>(getPayScale, HttpStatus.OK);
	}

	// Get All PayScale

	@GetMapping("/")
	public ResponseEntity<List<PayScaleDto>> getAllPayScale() {
		List<PayScaleDto> payScaleList = payScaleService.payScaleList();
		return new ResponseEntity<List<PayScaleDto>>(payScaleList, HttpStatus.OK);
	}

	// Delete PayScale

	@DeleteMapping("/{payScaleId}")
	public void deletePayScale(@PathVariable("payScaleId") int payScaleId) {
		payScaleService.deletePayScale(payScaleId);
	}
}
