package com.levimartines.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.levimartines.hrpayroll.models.Payment;
import com.levimartines.hrpayroll.models.Worker;

@Service
public class PaymentService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${hr-worker.host}")
	private String workersHost;

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));

		Worker worker = restTemplate.getForObject(workersHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
