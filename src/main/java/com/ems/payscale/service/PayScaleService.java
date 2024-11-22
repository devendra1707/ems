package com.ems.payscale.service;

import java.util.List;

import com.ems.payscale.model.PayScale;

public interface PayScaleService {
	public PayScale createPayScale(PayScale payScale);

	public PayScale updatePayScale(int payScaleId, PayScale payScale);

	public PayScale getPayScale(int payScaleId);

	public List<PayScale> payScaleList();

	public void deletePayScale(int payScaleId);
}
