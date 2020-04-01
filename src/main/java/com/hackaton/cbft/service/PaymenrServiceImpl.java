package com.hackaton.cbft.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.cbft.Constants.Constants;
import com.hackaton.cbft.Model.PaymentHistoryDTO;
import com.hackaton.cbft.Model.PaymentRequest;
import com.hackaton.cbft.Model.PaymentResponse;
import com.hackaton.cbft.exceptions.DailyLimitException;
import com.hackaton.cbft.exceptions.DestinationAccountNotFoundException;
import com.hackaton.cbft.repository.PaymentHistory;

@Service
public class PaymenrServiceImpl implements PaymentService {

	@Autowired
	PaymentHistory paymentHistory;
	
	Map<String, String> destinationAccountMap = new HashMap<>();
	Map<String, BigDecimal> roiMap = new HashMap<>();

	@Override
	public PaymentResponse processPayment(PaymentRequest paymentRequest) {
		updateDestinationAccounts();
		updateRateOfExchange();
		System.out.println(paymentRequest);
		PaymentResponse paymentResponse = new PaymentResponse();
		Long destinationAccountId = (Long) paymentRequest.getDestAccountId();
		if (!(destinationAccountMap.get("destAccountId").toString().equals(destinationAccountId.toString())))
		{
			System.out.println(destinationAccountMap.get("destAccountId"));
			throw new DestinationAccountNotFoundException();
		}
		if (paymentRequest.getSourceAmount().compareTo(new BigDecimal(Constants.DAILY_LIMIT)) == 1) {
			throw new DailyLimitException();
		}
		String destCurrency = destinationAccountMap.get("currency");
		BigDecimal convertedAmount = calculateRateOfExchange(paymentRequest.getSourceAmount(), roiMap.get(destCurrency));
		BigDecimal processingFee = calculateProcessingFee(convertedAmount);
		BigDecimal finalAmount = convertedAmount.subtract(processingFee);
		paymentResponse.setFinalAmount(finalAmount);
		paymentResponse.setProceesingFee(processingFee);
		paymentResponse.setSourceAmount(paymentRequest.getSourceAmount());
		paymentResponse.setSourceCurrency(paymentRequest.getSourceCurrency());
		paymentResponse.setExchangeRate(roiMap.get(destCurrency));
		saveTransactionHistory(paymentRequest,paymentResponse);
		return paymentResponse;
	}

	private void saveTransactionHistory(PaymentRequest paymentRequest, PaymentResponse paymentResponse) {
		PaymentHistoryDTO paymentHistoryDTO = new PaymentHistoryDTO();
		paymentHistoryDTO.setDestAccountId(paymentRequest.getDestAccountId());
		paymentHistoryDTO.setExchangeRate(paymentResponse.getExchangeRate());
		paymentHistoryDTO.setFinalAmount(paymentResponse.getFinalAmount());
		paymentHistoryDTO.setProceesingFee(paymentResponse.getProceesingFee());
		paymentHistoryDTO.setRequestId(paymentRequest.getRequestId());
		paymentHistoryDTO.setSourceAccountId(paymentRequest.getSourceAccountId());
		paymentHistoryDTO.setSourceAmount(paymentRequest.getSourceAmount());
		paymentHistoryDTO.setSourceCurrency(paymentRequest.getSourceCurrency());
		
		paymentHistory.save(paymentHistoryDTO);
		
	}

	private BigDecimal calculateRateOfExchange(BigDecimal sourceCurrency, BigDecimal currencyValue) {
		return sourceCurrency.multiply(currencyValue);
	}

	private BigDecimal calculateProcessingFee(BigDecimal actualAmount) {
		if (actualAmount.intValue() >= 1 || actualAmount.intValue() <= 1000) {
			return new BigDecimal(actualAmount.doubleValue() * Constants.zeroPFourPercent);
		} else if (actualAmount.intValue() >= 1001 || actualAmount.intValue() <= 2500) {
			return new BigDecimal(actualAmount.doubleValue() * Constants.zeroPThreePercent);
		} else if (actualAmount.intValue() >= 2500 || actualAmount.intValue() <= 5000) {
			return new BigDecimal(actualAmount.doubleValue() * Constants.zeroPTwoPercent);

		} else if (actualAmount.intValue() >= 5001) {
			return new BigDecimal(actualAmount.doubleValue() * Constants.zeroPOnePercent);
		}
		return null;
	}

	private void updateDestinationAccounts() {
		destinationAccountMap.put("destAccountId", "10042121");
		destinationAccountMap.put("currency", "INR");

	}

	private void updateRateOfExchange() {
		// Rate Of Interest to be calculated based on USD

		roiMap.put("INR", new BigDecimal(83.2810));
		roiMap.put("EUR", new BigDecimal(0.907264));
	}

}
