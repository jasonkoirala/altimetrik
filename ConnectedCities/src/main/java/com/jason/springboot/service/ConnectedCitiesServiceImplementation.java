package com.jason.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason.springboot.domain.Path;
import com.jason.springboot.repository.ConnectedCitiesRepository;


@Service
public class ConnectedCitiesServiceImplementation implements ConnectedCitiesService {

	@Autowired
	private ConnectedCitiesRepository citiesRepo;


	@Override
	public List<Path> getPaths() {
		return citiesRepo.loadPaths();
	}

	@Override
	public boolean isTherePath(String origin, String destination) {		

		HashMap<String, String> path = citiesRepo.loadHashedPaths();

		

		if (path.containsKey(origin)) {
			if (path.get(origin).equals(destination)) {
				return true;
			} else if (path.get(origin).equals(path.get(destination))) {
				return true;
			} else {
				return printResult(path, origin, destination);
			}

		} else {
			return printResult(path, origin, destination);
		}
	}


	private static boolean printResult(Map<String, String> dataSet, String origin, String destination) 
	{ 
		
		Map<String, String> reverseMap = new HashMap<String, String>(); 

		for (Map.Entry<String,String> entry: dataSet.entrySet()) 
			reverseMap.put(entry.getValue(), entry.getKey()); 

		if (reverseMap.containsKey(origin) && (reverseMap.get(origin).equals(destination))) {
			return true;
		}
		
		String start = origin; 
		String to = dataSet.get(start);

		if (dataSet.containsKey(to)) {
			return true;
		}
		
		if (to == null) {
			to = reverseMap.get(start);
		} 
				
		while (to != null) 
		{ 
			
			start = to; 
			to = reverseMap.get(to); 

			if (destination.equals(to)) {
				return true;
			}
		}

		return false;
	} 
}
