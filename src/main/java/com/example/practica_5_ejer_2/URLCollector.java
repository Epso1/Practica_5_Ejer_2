package com.example.practica_5_ejer_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class URLCollector {
    private final ObservableList<String> urls = FXCollections.observableArrayList();

    public void addObserver(Downloader observer) {
        urls.addListener(observer);
    }

    public void addURL(String url) {
        urls.add(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        Future<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).whenComplete((response, error) -> {

            String fileName = url.replaceAll("[^a-zA-Z0-9.-]", "_") + ".html";

            Path responseFilePath = Paths.get(fileName);
            try {
                Files.writeString(responseFilePath, response, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Error al guardar la respuesta en el archivo: " + responseFilePath, e);
            }
        });

        while (!future.isDone()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}