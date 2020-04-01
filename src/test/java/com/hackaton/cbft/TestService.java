package com.hackaton.cbft;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hackaton.cbft.Model.PaymentRequest;
import com.hackaton.cbft.Model.PaymentResponse;
import com.hackaton.cbft.service.PaymenrServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestService {
	
	@Mock
	PaymentRequest paymentRequest;
	
	@Mock
	PaymenrServiceImpl paymentService;
	
	PaymentResponse paymentResponse ;
	
	@org.junit.Before
	public void init()
	{
		paymentRequest = new PaymentRequest();
		paymentRequest.setDestAccountId(10042121L);
		paymentRequest.setRequestId(1L);
		paymentRequest.setSourceAccountId(121212L);
		paymentRequest.setSourceAmount(new BigDecimal(100));
		paymentRequest.setSourceCurrency("USD");
		
		paymentResponse.setExchangeRate(new BigDecimal(83.28100000000000591171556152403354644775390625));
		paymentResponse.setFinalAmount(new BigDecimal(414905.2757520000294562123599462211132049560546875));
		paymentResponse.setProceesingFee(new BigDecimal(1666.286248000000114188878796994686126708984375));
		paymentResponse.setSourceAmount(new BigDecimal(5002));
		paymentResponse.setSourceCurrency("USD");
	}

	@Test
	public void processSuccessfulPayment()
	{
		PaymentResponse response = paymentService.processPayment(paymentRequest);
		assertEquals(paymentResponse, response);
		
	}
}
