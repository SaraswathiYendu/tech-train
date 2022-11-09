package com.sonarqube.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

	public String getMessage(String name) {
		Map<String,String> map = getData();
		return map.get(name);
	}
	
	Map<String,String> getData(){
		Map<String,String> map = new HashMap<>();
		map.put("john", "Hey john, You have a call at 12.30PM today with freedy team");
		map.put("geoff", "Hey geoff, You have a call at 10AM today with toyota team");
		map.put("emma", "Hey emma, You have a call at 12.30PM today with freedy team");
		return map;
	}
	
}
 