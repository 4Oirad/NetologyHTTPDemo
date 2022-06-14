import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Closeable;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.List;

public class Main implements Closeable, HttpClient, CloseableHttpClient {

    public static final String REMOTE_SERVICE_URI = "https://jsonplaceholder.typicode.com/posts"
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        public static final String REMOTE_SERVICE_URI = "https://jsonplaceholder.typicode.com/posts";
        public static final ObjectMapper mapper = new ObjectMapper();
        public static void main(String[] args) throws IOException {
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    .setUserAgent("My Test Service")
                    .setDefaultRequestConfig(RequestConfig.custom()
                            .setConnectTimeout(5000)
                            .setSocketTimeout(30000)
                            .setRedirectsEnabled(false)
                            .build())
                    .build();
            HttpGet request = new HttpGet(REMOTE_SERVICE_URI);
            request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
            CloseableHttpResponse response = httpClient.execute(request);
            Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
            List<Post> posts = mapper.readValue(response.getEntity().getContent(), new TypeReference<List<Post>>() {});
            posts.forEach(System.out::println);
        }
    }
}
