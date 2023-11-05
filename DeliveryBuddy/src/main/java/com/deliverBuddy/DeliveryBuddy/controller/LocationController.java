package com.deliverBuddy.DeliveryBuddy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverBuddy.DeliveryBuddy.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation() {	
		for(int i = 1; i <= 20000; i++) {
			this.kafkaService.updateLocation("( " +  Math.round(Math.random() * 1000)+ ", "+ Math.round(Math.random() * 1000) +" )");
		}	
		System.out.println("Message Produced");
		return new ResponseEntity<>(Map.of(), HttpStatus.OK);	
	}

}
