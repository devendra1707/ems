package com.ems.payscale.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.payscale.exception.PayScaleNotFoundException;
import com.ems.payscale.model.PayScale;
import com.ems.payscale.repo.PayScaleRepo;
import com.ems.payscale.service.PayScaleService;

@Service
public class PayScaleServiceImpl implements PayScaleService {

	private PayScaleRepo payScaleRepo;

	public PayScaleServiceImpl(PayScaleRepo payScaleRepo) {
		this.payScaleRepo = payScaleRepo;
	}

	@Override
	public PayScale createPayScale(PayScale payScale) {
		PayScale createPayScale = payScaleRepo.save(payScale);
		return createPayScale;
	}

	@Override
	public PayScale updatePayScale(int payScaleId, PayScale payScale) {
		PayScale getPayScale = payScaleRepo.findById(payScaleId)
				.orElseThrow(() -> new PayScaleNotFoundException("PayScale Not Found"));
		if (getPayScale != null) {

			getPayScale.setGradePay(payScale.getGradePay());
			getPayScale.setLevel(payScale.getLevel());
			getPayScale.setScaleOfPay(payScale.getScaleOfPay());
			payScaleRepo.save(getPayScale);
		}

		return getPayScale;
	}

	@Override
	public PayScale getPayScale(int payScaleId) {

		PayScale getPayScale = payScaleRepo.findById(payScaleId)
				.orElseThrow(() -> new PayScaleNotFoundException("PayScale Not Found"));
		return getPayScale;
	}

	@Override
	public List<PayScale> payScaleList() {
		List<PayScale> payScaleList = payScaleRepo.findAll();
		return payScaleList;
	}

	@Override
	public void deletePayScale(int payScaleId) {
		payScaleRepo.deleteById(payScaleId);
	}
}
