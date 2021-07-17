package com.levimartines.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levimartines.hrpayroll.feignclients.WorkerFeignClient;
import com.levimartines.hrpayroll.models.Payment;
import com.levimartines.hrpayroll.models.Worker;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
