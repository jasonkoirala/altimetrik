package com.jason.springboot.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.jason.springboot.domain.Path;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ResourceLoader resourceLoader;
	
	private List<Path> paths = null;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			
			Resource resource =  resourceLoader.getResource("classpath:static/path.txt");
			File loadedFile = resource.getFile();
			
			
			if (loadedFile != null) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(loadedFile));
				paths = new ArrayList<>();
				String line = bufferedReader.readLine();
				
				while (line != null) {					
					String[] twoPaths = line.split(",");
					paths.add(new Path(twoPaths[0], twoPaths[1]));
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
			}
			
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} 
		
	}
	
	public List<Path> getLoadedPaths() {
		return paths;
	}

	public HashMap<String, String> getHashedPaths() {
		HashMap<String, String> path = new HashMap<>();
		for (Path p: paths) {
			path.put(p.getOrigin(), p.getDestination());
		}
		
		return path;
	}
}
