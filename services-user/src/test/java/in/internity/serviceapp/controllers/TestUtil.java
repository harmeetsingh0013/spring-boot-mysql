package in.internity.serviceapp.controllers;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;


public class TestUtil {
	
	public static <T> String objectToJson(T obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		}catch(Exception ex) {
			ex.printStackTrace();
			return "{}";
		}
		
	}

	public static <T> Optional<T> jsonToObject(String json, Class<T> classOf) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return Optional.of(mapper.readValue(json, classOf));
		}catch(Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}
}
