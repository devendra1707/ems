package com.ems.payscale.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.payscale.exception.PayScaleNotFoundException;
import com.ems.payscale.model.PayScale;
import com.ems.payscale.payload.PayScaleDto;
import com.ems.payscale.repo.PayScaleRepo;
import com.ems.payscale.service.PayScaleService;

@Service
public class PayScaleServiceImpl implements PayScaleService {

	private PayScaleRepo payScaleRepo;
	private ModelMapper modelMapper;

	public PayScaleServiceImpl(PayScaleRepo payScaleRepo, ModelMapper modelMapper) {
		this.payScaleRepo = payScaleRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public PayScaleDto createPayScale(PayScaleDto payScaleDto) {
		PayScale payScale = modelMapper.map(payScaleDto, PayScale.class);
		PayScale savePayScale = payScaleRepo.save(payScale);
		return modelMapper.map(savePayScale, PayScaleDto.class);
	}

	@Override
	public PayScaleDto updatePayScale(int payScaleId, PayScaleDto payScaleDto) {
		PayScale payScale = payScaleRepo.findById(payScaleId)
				.orElseThrow(() -> new PayScaleNotFoundException("PayScale Not Found"));

		payScale.setGradePay(payScale.getGradePay());
		payScale.setLevel(payScale.getLevel());
		payScale.setScaleOfPay(payScale.getScaleOfPay());

		PayScale updaPayScale = payScaleRepo.save(payScale);

		return modelMapper.map(updaPayScale, PayScaleDto.class);
	}

	@Override
	public PayScaleDto getPayScale(int payScaleId) {

		PayScale payScale = payScaleRepo.findById(payScaleId)
				.orElseThrow(() -> new PayScaleNotFoundException("PayScale Not Found"));
		return modelMapper.map(payScale, PayScaleDto.class);
	}

	@Override
	public List<PayScaleDto> payScaleList() {
		List<PayScale> payScaleList = payScaleRepo.findAll();
		List<PayScaleDto> payScaleDtos = payScaleList.stream()
				.map((paySc) -> modelMapper.map(paySc, PayScaleDto.class)).collect(Collectors.toList());
		return payScaleDtos;
	}

	@Override
	public void deletePayScale(int payScaleId) {
		payScaleRepo.deleteById(payScaleId);
	}
}
