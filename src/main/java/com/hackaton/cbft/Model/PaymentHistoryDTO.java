package com.hackaton.cbft.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentHistoryDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private Long requestId;
	private Long sourceAccountId;
	private BigDecimal sourceAmount;
	private String sourceCurrency;
	private Long destAccountId;
	private BigDecimal exchangeRate;
	private BigDecimal proceesingFee;
	private BigDecimal finalAmount;
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
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
