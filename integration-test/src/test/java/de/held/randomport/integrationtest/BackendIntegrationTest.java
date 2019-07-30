package de.held.randomport.integrationtest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BackendIntegrationTest {

	private static String backendUrl;

	@BeforeAll
	public static void ReadBackendUrl() {
		String backendHost = System.getProperty("backend.host");
		String backendPort = System.getProperty("backend.tcp.8080");
		backendUrl = "http://" + backendHost + ":" + backendPort;
	}

	@Test
	public void TestBackendExampleEndpoint() throws Exception {
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(new URI(backendUrl + "/example"))
				.build();
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

		Assertions.assertEquals("foo", response.body());
	}

}
