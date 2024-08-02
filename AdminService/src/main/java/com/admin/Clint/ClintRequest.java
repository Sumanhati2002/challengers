package com.admin.Clint;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.admin.Entity.Request.HttpRequestData;

public class ClintRequest {
	public String getData(HttpRequestData httpRequestData) {
		String jsonBody = "";
		try {
			String url = httpRequestData.getBaseUrl() + httpRequestData.getEndPoint();

			// Create HttpClient
			HttpClient client = HttpClient.newHttpClient();

			// JSON request body
			if (!(httpRequestData.getJsonBody()==null)) {
				jsonBody = httpRequestData.getJsonBody();
			}

			String methodType = httpRequestData.getMethodType().toUpperCase();
			HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(new URI(url))
					.timeout(Duration.ofSeconds(10)).method(methodType, HttpRequest.BodyPublishers.ofString(jsonBody));
			// Add headers to the request
			if (!(httpRequestData.getHeaders()==null)) {
				httpRequestData.getHeaders().forEach(requestBuilder::header);
			}
			HttpRequest request = requestBuilder.build();

			// Send request
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//			// Print response
//			System.out.println("Status Code: " + response.statusCode());
//			System.out.println("Response Body: " + response.body());
			return response.body();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
