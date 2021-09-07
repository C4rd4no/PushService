package PushService;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;
import java.util.Map;

public class PushRequestManager {

    private PushJsonConverter jsonConverter;

    public PushRequestManager() {
        this.jsonConverter = new PushJsonConverter();
    }

    public void sendPostRequest(Map<String, Object> body, String urlParameter){

        StringEntity finalBody = this.getRequestBody(body);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(this.getRequestUrl(urlParameter));
        request.setEntity(finalBody);
        System.out.println(urlParameter);
        this.executeRequest(httpClient,request);

        httpClient.getConnectionManager().shutdown();
    }

    private void executeRequest(HttpClient httpClient, HttpPost request) {

        HttpResponse response = null;
        try {
            response = httpClient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response.getStatusLine()); //TODO
    }

    private String getRequestUrl(String urlParameter) {

        String url = "http://localhost:8080"; //TODO

        return url + urlParameter;
    }


    private StringEntity getRequestBody (Map<String, Object> body) {

        String jsonBody = this.jsonConverter.convertToJson(body);
        StringEntity entityBody = new StringEntity(jsonBody, ContentType.APPLICATION_JSON);

        return entityBody;
    }
}
