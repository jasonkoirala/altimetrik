package com.jason.springboot.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jason.springboot.config.DataLoader;
import com.jason.springboot.domain.Path;


@Repository
public class ConnectedCitiesRepositoryImplementation implements ConnectedCitiesRepository {

	@Autowired
	private DataLoader dataLoader;
	
	@Override
	public List<Path> loadPaths() {	
		return dataLoader.getLoadedPaths();
	}

	@Override
	public HashMap<String, String> loadHashedPaths() {
		return dataLoader.getHashedPaths();
	}

}
