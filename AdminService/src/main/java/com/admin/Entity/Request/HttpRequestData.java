package com.admin.Entity.Request;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpRequestData {
	private String methodType;
	private String baseUrl;
	private String endPoint;
	private Map<String, String> headers;
	private String jsonBody;
}

