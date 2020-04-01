package com.hackaton.cbft.Model;

import java.math.BigDecimal;

public class PaymentResponse {

	
	private BigDecimal sourceAmount;
	private String sourceCurrency;
	private BigDecimal exchangeRate;
	private BigDecimal proceesingFee;
	private BigDecimal finalAmount;
	
	
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
	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public BigDecimal getProceesingFee() {
		return proceesingFee;
	}
	public void setProceesingFee(BigDecimal proceesingFee) {
		this.proceesingFee = proceesingFee;
	}
	public BigDecimal getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}
	
	
}
