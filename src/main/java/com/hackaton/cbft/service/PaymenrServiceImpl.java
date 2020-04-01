package com.hackaton.cbft.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hackaton.cbft.Model.PaymentRequest;
import com.hackaton.cbft.Model.PaymentResponse;
import com.hackaton.cbft.exceptions.DestinationAccountNotFoundException;

public class PaymenrServiceImpl  implements PaymentService{

	Map<String,String> destinationAccountMap = new HashMap<>();
	Map<String, BigDecimal> roiMap = new HashMap<>();
	
	
	@Override
	public PaymentResponse processPayment(PaymentRequest paymentRequest) {
		updateDestinationAccounts();
		Long destinationAccountId = (Long)paymentRequest.getDestAccountId();
		if(!(destinationAccountMap.containsKey(destinationAccountId)))
		{
			throw new DestinationAccountNotFoundException();
		}
		
		String destCurrency = destinationAccountMap.get("currency");
		//calculateRateOfExchange(paymentRequest.getSourceCurrency(),destCurrency);
		
		return null;
	}


	


	private void updateDestinationAccounts() {
		destinationAccountMap.put("destAccountId", "10042121");
		destinationAccountMap.put("currency", "INR");
		
		
	}
	private void updateRateOfExchange()
	{
		//Rate Of Interest to be calculated based on USD
		
		roiMap.put("INR",new BigDecimal(83.2810));
		roiMap.put("EUR",new BigDecimal(0.907264));
	}

}
