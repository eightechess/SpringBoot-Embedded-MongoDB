package com.verizon.controller;

import java.util.List;
import com.verizon.repo.HttpParametersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.verizon.model.HttpParameters;

@RestController
class HttpParametersController {
	
	@Autowired
	private HttpParametersRepo httpParametersRepo;

	@Autowired
	private KafkaTemplate<String, HttpParameters> kafkaTemplate;
	
	@GetMapping ("/getAllParameters")
	public List<HttpParameters> gethttpParameters(){
		return httpParametersRepo.findAll();
	}
	
	@PostMapping("/addParameters")
	public String saveHttpParameters(@RequestBody HttpParameters httpParameters) {
		httpParametersRepo.save(httpParameters);
		kafkaTemplate.send("verizon",httpParameters);
		return "Parameters "+httpParameters.getKey() +" saved";
	}

	@KafkaListener(topics = "verizon",  groupId = "group_json", containerFactory = "httpParametersKafkaListenerFactory")
	public void kafkaConsumer(HttpParameters httpParameters) {
		System.out.println("Consumed Message: " + httpParameters);

	}
}
