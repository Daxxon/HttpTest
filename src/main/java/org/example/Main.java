package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, String> formData = new HashMap<>();
        formData.put("name", "dwaggoner@blackwidowimaging.com");
        formData.put("pass", "3k=4;sP4BMhp");
        formData.put("form_build_id", "form-a0vRrFU65mSjE_ny8w_rvsv5aveRFa8Z99m3bLeB33g");
        formData.put("form_id", "user_login");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(formData);

        System.out.println(objectMapper.writeValueAsString(formData));
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://dealers.3iblackwidow.com/"))
                .header("Accept-Encoding", "gzip,deflate,br")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.toString());
    }
}