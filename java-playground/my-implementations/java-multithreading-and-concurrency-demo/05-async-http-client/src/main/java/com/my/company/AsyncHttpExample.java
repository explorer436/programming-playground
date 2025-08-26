package com.my.company;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class AsyncHttpExample {

    public static void main(String[] args) {

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        List<String> urls = List.of(
                "https://api.example.com/data1",
                "https://api.example.com/data2",
                "https://api.example.com/data3"
        );

        List<CompletableFuture<HttpResponse<String>>> futures = urls.stream()
                .map(url -> {

                    HttpRequest request = HttpRequest.newBuilder()
                            .GET()
                            .uri(URI.create(url))
                            .timeout(Duration.ofSeconds(3))
                            .build();

                    return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                            .exceptionally(e -> null);
                })
                .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(v -> futures.forEach(f -> {
                    HttpResponse<String> response = f.join();
                    if (response != null) {
                        System.out.println(response.statusCode() + " -> " + response.body().substring(0, 100) + "...");
                    } else {
                        System.out.println("Request failed or timed out");
                    }

                })).join();
    }
}
