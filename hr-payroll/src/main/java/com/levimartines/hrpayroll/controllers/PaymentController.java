package com.levimartines.hrpayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.levimartines.hrpayroll.models.Payment;
import com.levimartines.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/{workerId}/days/{days}")
	@ResponseStatus(HttpStatus.OK)
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	public Payment getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		return paymentService.getPayment(workerId, days);
	}

	public Payment getPaymentAlternative(Long workerId, Integer days){
		return new Payment("", 0.0, days);
	}
}
