package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Map<String, String> formData = new HashMap<>();
//        formData.put("name", "dwaggoner@blackwidowimaging.com");
//        formData.put("pass", "3k=4;sP4BMhp");
//        formData.put("form_build_id", "form-a0vRrFU65mSjE_ny8w_rvsv5aveRFa8Z99m3bLeB33g");
//        formData.put("form_id", "user_login");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String requestBody = objectMapper
//                .writeValueAsString(formData);
//
//        System.out.println(objectMapper.writeValueAsString(formData));
//
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("https://dealers.3iblackwidow.com/poage-chevrolet-buick.csv"))
//                .header("Accept-Encoding", "gzip,deflate,br")
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//
//        HttpResponse<String> response = HttpClient.newBuilder()
//                .build()
//                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println("Response: " + response.toString());
        char[] array = new char[1000];
        InputStream input = new URL("https://dealers.3iblackwidow.com/Octane-Buick-GMC.csv").openStream();
        Reader reader = new InputStreamReader(input, "UTF-8");
        reader.read(array);

        StringBuilder myString = new StringBuilder();
        for (char c : array) {
            myString.append(c);
        }

        System.out.println("Data in the stream:");
        System.out.println(myString);
        // Closes the reader
        input.close();
    }
}