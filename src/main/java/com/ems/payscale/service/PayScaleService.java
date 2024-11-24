package com.ems.payscale.service;

import java.util.List;

import com.ems.payscale.payload.PayScaleDto;

public interface PayScaleService {
	public PayScaleDto createPayScale(PayScaleDto payScaleDto);

	public PayScaleDto updatePayScale(int payScaleId, PayScaleDto payScaleDto);

	public PayScaleDto getPayScale(int payScaleId);

	public List<PayScaleDto> payScaleList();

	public void deletePayScale(int payScaleId);
}
