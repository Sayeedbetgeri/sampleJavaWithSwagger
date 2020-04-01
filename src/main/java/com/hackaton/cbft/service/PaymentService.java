package com.hackaton.cbft.service;

import com.hackaton.cbft.Model.PaymentRequest;
import com.hackaton.cbft.Model.PaymentResponse;

public interface PaymentService {

	PaymentResponse processPayment(PaymentRequest paymentRequest);
	
}
