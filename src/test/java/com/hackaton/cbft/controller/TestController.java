package com.hackaton.cbft.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hackaton.cbft.Controller.PaymentsController;
import com.hackaton.cbft.Model.PaymentRequest;
import com.hackaton.cbft.Model.PaymentResponse;
import com.hackaton.cbft.exceptions.DailyLimitException;
import com.hackaton.cbft.exceptions.DestinationAccountNotFoundException;
import com.hackaton.cbft.service.PaymentService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestController {

	@Mock
	PaymentService PaymentService;
	
	@Mock
	PaymentsController paymentsController;
	
	PaymentRequest paymentRequest;
	@org.junit.Before
	public void init(){
		 paymentRequest = new PaymentRequest();
		paymentRequest.setDestAccountId(10042121L);
		paymentRequest.setRequestId(1L);
		paymentRequest.setSourceAccountId(121212L);
		paymentRequest.setSourceAmount(new BigDecimal(100));
		paymentRequest.setSourceCurrency("USD");
		
	}
	
	@Test
	public void successTest()
	{
		
		ResponseEntity<PaymentResponse> response = paymentsController.transferAmount(paymentRequest);
		assertThat(response);	
	}
	
	@Test(expected = DestinationAccountNotFoundException.class)
	public void destinationAccountNotFound()
	{
		paymentRequest.setDestAccountId(1111111L);
		ResponseEntity<PaymentResponse> response = paymentsController.transferAmount(paymentRequest);
		assertThat(response);	
	}
	
	@Test(expected = DailyLimitException.class)
	public void dailyLimitExceeded()
	{
		paymentRequest.setSourceAmount(new BigDecimal(60000));
		ResponseEntity<PaymentResponse> response = paymentsController.transferAmount(paymentRequest);
		assertThat(response);	
	}
}
