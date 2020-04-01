package com.hackaton.cbft.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.cbft.Model.PaymentRequest;
import com.hackaton.cbft.Model.PaymentResponse;

@RestController
public class PaymentsController {

	
	@PostMapping(value = "/transfer")
	private ResponseEntity<PaymentResponse> transferAmount(@RequestBody PaymentRequest paymentRequest)
	{
		PaymentResponse paymentResponse=null;
		
		return new ResponseEntity<>(paymentResponse,HttpStatus.OK);
	}
}
