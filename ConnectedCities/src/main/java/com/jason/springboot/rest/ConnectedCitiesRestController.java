package com.jason.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jason.springboot.domain.GlobalResponse;
import com.jason.springboot.service.ConnectedCitiesService;

@RestController
@RequestMapping("/api")
public class ConnectedCitiesRestController {
	
	@Autowired
	private ConnectedCitiesService connectedCityService;
	
	@GetMapping("/connected")
	@CrossOrigin
	public ResponseEntity<?> isConnected(
										@RequestParam(name="origin", required = true) String origin,
										@RequestParam(name="destination", required = true) String destination
										) {
		
		boolean result = connectedCityService.isTherePath(origin, destination);
		
		if (result) {
			return new ResponseEntity<>(new GlobalResponse(false, "Path between "+origin+ " and "+destination+" successfully found.", origin, destination), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new GlobalResponse(true, "Path between "+origin+ " and "+destination+" not found.", origin, destination), HttpStatus.NOT_FOUND);

		}
	}

}
