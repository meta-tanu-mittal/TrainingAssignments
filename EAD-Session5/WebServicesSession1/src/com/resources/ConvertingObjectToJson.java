package com.resources;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class ConvertingObjectToJson {
	public static String toJSON(Object object) throws IOException{
		return (new ObjectMapper()).writeValueAsString(object);
	}

}
