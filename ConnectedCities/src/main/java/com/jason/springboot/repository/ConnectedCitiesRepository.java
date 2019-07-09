package com.jason.springboot.repository;

import java.util.HashMap;
import java.util.List;

import com.jason.springboot.domain.Path;

public interface ConnectedCitiesRepository {
	
	List<Path> loadPaths();
	HashMap<String, String> loadHashedPaths();
}
