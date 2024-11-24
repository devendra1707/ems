package com.ems.payscale.payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PayScaleDto {

	private int payScaleId;

	private String scaleOfPay;

	private String level;

	private String gradePay;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

}
