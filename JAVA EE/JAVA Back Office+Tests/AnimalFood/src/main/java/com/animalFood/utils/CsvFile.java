package com.animalfood.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class CsvFile {
	private String filename;
	
	public CsvFile(String filename) {
		this.filename = filename;
	}
	public HashMap<String, String> load(String separator) throws IOException {
		HashMap<String, String> entries = new HashMap<String, String>();
    	List<String> allLines = Files.readAllLines(Paths.get(this.filename), StandardCharsets.UTF_8);
    	
		for(String line : allLines) {
			String[] parts = line.split(separator);
			
			entries.put(parts[0], parts[1]); 
		}
	    return entries; 
	}
}
