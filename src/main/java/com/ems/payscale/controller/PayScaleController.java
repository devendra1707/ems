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

import com.ems.payscale.model.PayScale;
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
	public ResponseEntity<PayScale> createPayScale(@RequestBody PayScale payScale) {
		PayScale createPayScale = payScaleService.createPayScale(payScale);

		return new ResponseEntity<PayScale>(createPayScale, HttpStatus.CREATED);
	}

	// Update PayScale

	@PutMapping("/update/{payScaleId}")
	public ResponseEntity<PayScale> updatePayScale(@PathVariable("payScaleId") int payScaleId,
			@RequestBody PayScale payScale) {
		PayScale updatePayScale = payScaleService.updatePayScale(payScaleId, payScale);
		return new ResponseEntity<PayScale>(updatePayScale, HttpStatus.OK);
	}

	// Get PayScale By Id

	@GetMapping("/{payScaleId}")
	public ResponseEntity<PayScale> getPayScaleById(@PathVariable("payScaleId") int payScaleId) {
		PayScale getPayScale = payScaleService.getPayScale(payScaleId);
		return new ResponseEntity<PayScale>(getPayScale, HttpStatus.OK);
	}

	// Get All PayScale

	@GetMapping("/")
	public ResponseEntity<List<PayScale>> getAllPayScale() {
		List<PayScale> payScaleList = payScaleService.payScaleList();
		return new ResponseEntity<List<PayScale>>(payScaleList, HttpStatus.OK);
	}

	// Delete PayScale

	@DeleteMapping("/{payScaleId}")
	public void deletePayScale(@PathVariable("payScaleId") int payScaleId) {
		payScaleService.deletePayScale(payScaleId);
	}
}
