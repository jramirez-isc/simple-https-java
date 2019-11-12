import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Https11SimpleClient {

	public static void main(String[] args) throws Exception {

		System.out.println("javax.net.ssl.trustStore: " + System.getProperty("javax.net.ssl.trustStore"));
	        System.out.println("javax.net.ssl.trustStorePassword: " + System.getProperty("javax.net.ssl.trustStorePassword"));

		HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_1_1).proxy(ProxySelector.getDefault())
				.build();

		long start = System.currentTimeMillis();

		HttpRequest mainRequest = HttpRequest.newBuilder().uri(URI.create("https://localhost:5000/test")).build();

		HttpResponse<String> mainResponse = httpClient.send(mainRequest, BodyHandlers.ofString());

		System.out.println("Main response status code: " + mainResponse.statusCode());
		System.out.println("Main response headers: " + mainResponse.headers());
		String responseBody = mainResponse.body();
		System.out.println(responseBody);

		long end = System.currentTimeMillis();
		System.out.println("Total load time: " + (end - start) + " ms");

	}

}
