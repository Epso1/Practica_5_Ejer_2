package com.example.practica_5_ejer_2;

import javafx.collections.ListChangeListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;

public class Downloader implements ListChangeListener<String> {
    @Override
    public void onChanged(Change<? extends String> c) {
        while (c.next()) {
            if (c.wasAdded()) {
                for (String url : c.getAddedSubList()) {
                    CompletableFuture.supplyAsync(() -> download(url))
                            .thenAccept(content -> saveToFile(url, content));
                }
            }
        }
    }

    private byte[] download(String urlString) {
        try {
            URL url = new URL(urlString);
            try (InputStream in = new BufferedInputStream(url.openStream())) {
                return in.readAllBytes();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al descargar URL: " + urlString, e);
        }
    }

    private void saveToFile(String url, byte[] content) {
        Path path = Path.of(url.replace('/', '_') + ".html");
        try {
            Files.write(path, content, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar al directorio: " + path, e);
        }
    }
}