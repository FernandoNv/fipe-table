package com.example.fipetable.service;

import com.example.fipetable.exception.DataNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsumer {
    private final HttpClient httpClient;
    private final String API_URL = "https://parallelum.com.br/fipe/api/v1/";

    public APIConsumer(){
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getData(String option) throws IOException, InterruptedException, DataNotFoundException {
        String url = API_URL + option;
        System.out.println(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() != 200){
            throw new DataNotFoundException("Something happened with the request. Try again later");
        }

        return response.body();
    }
}
