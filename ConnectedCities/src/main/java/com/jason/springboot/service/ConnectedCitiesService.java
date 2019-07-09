package com.jason.springboot.service;

import java.util.List;

import com.jason.springboot.domain.Path;

public interface ConnectedCitiesService {
	
	List<Path> getPaths();
	
	boolean isTherePath(String origin, String destination);

}
