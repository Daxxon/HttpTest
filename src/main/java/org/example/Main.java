package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream input = new URL("https://dealers.3iblackwidow.com/Octane-Buick-GMC.csv").openStream();
        Scanner scanner = new Scanner(input).useDelimiter("/n");
        String result = scanner.hasNext() ? scanner.next() : "";
        input.close();

        BufferedReader bufferedReader = new BufferedReader(new StringReader(result));
        String line = null;
        List<String> vins = new ArrayList<>();
        Map<String,String> individualVehicle = new HashMap<>();
        String[] keys = bufferedReader.readLine().split("\",\"");
        while ((line = bufferedReader.readLine()) != null){
            individualVehicle = new HashMap<>();
            String[] lineArr = line.split("\",\"");
            for (int i=0; i<(lineArr.length-1); i++) {
                individualVehicle.put(keys[i].toString().replace("\"", ""), lineArr[i].toString().replace("\"",""));
            }
            vins.add(individualVehicle.get("VIN"));
        }
        bufferedReader.close();
        for (String vin : vins) {
            System.out.println(vin);
        }
    }
}