package com.hackaton.cbft.Model;

import java.math.BigDecimal;

public class PaymentRequest {
	
	private Long requestId;
	private Long sourceAccountId;
	private BigDecimal sourceAmount;
	private String sourceCurrency;
	private Long destAccountId;
	
	
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getSourceAccountId() {
		return sourceAccountId;
	}
	public void setSourceAccountId(Long sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}
	public BigDecimal getSourceAmount() {
		return sourceAmount;
	}
	public void setSourceAmount(BigDecimal sourceAmount) {
		this.sourceAmount = sourceAmount;
	}
	public String getSourceCurrency() {
		return sourceCurrency;
	}
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}
	public Long getDestAccountId() {
		return destAccountId;
	}
	public void setDestAccountId(Long destAccountId) {
		this.destAccountId = destAccountId;
	}
	
	

}
