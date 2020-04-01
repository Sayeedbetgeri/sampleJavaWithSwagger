package com.hackaton.cbft.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.cbft.Model.PaymentRequest;
import com.hackaton.cbft.Model.PaymentResponse;
import com.hackaton.cbft.service.PaymentService;

@RestController
public class PaymentsController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping(value = "/transfer")
	public ResponseEntity<PaymentResponse> transferAmount(@RequestBody PaymentRequest paymentRequest)
	{
		PaymentResponse paymentResponse=paymentService.processPayment(paymentRequest);
		
		return new ResponseEntity<>(paymentResponse,HttpStatus.OK);
	}
}
